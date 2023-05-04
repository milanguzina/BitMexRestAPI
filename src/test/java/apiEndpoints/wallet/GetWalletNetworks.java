package apiEndpoints.wallet;

import request.Path;
import utilities.Log4JFilter;
import request.RequestBuilder;
import utilities.BaseHelper;
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
                .get(Path.GET_WALLET_NETWORK.getResource())
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        Assertions.assertTrue(getJsonPath(response,"network").contains("btc"));
    }
}

