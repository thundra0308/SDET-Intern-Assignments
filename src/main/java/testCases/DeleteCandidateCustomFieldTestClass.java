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

	public PageBaseClass pageBaseClass;
	public LoginPageClass loginPageClass;
	public DashboardPageClass dashboardPageClass;
	public SideNavBarClass sideNavBarClass;
	public AdminSettingPageClass adminSettingPageClass;
	public CandidateCustomFieldsPageClass candidateCustomFieldsPageClass;
	int testStep;
	
	// Method to Test the Functionality of Deleting Candidate Custom Fields
	@Test
	public void deleteCandidateCustomFieldTest() {
		logger = report.createTest("Delete Custom Field Test : 1");
		testStep = 0;
		invokeBrowser(Constants.browser);
		pageBaseClass = new PageBaseClass(driver, logger, testStep);
		PageFactory.initElements(driver, pageBaseClass);
		loginPageClass = pageBaseClass.openPage(Constants.loginPageURL);
		dashboardPageClass = loginPageClass.login(Constants.email, Constants.password);
		sideNavBarClass = dashboardPageClass.getSideNavBarClass();
		adminSettingPageClass = sideNavBarClass.openAdminSettingPage();
		candidateCustomFieldsPageClass = adminSettingPageClass.openCandidateCustomFieldsPage();
		candidateCustomFieldsPageClass.deleteCustomFields(Constants.deleteCustomFields);
	}
	
}
