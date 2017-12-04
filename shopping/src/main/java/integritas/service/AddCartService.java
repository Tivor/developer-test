package integritas.service;

import integritas.domain.Cart;
import integritas.domain.Product;
import integritas.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by polia on 03/12/2017.
 */
@Service
public class AddCartService {

    @Autowired
    CartRepository cartRepository;

    @Transactional
    public void addToCart(Product product) {

        validateProduct(product);

        Cart cart = new Cart();
        cart.setIdProd(product.getId());
        cartRepository.save(cart);
    }

    protected void validateProduct(Product product) {
        if (product == null || product.getId() == null) {
            throw new RuntimeException("Invalid Product");
        }
    }

}
