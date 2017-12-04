package integritas.listener;

import integritas.domain.Product;
import integritas.service.AddCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by igor.veloso.custodio on 03/12/2017.
 */
@Component
public class ShoppingListener {

    @Autowired
    AddCartService addCartService;

    @JmsListener(destination = "integritas.add-cart")
    public void receiveQueue(Product product) {
        addCartService.addToCart(product);
    }

}
