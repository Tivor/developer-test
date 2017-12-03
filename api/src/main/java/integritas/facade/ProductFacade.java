package integritas.facade;

import integritas.domain.Product;
import integritas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by polia on 03/12/2017.
 */
@Service
public class ProductFacade {

    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    }

}
