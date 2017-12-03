package integritas.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by igor.veloso.custodio on 03/12/2017.
 */
@Component
public class ProductListener {

    @JmsListener(destination = "integritas.add-cart")
    public void receiveQueue(String produto) {
        System.out.println("=========>>>>>> " + produto);
    }

}
