package integritas.repository;

import integritas.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by polia on 03/12/2017.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {



}
