package Request;

import Utilities.BaseHelper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;

public class RequestBuilder {

    static RequestSpecification reqSpecBuilder;

    public static RequestSpecification requestSpecification() throws IOException {
        if (reqSpecBuilder == null) {
            reqSpecBuilder = new RequestSpecBuilder()
                    .setBaseUri(BaseHelper.getGlobalValue("url"))
                    .setContentType(ContentType.JSON).build();
            return reqSpecBuilder;
        }
        return reqSpecBuilder;
    }
}