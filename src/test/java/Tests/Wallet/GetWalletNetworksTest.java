package Tests.Wallet;

import APIEndpoints.Wallet.GetWalletNetworks;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GetWalletNetworksTest {

    @Test

    public void getWalletNetworksTest() throws IOException {
        GetWalletNetworks.getWalletNetworks();
    }
}
