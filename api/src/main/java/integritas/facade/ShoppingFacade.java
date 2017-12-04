package integritas.facade;

import integritas.domain.Product;
import integritas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Queue;

/**
 * Created by polia on 03/12/2017.
 */
@Service
public class ShoppingFacade {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource(name = "shoppingQ")
    private Queue shoppingQ;

    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Integer id) {
        Product product = productRepository.findOne(id);
        jmsMessagingTemplate.convertAndSend(this.shoppingQ, product);
    }

}
