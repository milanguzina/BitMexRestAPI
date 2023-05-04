package tests.order;


import apiEndpoints.order.GetOrdBook;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GetOrderBookTest {

    @Test
    public void testGetOrderBook() throws IOException {
        GetOrdBook.getOrderBook();
    }
}
