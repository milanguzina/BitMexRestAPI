package tests.user;

import apiEndpoints.user.UserEvent;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class GetUserEventTest {

    @Test
    public void testGetUserEvent() throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        UserEvent.getUserEvent();
    }
}
