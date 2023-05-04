package apiEndpoints.porl;

import request.Path;
import utilities.BaseHelper;
import utilities.Log4JFilter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static request.HTTPRequest.GET;
import static request.RequestBuilder.requestSpecification;

public class GetPorlNonce extends BaseHelper {

    static Response response;

    public static void getNonce() throws Exception {
        response = RestAssured.given().spec(requestSpecification())
                .header("api-key", getGlobalValue("APIKey"))
                .header("api-expires", expireGenerator())
                .header("api-signature", apiSignatureGenerator(GET.getRequestType(), Path.GET_PORL_NONCE.getResource(),""))
                .filter(new Log4JFilter())
                .when()
                .get(Path.GET_PORL_NONCE.getResource())
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        Assertions.assertEquals(getJsonPath(response,"account"),"408888");
    }
}
