package APIEndpoints.Order;

import Utilities.*;
import Request.Path;
import Request.RequestBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import pojo.Order;

import static Request.HTTPRequest.POST;

public class CreateAnOrder extends BaseHelper{

    static Response response;

    public static void createOrder() throws Exception {

        Order orderPayload = Order.builder()
                .symbol("XBTUSD")
                .orderQty(100)
                .price(1)
                .ordType("Limit")
                .build();

        response = RestAssured.given().spec(RequestBuilder.requestSpecification())
                .header("api-key", getGlobalValue("APIKey"))
                .header("api-expires", expireGenerator())
                .header("api-signature", ApiSignatureGenerator(POST.getRequestType(), Path.GetOrder.getResource(), mapper.writeValueAsString(orderPayload)))
                .filter(new Log4JFilter())
                .when()
                .body(orderPayload)
                .post(Path.GetOrder.getResource())
                .then()
                .assertThat()
                .statusCode(403)
                .extract()
                .response();

        Assertions.assertTrue(getJsonPath(response, "error.message").equalsIgnoreCase("Access Denied"));
    }
}
