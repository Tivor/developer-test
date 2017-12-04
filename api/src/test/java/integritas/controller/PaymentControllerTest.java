package integritas.controller;

import integritas.domain.PaymentInfo;
import integritas.facade.PaymentFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by polia on 04/12/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {

    @Mock
    PaymentFacade paymentFacade;

    @InjectMocks
    PaymentController paymentController;

    @Test
    public void testBuy(){

        PaymentInfo paymentInfo = new PaymentInfo();

        Mockito.doNothing().when(paymentFacade).buyCart(paymentInfo);
        paymentController.buy(paymentInfo);

        verify(paymentFacade).buyCart(paymentInfo);
        verifyNoMoreInteractions(paymentFacade);

    }

}
