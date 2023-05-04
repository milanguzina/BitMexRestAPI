package apiEndpoints.order;

import utilities.*;
import request.Path;
import request.RequestBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static request.HTTPRequest.GET;

public class GetAnOrder extends BaseHelper {

    static Response response;

     public static void getOrder() throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        response = RestAssured.given().spec(RequestBuilder.requestSpecification())
                .header("api-key", getGlobalValue("APIKey"))
                .header("api-expires", expireGenerator())
                .header("api-signature", apiSignatureGenerator(GET.getRequestType(), Path.GET_ORDER.getResource(),""))
                .filter(new Log4JFilter())
                .when()
                .get(Path.GET_ORDER.getResource())
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();
    }
}
