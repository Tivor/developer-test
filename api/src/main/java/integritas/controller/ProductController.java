package integritas.controller;

import integritas.domain.Product;
import integritas.facade.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import java.util.List;

/**
 * Created by igor.veloso.custodio on 03/12/2017.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private ProductFacade productFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<Product> listAll() {
        return productFacade.listAllProducts();
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.PUT)
    public void send(@PathVariable("id") Integer id) {
        jmsMessagingTemplate.convertAndSend(this.queue, id);
    }



}
