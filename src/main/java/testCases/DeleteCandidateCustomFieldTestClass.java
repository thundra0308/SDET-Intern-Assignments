package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import baseClasses.PageBaseClass;
import pageClasses.SideNavBarClass;
import baseClasses.TestBaseClass;
import pageClasses.AdminSettingPageClass;
import pageClasses.CandidateCustomFieldsPageClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import utilities.Constants;

//Class to Test the Functionalities of Deleting Candidate Custom Fields
public class DeleteCandidateCustomFieldTestClass extends TestBaseClass {

	PageBaseClass pageBaseClass;
	LoginPageClass loginPageClass;
	DashboardPageClass dashboardPageClass;
	SideNavBarClass sideNavBarClass;
	AdminSettingPageClass adminSettingPageClass;
	CandidateCustomFieldsPageClass candidateCustomFieldsPageClass;
	
	// Method to Test the Functionality of Deleting Candidate Custom Fields
	@Test
	public void deleteCandidateCustomFieldTest() {
		logger = report.createTest("Delete Custom Field Test : 1"); // Create Report for New Test
		pageBaseClass = new PageBaseClass(driver, logger, testStep);
		PageFactory.initElements(driver, pageBaseClass);
		loginPageClass = pageBaseClass.openPage(Constants.loginPageURL); // Open Login Page
		dashboardPageClass = loginPageClass.login(Constants.email, Constants.password); // Login and Open Dashboard Page
		sideNavBarClass = dashboardPageClass.getSideNavBarClass();
		adminSettingPageClass = sideNavBarClass.openAdminSettingPage(); // Open Admin Setting Page
		candidateCustomFieldsPageClass = adminSettingPageClass.openCandidateCustomFieldsPage(); // Open Candidate Custom Field Page
		candidateCustomFieldsPageClass.deleteCustomFields(Constants.deleteCustomFields); // Delete the Candidate Custom Fields
	}
	
}
