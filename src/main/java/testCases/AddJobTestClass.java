package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseClasses.PageBaseClass;
import baseClasses.TestBaseClass;
import pageClasses.TopNavBarClass;
import pageClasses.AddJobPageClass;
import pageClasses.DashboardPageClass;
import pageClasses.JobDetailsPageClass;
import pageClasses.LoginPageClass;
import utilities.Constants;

//Class to Test the Functionalities of Adding Jobs
public class AddJobTestClass extends TestBaseClass {

	PageBaseClass pageBaseClass;
	LoginPageClass loginPageClass;
	DashboardPageClass dashboardPageClass;
	TopNavBarClass topNavBarClass;
	AddJobPageClass addJobPageClass;
	JobDetailsPageClass jobDetailsPageClass;
	
	// Method to Test the Functionality of Adding a Job
	@Test
	public void addJobTest() {
		logger = report.createTest("Add Job Test : 1"); // Create Report for New Test
		pageBaseClass = new PageBaseClass(driver, logger, testStep);
		PageFactory.initElements(driver, pageBaseClass);
		loginPageClass = pageBaseClass.openPage(Constants.loginPageURL); // Open Login Page
		dashboardPageClass = loginPageClass.login(Constants.email, Constants.password); // Login and Open Dashboard Page
		topNavBarClass = dashboardPageClass.getTopNavBarClass();
		addJobPageClass = topNavBarClass.openAddJobPage(); // Open Add Job Page
		jobDetailsPageClass = addJobPageClass.addJob(Constants.pipeline, Constants.jobTitle, Constants.vacancy, Constants.companyJobBelongTo, Constants.contactOfCompnay); // Add the Job
	}
	
}
