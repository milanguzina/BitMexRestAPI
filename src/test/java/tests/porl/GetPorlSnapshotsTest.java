package tests.porl;

import apiEndpoints.porl.GetPorlSnapshots;
import org.junit.jupiter.api.Test;

public class GetPorlSnapshotsTest {

    @Test
    public void testGetPorlSnapshots() throws Exception {
        GetPorlSnapshots.getSnapshots();
    }
}
