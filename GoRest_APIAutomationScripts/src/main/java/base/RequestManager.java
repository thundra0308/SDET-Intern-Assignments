package base;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestManager extends LoggerManager {

	public Response getRequest(String requestURI, String bearerToken, int statusCode) {
		try {
			info("Initiate : Adding Headers to the Request Body...");
			RequestSpecification requestSpecification = RestAssured.given();
			info("Adding Header : Content Type");
			requestSpecification.contentType(ContentType.JSON);
			info("Added Header");
			info("Adding Header : Bearer Token");
			requestSpecification.header("Authorization", "Bearer " + bearerToken);
			info("Added Header");
			info("Successfull : Added Headers to the Request Body");

			info("Initiate : Sending the Request and Fetching the Response...");
			Response response = requestSpecification.get(requestURI);
			assertThat(response.statusCode(), equalTo(statusCode));
			info("Successfull : Request Sended and Response Fetched");

			return response;
		} catch (Exception e) {
			error("Failed : "+e.getMessage());
			return null;
		}

	}

	public Response postRequest(String requestURI, String requestPayLoad, String bearer_token, int statusCode) {
		try {
			info("Initiate : Adding Headers to the Request Body...");
			RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
			info("Adding Header : Content Type");
			requestSpecification.contentType(ContentType.JSON);
			info("Added Header");
			info("Adding Header : Bearer Token");
			requestSpecification.header("Authorization", "Bearer " + bearer_token);
			info("Added Header");
			info("Successfull : Added Headers to the Request Body");

			info("Initiate : Sending the Request and Fetching the Response...");
			Response response = requestSpecification.post(requestURI);
			assertThat(response.statusCode(), equalTo(statusCode));
			info("Successfull : Request Sended and Response Fetched");

			return response;
		} catch (Exception e) {
			error("Failed : "+e.getMessage());
			return null;
		}
	}

	public Response putRequest(String requestURI, String requestPayLoad, String bearer_token, int statusCode) {
		try {
			info("Initiate : Adding Headers to the Request Body...");
			RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
			info("Adding Header : Content Type");
			requestSpecification.contentType(ContentType.JSON);
			info("Added Header");
			info("Adding Header : Bearer Token");
			requestSpecification.header("Authorization", "Bearer " + bearer_token);
			info("Added Header");
			info("Successfull : Added Headers to the Request Body");

			info("Initiate : Sending the Request and Fetching the Response...");
			Response response = requestSpecification.put(requestURI);
			assertThat(response.statusCode(), equalTo(statusCode));
			info("Successfull : Request Sended and Response Fetched");

			return response;
		} catch (Exception e) {
			error("Failed : "+e.getMessage());
			return null;
		}
	}

	public Response deleteRequest(String requestURI, String bearer_token, int statusCode) {
		try {
			info("Initiate : Adding Headers to the Request Body...");
			RequestSpecification requestSpecification = RestAssured.given();
			info("Adding Header : Content Type");
			requestSpecification.header("Content-Type", "application/json");
			info("Added Header");
			info("Adding Header : Bearer Token");
			requestSpecification.header("Authorization", "Bearer " + bearer_token);
			info("Added Header");
			info("Successfull : Added Headers to the Request Body");

			info("Initiate : Sending the Request and Fetching the Response...");
			Response response = requestSpecification.delete(requestURI);
			assertThat(response.statusCode(), equalTo(statusCode));
			info("Successfull : Request Sended and Response Fetched");

			return response;
		} catch (Exception e) {
			error(e.getMessage());
			return null;
		}
	}

}
