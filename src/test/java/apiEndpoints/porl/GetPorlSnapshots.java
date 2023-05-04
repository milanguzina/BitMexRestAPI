package apiEndpoints.porl;

import request.Path;
import utilities.BaseHelper;
import utilities.Log4JFilter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static request.RequestBuilder.requestSpecification;


public class GetPorlSnapshots extends BaseHelper {
    static Response response;

    public static void getSnapshots() throws Exception {
        response = RestAssured.given().spec(requestSpecification())
                .filter(new Log4JFilter())
                .when()
                .get(Path.GET_PORL_SNAPSHOTS.getResource())
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        Assertions.assertEquals(getJsonPath(response, "currency[0]"), "XBT");
    }
}

