package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClasses.PageBaseClass;
import baseClasses.TestBaseClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import utilities.Constants;

//Class to Test the Functionalities of Logging In
public class LoginTestClass extends TestBaseClass {

	public PageBaseClass pageBaseClass;
	public LoginPageClass loginPageClass;
	public DashboardPageClass dashboardPageClass;
	int testStep;
	
	// Method to Test the Functionality of Logging In
	@Test
	public void loginTest() {
		logger = report.createTest("Login Test : 1");
		testStep = 0;
		invokeBrowser(Constants.browser);
		pageBaseClass = new PageBaseClass(driver, logger, testStep);
		PageFactory.initElements(driver, pageBaseClass);
		loginPageClass = pageBaseClass.openPage(Constants.loginPageURL);
		dashboardPageClass = loginPageClass.login(Constants.email, Constants.password);
	}
	
}
