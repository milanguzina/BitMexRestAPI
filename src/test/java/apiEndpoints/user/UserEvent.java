package apiEndpoints.user;

import request.Path;
import request.RequestBuilder;
import utilities.BaseHelper;
import utilities.Log4JFilter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static request.HTTPRequest.GET;

public class UserEvent extends BaseHelper {

        static Response response;

        public static void getUserEvent() throws IOException, NoSuchAlgorithmException, InvalidKeyException {
            response = RestAssured.given().spec(RequestBuilder.requestSpecification())
                    .header("api-key", getGlobalValue("APIKey"))
                    .header("api-expires", expireGenerator())
                    .header("api-signature", apiSignatureGenerator(GET.getRequestType(), Path.GET_USER_EVENT.getResource(),""))
                    .filter(new Log4JFilter())
                    .when()
                    .get(Path.GET_USER_EVENT.getResource())
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();

            Assertions.assertEquals(getJsonPath(response,"userEvents.userId[0]"),"408888");
        }
    }
