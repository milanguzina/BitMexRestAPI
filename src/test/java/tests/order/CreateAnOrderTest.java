package tests.order;

import apiEndpoints.order.CreateAnOrder;

import org.junit.jupiter.api.Test;

public class CreateAnOrderTest {

    @Test
    public void testCreateAnOrder() throws Exception {
        CreateAnOrder.createOrder();
    }
}
