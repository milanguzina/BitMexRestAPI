package APIEndpoints.User;

import Request.Path;
import Request.RequestBuilder;
import Utilities.BaseHelper;
import Utilities.Log4JFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static Request.HTTPRequest.GET;

public class UserEvent extends BaseHelper {

        static Response response;

        public static void getUserEvent() throws IOException, NoSuchAlgorithmException, InvalidKeyException {
            response = RestAssured.given().spec(RequestBuilder.requestSpecification())
                    .header("api-key", getGlobalValue("APIKey"))
                    .header("api-expires", expireGenerator())
                    .header("api-signature", ApiSignatureGenerator(GET.getRequestType(), Path.GetUserEvent.getResource(),""))
                    .filter(new Log4JFilter())
                    .when()
                    .get(Path.GetUserEvent.getResource())
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();

            Assertions.assertEquals(getJsonPath(response,"userEvents.userId[0]"),"408888");
        }
    }
