package apiEndpoints.user;

import utilities.*;

import request.Path;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.jupiter.api.Assertions;

import static request.HTTPRequest.GET;
import static request.RequestBuilder.requestSpecification;


public class GetUser extends BaseHelper{

    static Response response;

    public static void getUserTest() throws Exception {
        response = RestAssured.given().spec(requestSpecification())
                .header("api-key", getGlobalValue("APIKey"))
                .header("api-expires", expireGenerator())
                .header("api-signature", apiSignatureGenerator(GET.getRequestType(), Path.GET_USER.getResource(),""))
                .filter(new Log4JFilter())
                .when()
                .get(Path.GET_USER.getResource())
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        Assertions.assertEquals(getJsonPath(response,"id"),"408888");
    }
}
