package userModel.getUser;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import base.BaseClass;
import io.restassured.response.Response;
import utils.Authentication;

public class GetUserTestClass extends BaseClass {

	private GetUserResponseModel responseModel;
	private String bearerToken  = Authentication.getBearerToken();

	@Test
	public void getUserTest_1() throws JsonProcessingException {
		// Initialize Log4J
		initLogger();

		// Start the Test Case
		startTestCase("'Get User' Test Case - 1");

		// Generate URI
		String uri = generateURI("/users/"+5809217);

		// Send Request and Capture Response
		Response response = getRequest(uri, bearerToken, 200);

		// Generate Response String
		String responseString = responseToString(response);

		// Generate Response Model from Response String
		responseModel = new GetUserResponseModel();
		responseModel = (GetUserResponseModel) stringToResponseModel(responseModel, responseString, GetUserResponseModel.class);

		printTheResponse(responseModel);

		// End Test Case
		endTestCase();
	}

	public void printTheResponse(GetUserResponseModel responseModel) {
        info("id : "+responseModel.id);
        info("name : "+responseModel.name);
        info("email : "+responseModel.email);
        info("gender : "+responseModel.gender);
        info("status : "+responseModel.status);
	}

}
