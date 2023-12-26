package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import baseClasses.PageBaseClass;
import baseClasses.TestBaseClass;
import pageClasses.TopNavBarClass;
import pageClasses.AddCompanyPageClass;
import pageClasses.CompanyDetailsPageClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import utilities.Constants;

//Class to Test the Functionalities of Adding Companies
public class AddCompanyTestClass extends TestBaseClass {

	PageBaseClass pageBaseClass;
	LoginPageClass loginPageClass;
	DashboardPageClass dashboardPageClass;
	TopNavBarClass topNavBarClass;
	AddCompanyPageClass addCompanyPageClass;
	CompanyDetailsPageClass companyDetailsPageClass;
	int testStep = 0;
	
	// Method to Test the Functionality of Adding a Company
	@Test
	public void addCompanyTest() {
		logger = report.createTest("Add Company Test : 1"); // Create Report for New Test
		pageBaseClass = new PageBaseClass(driver, logger, testStep);
		PageFactory.initElements(driver, pageBaseClass);
		loginPageClass = pageBaseClass.openPage(Constants.loginPageURL); // Open Login Page
		dashboardPageClass = loginPageClass.login(Constants.email, Constants.password); // Login and Open Dashboard Page
		topNavBarClass = dashboardPageClass.getTopNavBarClass();
		addCompanyPageClass = topNavBarClass.openAddCompanyPage(); // Open Add Company Page
		companyDetailsPageClass = addCompanyPageClass.addCompany(Constants.companyName, Constants.industryType); // Add the Company
	}
	
}
