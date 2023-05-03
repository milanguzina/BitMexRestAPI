package APIEndpoints.Porl;

import Request.Path;
import Utilities.BaseHelper;
import Utilities.Log4JFilter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static Request.RequestBuilder.requestSpecification;


public class GetPorlSnapshots extends BaseHelper {
    static Response response;

    public static void getSnapshots() throws Exception {
        response = RestAssured.given().spec(requestSpecification())
                .filter(new Log4JFilter())
                .when()
                .get(Path.GetPorlSnapshots.getResource())
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        Assertions.assertEquals(getJsonPath(response, "currency[0]"), "XBT");
    }
}

