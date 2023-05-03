package Tests.Porl;

import APIEndpoints.Porl.GetPorlNonce;
import org.junit.jupiter.api.Test;

public class GetPorlNonceTest {

    @Test

    public void testGetPorlNonce() throws Exception {
        GetPorlNonce.getNonce();
    }
}
