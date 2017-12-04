package integritas.facade;

import integritas.domain.PaymentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.jms.Queue;

/**
 * Created by polia on 03/12/2017.
 */
@Service
public class PaymentFacade {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource(name = "paymentQ")
    private Queue paymentQ;

    public void buyCart(PaymentInfo paymentInfo) {
        if (!isValid(paymentInfo)) throw new RuntimeException("Invalid Payment Info");
        jmsMessagingTemplate.convertAndSend(this.paymentQ, paymentInfo);
    }

    protected boolean isValid(PaymentInfo paymentInfo) {
        return StringUtils.hasText(paymentInfo.getExpiration()) &&
                StringUtils.hasText(paymentInfo.getName()) &&
                StringUtils.hasText(paymentInfo.getNumber());
    }

}
