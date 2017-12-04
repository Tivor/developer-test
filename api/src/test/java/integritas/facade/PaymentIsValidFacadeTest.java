package integritas.facade;

import integritas.domain.PaymentInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import static org.junit.Assert.*;

/**
 * Created by polia on 03/12/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentIsValidFacadeTest {

    private PaymentFacade paymentFacade;

    @Before
    public void setUp() {
        paymentFacade = new PaymentFacade();
    }

    @Test
    public void testIsValid() {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setName("any");
        paymentInfo.setExpiration("any");
        paymentInfo.setNumber("any");

        assertTrue(paymentFacade.isValid(paymentInfo));

    }

    @Test
    public void testIsNotValid() {
        PaymentInfo paymentInfo = new PaymentInfo();

        assertFalse(paymentFacade.isValid(paymentInfo));
        paymentInfo.setName("any");

        assertFalse(paymentFacade.isValid(paymentInfo));
        paymentInfo.setExpiration("any");

        assertFalse(paymentFacade.isValid(paymentInfo));
        paymentInfo.setNumber("any");

    }


}
