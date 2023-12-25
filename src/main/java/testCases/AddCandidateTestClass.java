package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import baseClasses.PageBaseClass;
import baseClasses.TestBaseClass;
import pageClasses.TopNavBarClass;
import pageClasses.AddCandidatePageClass;
import pageClasses.CandidateDetailsPageClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import utilities.Constants;

//Class to Test the Functionalities of Adding Candidates
public class AddCandidateTestClass extends TestBaseClass {

	public PageBaseClass pageBaseClass;
	public LoginPageClass loginPageClass;
	public DashboardPageClass dashboardPageClass;
	public TopNavBarClass topNavBarClass;
	public AddCandidatePageClass addCandidatePageClass;
	public CandidateDetailsPageClass candidateDetailsPageClass;
	
	// Method to Test the Functionality of Adding a Candidate
	@Test
	public void addCandidateTest() {
		logger = report.createTest("Add Candidate Test : 1");
		int testStep = 0;
		invokeBrowser(Constants.browser);
		pageBaseClass = new PageBaseClass(driver, logger, testStep);
		PageFactory.initElements(driver, pageBaseClass);
		loginPageClass = pageBaseClass.openPage(Constants.loginPageURL);
		dashboardPageClass = loginPageClass.login(Constants.email, Constants.password);
		topNavBarClass = dashboardPageClass.getTopNavBarClass();
		addCandidatePageClass = topNavBarClass.openAddCandidatePage();
		candidateDetailsPageClass = addCandidatePageClass.addCandidate(Constants.candidateFirstName, Constants.candidateLastName);
	}
	
}
