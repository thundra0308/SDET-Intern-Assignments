package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseClasses.PageBaseClass;
import baseClasses.TestBaseClass;
import baseClasses.TopNavBarClass;
import pageClasses.AddContactPageClass;
import pageClasses.ContactDetailsPageClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import utilities.Constants;

// Class to Test the Functionalities of Adding Contacts
public class AddContactTestClass extends TestBaseClass {

	public PageBaseClass pageBaseClass;
	public LoginPageClass loginPageClass;
	public DashboardPageClass dashboardPageClass;
	public TopNavBarClass topNavBarClass;
	public AddContactPageClass addContactPageClass;
	public ContactDetailsPageClass contactDetailsPageClass;
	
	// Method to Test the Functionality of Adding a Contact
	@Test
	public void addContactTest() {
		logger = report.createTest("Add Contact Test : 1");
		invokeBrowser(Constants.browser);
		pageBaseClass = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBaseClass);
		loginPageClass = pageBaseClass.openPage(Constants.loginPageURL);
		dashboardPageClass = loginPageClass.login(Constants.email, Constants.password);
		topNavBarClass = dashboardPageClass.getTopNavBarClass();
		addContactPageClass = topNavBarClass.openAddContactPage();
		contactDetailsPageClass = addContactPageClass.addContact(Constants.contactFirstName, Constants.contactLastName, Constants.companiesContactBelongTo);
	}
	
}
