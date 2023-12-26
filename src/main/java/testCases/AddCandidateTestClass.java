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

	PageBaseClass pageBaseClass;
	LoginPageClass loginPageClass;
	DashboardPageClass dashboardPageClass;
	TopNavBarClass topNavBarClass;
	AddCandidatePageClass addCandidatePageClass;
	CandidateDetailsPageClass candidateDetailsPageClass;
	
	// Method to Test the Functionality of Adding a Candidate
	@Test
	public void addCandidateTest() {
		logger = report.createTest("Add Candidate Test : 1"); // Create Report for New Test
		pageBaseClass = new PageBaseClass(driver, logger, testStep);
		PageFactory.initElements(driver, pageBaseClass);
		loginPageClass = pageBaseClass.openPage(Constants.loginPageURL); // Open Login Page
		dashboardPageClass = loginPageClass.login(Constants.email, Constants.password); // Login and Open Dashboard Page
		topNavBarClass = dashboardPageClass.getTopNavBarClass();
		addCandidatePageClass = topNavBarClass.openAddCandidatePage(); // Open Add Candidate Page
		candidateDetailsPageClass = addCandidatePageClass.addCandidate(Constants.candidateFirstName, Constants.candidateLastName); // Add the Candidate
	}
	
}
