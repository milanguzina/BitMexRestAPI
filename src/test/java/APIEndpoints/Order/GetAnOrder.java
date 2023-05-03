package APIEndpoints.Order;

import Utilities.*;
import Request.Path;
import Request.RequestBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static Request.HTTPRequest.GET;

public class GetAnOrder extends BaseHelper {

    static Response response;

     public static void getOrder() throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        response = RestAssured.given().spec(RequestBuilder.requestSpecification())
                .header("api-key", getGlobalValue("APIKey"))
                .header("api-expires", expireGenerator())
                .header("api-signature", ApiSignatureGenerator(GET.getRequestType(), Path.GetOrder.getResource(),""))
                .filter(new Log4JFilter())
                .when()
                .get(Path.GetOrder.getResource())
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();
    }
}
