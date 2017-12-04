package integritas.controller;

import integritas.domain.Product;
import integritas.facade.ShoppingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by igor.veloso.custodio on 03/12/2017.
 */
@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingFacade shoppingFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<Product> listAll() {
        return shoppingFacade.listAllProducts();
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.PUT)
    public void add(@PathVariable("id") Integer id) {
        shoppingFacade.addProduct(id);
    }

}
