package tests.wallet;

import apiEndpoints.wallet.GetWalletAssets;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GetWalletAssetsTest {

    @Test
    public void testGetWalletAssets() throws IOException {
        GetWalletAssets.getWalletAssets();
    }
}
