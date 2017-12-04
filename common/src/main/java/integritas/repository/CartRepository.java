package integritas.repository;

import integritas.domain.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by polia on 03/12/2017.
 */
@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {



}
