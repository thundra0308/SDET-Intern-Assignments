package userModel.createUser;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;

import base.BaseClass;
import io.restassured.response.Response;
import utils.Authentication;

public class CreateUserTestClass extends BaseClass {

	private CreateUserRequestModel requestModel;
	private CreateUserResponseModel responseModel;
	private String bearerToken  = Authentication.getBearerToken();

	// Test Method to Create a New User
	@Test
	public void createUserTest_1() throws JsonProcessingException {
		// Initialize Log4J Logger
		initLogger();

		// Start the Test
		startTestCase("Create User Test : 1");

		// Generate Data for Request POJO Model using Faker Library
		requestModel = new CreateUserRequestModel();
		generateRequestModelData(requestModel);

		// Serialization of Request POJO Model to String PayLoad
		String payLoad = requestModelToString(requestModel);

		// Generate Full URI
		String uri = generateURI("/users");

		// Send the Request and Capture the Response
		Response response = postRequest(uri, payLoad, bearerToken, 201);

		// Convert the Response to a String
		String responseString = responseToString(response);

		// De-Serialization of Response String to Response POJO Model 
		responseModel = new CreateUserResponseModel();
		responseModel = (CreateUserResponseModel) stringToResponseModel(responseModel, responseString, CreateUserResponseModel.class);

		logResponse(responseModel);

		// End the Test
		endTestCase();
	}

	// Method to Generate Request POJO Model Data
	public void generateRequestModelData(CreateUserRequestModel requestModel) {
		Faker faker = new Faker();

		info("Initiate : Creating Request Body...");

		String name = faker.name().fullName();
		info("name = "+name);
		String gender = faker.demographic().sex();
		info("gender = "+gender);
		String email = faker.internet().emailAddress();
		info("email = "+email);
		String status = faker.options().option("active", "inactive");
		info("status = "+status);

		requestModel.setName(name);
		requestModel.setGender(gender);
		requestModel.setEmail(email);
		requestModel.setStatus(status);

		info("Successfull : Created Request Body");
	}

	// Log the Response Data
	public void logResponse(CreateUserResponseModel responseModel) {
        info("id : "+responseModel.id);
        setProperty("USER_ID", responseModel.id+"");
        info("name : "+responseModel.name);
        info("email : "+responseModel.email);
        info("gender : "+responseModel.gender);
        info("status : "+responseModel.status);
	}

}
