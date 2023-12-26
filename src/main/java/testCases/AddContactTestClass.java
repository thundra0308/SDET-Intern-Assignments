package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseClasses.PageBaseClass;
import baseClasses.TestBaseClass;
import pageClasses.TopNavBarClass;
import pageClasses.AddContactPageClass;
import pageClasses.ContactDetailsPageClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import utilities.Constants;

// Class to Test the Functionalities of Adding Contacts
public class AddContactTestClass extends TestBaseClass {

	PageBaseClass pageBaseClass;
	LoginPageClass loginPageClass;
	DashboardPageClass dashboardPageClass;
	TopNavBarClass topNavBarClass;
	AddContactPageClass addContactPageClass;
	ContactDetailsPageClass contactDetailsPageClass;
	int testStep = 0;
	
	// Method to Test the Functionality of Adding a Contact
	@Test
	public void addContactTest() {
		logger = report.createTest("Add Contact Test : 1"); // Create Report for New Test
		pageBaseClass = new PageBaseClass(driver, logger, testStep);
		PageFactory.initElements(driver, pageBaseClass);
		loginPageClass = pageBaseClass.openPage(Constants.loginPageURL); // Open Login Page
		dashboardPageClass = loginPageClass.login(Constants.email, Constants.password); // Login and Open Dashboard Page
		topNavBarClass = dashboardPageClass.getTopNavBarClass();
		addContactPageClass = topNavBarClass.openAddContactPage(); // Open Add Contact Page
		contactDetailsPageClass = addContactPageClass.addContact(Constants.contactFirstName, Constants.contactLastName, Constants.companiesContactBelongTo); // Add the Contact
	}
	
}
