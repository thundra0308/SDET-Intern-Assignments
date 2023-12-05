package userModel.deleteUser;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import base.BaseClass;
import utils.Authentication;

public class DeleteUserTestClass extends BaseClass {

	String bearerToken = Authentication.getBearerToken();

	@Test
	public void deleteUserTestCase_1(ITestContext context) {
		initLogger();

		startTestCase("Delete User Test Case : One");

		String uri = generateURI("/users/"+prop.getProperty("USER_ID"));

		deleteRequest(uri, bearerToken, 204);
		
		setProperty("USER_ID", "");

		endTestCase();
	}

}
