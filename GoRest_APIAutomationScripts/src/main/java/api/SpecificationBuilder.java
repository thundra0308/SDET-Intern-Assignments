package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static base.LoggerManager.*;

public class SpecificationBuilder {

    public static RequestSpecification getRequestSpec() {
        info("<---- Initiated : Building Request Specifications");
        RequestSpecification requestSpecification = new RequestSpecBuilder().build();
        requestSpecification.baseUri(PathBuilder.BASE_URL);
        info("Added Base URL = "+PathBuilder.BASE_URL);
        requestSpecification.basePath(PathBuilder.BASE_PATH);
        info("Added Base Path = "+PathBuilder.BASE_PATH);
        requestSpecification.contentType(ContentType.JSON);
        info("Added Content Type = "+ContentType.JSON);
        info("----> Successful : Building Request Specification");
        return requestSpecification;
    }

    public static ResponseSpecification getResponseSpec() {
        info("<---- Initiated : Building Response Specification");
        ResponseSpecification responseSpecification = new ResponseSpecBuilder().build();
        info("----> Successful : Building Response Specification");
        return responseSpecification;
    }

}
