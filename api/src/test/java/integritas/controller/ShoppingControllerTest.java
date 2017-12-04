package integritas.controller;

import integritas.domain.Product;
import integritas.facade.PaymentFacade;
import integritas.facade.ShoppingFacade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

/**
 * Created by polia on 04/12/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ShoppingControllerTest {

    @Mock
    ShoppingFacade shoppingFacade;

    @InjectMocks
    ShoppingController shoppingController;

    List<Product> products = new ArrayList<>();

    @Before
    public void setUp() {
        Product product = new Product();
        product.setName("Product 1");
        product.setPrice(BigInteger.TEN);

        products.add(product);
    }

    @Test
    public void testListAll() {
        when(shoppingFacade.listAllProducts()).thenReturn(products);
        Iterable<Product> productsResult = shoppingController.listAll();

        List<Product> productList = StreamSupport.stream(productsResult.spliterator(), false).collect(Collectors.toList());

        assertArrayEquals(productList.toArray(), products.toArray());
        verify(shoppingFacade).listAllProducts();
        verifyNoMoreInteractions(shoppingFacade);
    }


}
