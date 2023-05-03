package Utilities;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class Log4JFilter implements Filter {
    private final Logger log = LogManager.getLogger(Log4JFilter.class);
    @Override
    public Response filter(FilterableRequestSpecification reqSpec,
                           FilterableResponseSpecification resSpec,
                           FilterContext filterContext) {

        Response response = filterContext.next(reqSpec, resSpec);

        log.info("Method:");
        log.info(reqSpec.getMethod());

        log.info("URI:");
        log.info(reqSpec.getURI());

        log.info("Request Headers:");
        log.info(reqSpec.getHeaders());

        if (!reqSpec.getQueryParams().isEmpty()) {
            log.info("Request Query Parameters:");
            logMap(reqSpec.getQueryParams());
        }

        if (!reqSpec.getFormParams().isEmpty()) {
            log.info("Request Form Parameters:");
            logMap(reqSpec.getFormParams());
        }

        if (reqSpec.getBody() != null && reqSpec.getBody().toString().equalsIgnoreCase("null")) {
            log.info("Request Body:");
            log.info(reqSpec.getBody().toString());
        }
        log.info("Response Status Code:");
        log.info(response.statusCode());
        log.info("Response Headers:");
        log.info(response.getHeaders());

        log.info("Response Body:");
        log.info(response.getBody().asPrettyString());
        return response;
    }

    private void logMap(Map<String, String> map) {
        map.forEach((key, value) -> log.info("{}:{}", key, value));
    }

}