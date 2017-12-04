package integritas.listener;

import integritas.domain.PaymentInfo;
import integritas.service.ProcessPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by igor.veloso.custodio on 03/12/2017.
 */
@Component
public class PaymentListener {

    @Autowired
    ProcessPaymentService processPaymentService;

    @JmsListener(destination = "integritas.payment-info")
    public void receiveQueue(PaymentInfo paymentInfo) {
        processPaymentService.processPayment(paymentInfo);
    }

}
