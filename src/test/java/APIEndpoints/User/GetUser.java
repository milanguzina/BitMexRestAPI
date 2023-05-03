package APIEndpoints.User;

import Utilities.*;

import Request.Path;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.jupiter.api.Assertions;

import static Request.HTTPRequest.GET;
import static Request.RequestBuilder.requestSpecification;


public class GetUser extends BaseHelper{

    static Response response;

    public static void getUserTest() throws Exception {
        response = RestAssured.given().spec(requestSpecification())
                .header("api-key", getGlobalValue("APIKey"))
                .header("api-expires", expireGenerator())
                .header("api-signature", ApiSignatureGenerator(GET.getRequestType(), Path.GetUser.getResource(),""))
                .filter(new Log4JFilter())
                .when()
                .get(Path.GetUser.getResource())
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        Assertions.assertEquals(getJsonPath(response,"id"),"408888");
    }
}
