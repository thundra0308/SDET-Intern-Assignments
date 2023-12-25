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

	public PageBaseClass pageBaseClass;
	public LoginPageClass loginPageClass;
	public DashboardPageClass dashboardPageClass;
	public TopNavBarClass topNavBarClass;
	public AddCompanyPageClass addCompanyPageClass;
	public CompanyDetailsPageClass companyDetailsPageClass;
	int testStep = 0;
	
	// Method to Test the Functionality of Adding a Company
	@Test
	public void addCompanyTest() {
		logger = report.createTest("Add Company Test : 1");
		testStep = 0;
		invokeBrowser(Constants.browser);
		pageBaseClass = new PageBaseClass(driver, logger, testStep);
		PageFactory.initElements(driver, pageBaseClass);
		loginPageClass = pageBaseClass.openPage(Constants.loginPageURL);
		dashboardPageClass = loginPageClass.login(Constants.email, Constants.password);
		topNavBarClass = dashboardPageClass.getTopNavBarClass();
		addCompanyPageClass = topNavBarClass.openAddCompanyPage();
		companyDetailsPageClass = addCompanyPageClass.addCompany(Constants.companyName, Constants.industryType);
	}
	
}
