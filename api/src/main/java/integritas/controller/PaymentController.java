package integritas.controller;

import integritas.domain.PaymentInfo;
import integritas.facade.PaymentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created 'by igor.veloso.custodio on 03/12/2017.
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentFacade paymentFacade;

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public void buy(@RequestBody PaymentInfo paymentInfo) {
        paymentFacade.buyCart(paymentInfo);
    }

}
