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

	public PageBaseClass pageBaseClass;
	public LoginPageClass loginPageClass;
	public DashboardPageClass dashboardPageClass;
	public TopNavBarClass topNavBarClass;
	public AddJobPageClass addJobPageClass;
	public JobDetailsPageClass jobDetailsPageClass;
	int testStep;
	
	// Method to Test the Functionality of Adding a Job
	@Test
	public void addJobTest() {
		logger = report.createTest("Add Job Test : 1");
		testStep = 0;
		invokeBrowser(Constants.browser);
		pageBaseClass = new PageBaseClass(driver, logger, testStep);
		PageFactory.initElements(driver, pageBaseClass);
		loginPageClass = pageBaseClass.openPage(Constants.loginPageURL);
		dashboardPageClass = loginPageClass.login(Constants.email, Constants.password);
		topNavBarClass = dashboardPageClass.getTopNavBarClass();
		addJobPageClass = topNavBarClass.openAddJobPage();
		jobDetailsPageClass = addJobPageClass.addJob(Constants.pipeline, Constants.jobTitle, Constants.vacancy, Constants.companyJobBelongTo, Constants.contactOfCompnay);
	}
	
}
