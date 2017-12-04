package integritas.repository;

import integritas.domain.PaymentInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by polia on 03/12/2017.
 */
@Repository
public interface PaymentRepository extends CrudRepository<PaymentInfo, Integer> {



}
