package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import baseClasses.PageBaseClass;
import baseClasses.SideNavBarClass;
import baseClasses.TestBaseClass;
import pageClasses.AdminSettingPageClass;
import pageClasses.CandidateCustomFieldsPageClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import utilities.Constants;

// Class to Test the Functionalities of Adding Candidate Custom Fields'
public class AddCandidateCustomFieldTestClass extends TestBaseClass {

	public PageBaseClass pageBaseClass;
	public LoginPageClass loginPageClass;
	public DashboardPageClass dashboardPageClass;
	public SideNavBarClass sideNavBarClass;
	public AdminSettingPageClass adminSettingPageClass;
	public CandidateCustomFieldsPageClass candidateCustomFieldsPageClass;
	
	// Method to Test the Functionality of Adding a Custom Field in Candidate Model
	@Test
	public void addCandidateCustomFieldTest() {
		logger = report.createTest("Add Candidate Custom Field Test : 1");
		invokeBrowser(Constants.browser);
		pageBaseClass = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBaseClass);
		loginPageClass = pageBaseClass.openPage(Constants.loginPageURL);
		dashboardPageClass = loginPageClass.login(Constants.email, Constants.password);
		sideNavBarClass = dashboardPageClass.getSideNavBarClass();
		adminSettingPageClass = sideNavBarClass.openAdminSettingPage();
		candidateCustomFieldsPageClass = adminSettingPageClass.openCandidateCustomFieldsPage();
		candidateCustomFieldsPageClass.addCustomFields(Constants.customFields);
	}
	
}
