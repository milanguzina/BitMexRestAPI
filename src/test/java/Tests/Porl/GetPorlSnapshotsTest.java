package Tests.Porl;

import APIEndpoints.Porl.GetPorlSnapshots;
import org.junit.jupiter.api.Test;

public class GetPorlSnapshotsTest {

    @Test
    public void testGetPorlSnapshots() throws Exception {
        GetPorlSnapshots.getSnapshots();
    }
}
