package api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static base.LoggerManager.*;

public class RequestManager extends SpecificationBuilder {

    public static Response get(String basePath, String token) {
        info("<---- Initiated : Sending 'GET' Request and Fetching Response");
        info("Resource Path = "+basePath);
        Response response = given(getRequestSpec()).
                auth().oauth2(token).
                when().get(basePath).
                then().spec(getResponseSpec()).
                extract().
                response();
        info("----> Successful : Sent 'GET' Request and Fetched Response");
        return response;
    }

    public static Response post(String basePath, String token, Object body) {
        info("<---- Initiated : Sending 'POST' Request and Fetching Response");
        info("Resource Path = "+basePath);
        Response response = given(getRequestSpec()).
                body(body).
                auth().oauth2(token).
                when().post(basePath).
                then().spec(getResponseSpec()).
                extract().
                response();
        info("----> Successful : Sent 'POST' Request and Fetched Response");
        return response;
    }

    public static Response put(String basePath, String token, Object body) {
        info("<---- Initiated : Sending 'PUT' Request and Fetching Response");
        info("Resource Path = "+basePath);
        Response response = given(getRequestSpec()).
                body(body).
                auth().oauth2(token).
                when().put(basePath).
                then().spec(getResponseSpec()).
                extract().
                response();
        info("----> Successful : Sent 'PUT' Request and Fetched Response");
        return response;
    }

    public static Response delete(String basePath, String token) {
        info("<---- Initiated : Sending 'PUT' Request and Fetching Response");
        info("Resource Path = "+basePath);
        Response response = given(getRequestSpec()).
                auth().oauth2(token).
                when().delete(basePath).
                then().spec(getResponseSpec()).
                extract().
                response();
        info("----> Successful : Sent 'PUT' Request and Fetched Response");
        return response;
    }

}
