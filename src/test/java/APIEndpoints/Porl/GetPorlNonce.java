package APIEndpoints.Porl;

import Request.Path;
import Utilities.BaseHelper;
import Utilities.Log4JFilter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static Request.HTTPRequest.GET;
import static Request.RequestBuilder.requestSpecification;

public class GetPorlNonce extends BaseHelper {

    static Response response;

    public static void getNonce() throws Exception {
        response = RestAssured.given().spec(requestSpecification())
                .header("api-key", getGlobalValue("APIKey"))
                .header("api-expires", expireGenerator())
                .header("api-signature", ApiSignatureGenerator(GET.getRequestType(), Path.GetPorlNonce.getResource(),""))
                .filter(new Log4JFilter())
                .when()
                .get(Path.GetPorlNonce.getResource())
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        Assertions.assertEquals(getJsonPath(response,"account"),"408888");
    }
}
