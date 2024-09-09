package APIRequests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

public class BaseAPIRequest {

    static Logger log = LogManager.getLogger(BaseAPIRequest.class.getName());

    private static final String baseURI = "https://reqres.in/api";

    protected static RequestSpecBuilder baseSpec() {
        return new RequestSpecBuilder().setContentType(ContentType.JSON).addFilter(new AllureRestAssured())
                .setBaseUri(baseURI)
                .setRelaxedHTTPSValidation()
                .addHeader("content-type", "application/json");
//                .log(LogDetail.ALL);
    }

    // to check status code/s use .then().statusCode(anyOf(is(200), is(201))).extract().response()
//    to add param in url use addPathParam("param", param) ".../url/{param}/target/..."

    protected static Response get(RequestSpecBuilder specBuilder, String urn) {
        return given().spec(specBuilder.build()).get(urn);
    }

    protected static Response post(RequestSpecBuilder specBuilder, String urn) {
        return given().spec(specBuilder.build()).post(urn);
    }

    protected static Response put(RequestSpecBuilder specBuilder, String urn) {
        return given().spec(specBuilder.build()).put(urn);
    }

    protected static Response delete(RequestSpecBuilder specBuilder, String urn) {
        return given().spec(specBuilder.build()).delete(urn);
    }

    protected static Response patch(RequestSpecBuilder specBuilder, String urn) {
        return given().spec(specBuilder.build()).patch(urn);
    }
}
