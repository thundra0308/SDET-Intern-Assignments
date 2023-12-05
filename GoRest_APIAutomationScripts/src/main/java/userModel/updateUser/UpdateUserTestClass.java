package userModel.updateUser;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;

import base.BaseClass;
import io.restassured.response.Response;
import utils.Authentication;

public class UpdateUserTestClass extends BaseClass {

	UpdateUserRequestModel requestModel;
	UpdateUserResponseModel responseModel;
	String bearerToken = Authentication.getBearerToken();

	@Test
	public void updateUserTest_1() throws JsonProcessingException {
		// Initialize Log4j
		initLogger();

		// Start the Test Case
		startTestCase("'Update User' Test Case - 1");

		// Generate Request Model Data
		requestModel = new UpdateUserRequestModel();
		generateRequestModelData(requestModel);

		// Generate PayLoad String from Request Model
		String payLoad = requestModelToString(requestModel);

		// Generate URI
		String uri = generateURI("/users/"+5809217);

		// Send Request and Capture Response
		Response response = putRequest(uri, payLoad, bearerToken, 200);

		// Generate Response String from Response
		String responseString = responseToString(response);

		// Generate Response Model from Response String
		responseModel = new UpdateUserResponseModel();
		responseModel = (UpdateUserResponseModel) stringToResponseModel(responseModel, responseString, UpdateUserResponseModel.class);

		printTheResponse(responseModel);

		// End Test Case
		endTestCase();
	}

	public void generateRequestModelData(UpdateUserRequestModel requestModel) {
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

	public void printTheResponse(UpdateUserResponseModel responseModel) {
        info("id : "+responseModel.id);
        info("name : "+responseModel.name);
        info("email : "+responseModel.email);
        info("gender : "+responseModel.gender);
        info("status : "+responseModel.status);
	}

}
