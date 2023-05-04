package apiEndpoints.order;

import request.Path;
import utilities.BaseHelper;
import utilities.Log4JFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

import static request.RequestBuilder.requestSpecification;

    public class GetOrdBook extends BaseHelper {

        static Response response;

        public static void getOrderBook() throws IOException {
            response = RestAssured.given().spec(requestSpecification())
                    .queryParam("symbol", "XBTUSD")
                    .contentType(ContentType.JSON)
                    .filter(new Log4JFilter())
                    .when()
                    .get(Path.GET_ORDER_BOOK.getResource())
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract()
                    .response();

            Assertions.assertTrue(getJsonPath(response, "symbol").contains("XBTUSD"));
        }
    }


