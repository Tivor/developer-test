package integritas.service;

import com.mysql.jdbc.StringUtils;
import integritas.domain.PaymentInfo;
import integritas.repository.CartRepository;
import integritas.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by polia on 03/12/2017.
 */
@Service
public class ProcessPaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    CartRepository cartRepository;

    @Transactional
    public void processPayment(PaymentInfo paymentInfo) {

        validatePaymentInfo(paymentInfo);
        paymentRepository.save(paymentInfo);
        cartRepository.deleteAll();
    }

    protected void validatePaymentInfo(PaymentInfo paymentInfo) {
        if (paymentInfo == null ||
                StringUtils.isEmptyOrWhitespaceOnly(paymentInfo.getName()) ||
                StringUtils.isEmptyOrWhitespaceOnly(paymentInfo.getNumber()) ||
                StringUtils.isEmptyOrWhitespaceOnly(paymentInfo.getExpiration())
                ) {
            throw new RuntimeException("Invalid Payment Info");
        }
    }

}
