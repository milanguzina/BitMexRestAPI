package APIEndpoints.Wallet;

import Request.Path;
import Utilities.Log4JFilter;
import Request.RequestBuilder;
import Utilities.BaseHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class GetWalletNetworks extends BaseHelper {
    static Response response;

    public static void getWalletNetworks() throws IOException {
        response = RestAssured.given().spec(RequestBuilder.requestSpecification())
                .contentType(ContentType.JSON)
                .filter(new Log4JFilter())
                .when()
                .get(Path.GetWalletNetwork.getResource())
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        Assertions.assertTrue(getJsonPath(response,"network").contains("btc"));
    }
}

