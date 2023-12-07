package userModel.deleteUser;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import base.BaseClass;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.Authentication;

public class DeleteUserTestClass extends BaseClass {

	String bearerToken = Authentication.getBearerToken();

	// Test Method to Delete the Created User
	@Test
	public void deleteUserTestCase_1(ITestContext context) {
		// Initialize the Log4J
		initLogger();

		// Start the Test Case
		startTestCase("Delete User Test Case : One");

		// Generate Full URI
		String uri = generateURI("/users/"+getProperty("USER_ID"));

		// Send Request and Capture Response
		deleteRequest(uri, bearerToken, 204);
		
		setProperty("USER_ID", "");

		endTestCase();
	}

}
