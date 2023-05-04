package tests.order;

import apiEndpoints.order.GetAnOrder;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class GetOrderTest {

    @Test
    public void testGetOrder() throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        GetAnOrder.getOrder();
    }
}
