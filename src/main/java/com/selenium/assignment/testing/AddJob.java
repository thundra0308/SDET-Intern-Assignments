package com.selenium.assignment.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

//Class to Test the Add Job Functionalities
public class AddJob extends LoginAndLogout {
	
	//Test Method to Add Job
	@Test(priority = 5)
	public void addJobTest() {
		
		// Wait for Add Button on Top to be Available
		explicitWait("addBtnTop_css", 30);

		// Click on Add Button on Top
		elementClick("addBtnTop_css");

		// Click on Add Job Icon Button on Appeared Dialog Menu
		elementClick("addJobBtnTop_css");
		
		//Select Hiring Pipeline
		String pipeline = "Hiring Pipeline 1";
		String pipelineSearchKey = "addJobHiringPipelineSearchInput_css";
		String pipelineSearchResult = "addJobHiringPipelineSearchResult_css";
		select(pipeline,pipelineSearchKey,pipelineSearchResult);
		
		//Enter Job Title
		String jobTitle = "Automation Testing";
		elementEnterText("addJobTitle_css", jobTitle);
		
		//Select Number of Job Opening
		String numberOfJobs = "2";
		elementClick("addNumberOfJobBox_css");
		String numberOfJobsSearchKey = "addNumberOfJobSearchBox_css";
		String numberOfJobsSearchResult = "addNumberOfJobsResult_css";
		select(numberOfJobs,numberOfJobsSearchKey,numberOfJobsSearchResult);
		
		//Select the Company, the Job Belong To
		String jobCompany = "Capsule Corporation";
		String jobCompanySearchKey = "addJobCompanySearchInput_css";
		String jobCompanySearchResult = "addJobCompanySearchResult_css";
		select(jobCompany,jobCompanySearchKey,jobCompanySearchResult);
		
		explicitWait("addJobPrimaryContactSearchInput_css", 30);
		
		//Select the Primary Contact that Belongs to the Job Company
		String contactName = "Bulma";
		String contactNameSearchKey = "addJobPrimaryContactSearchInput_css";
		String contactNameSearchResult = "addJobPrimaryContactSeacrhResult_css";
		select(contactName,contactNameSearchKey,contactNameSearchResult);
		
		explicitWait("addJobSubmitBtn_css", 30);
		
		//Click on Submit Button
		elementClick("addJobSubmitBtn_css");
		
		//Verify that the Job has been Added Successfully
		verifyJobAdded(jobTitle);
		
	}
	
	// Verify that the Required Job has been Added Successfully
	public void verifyJobAdded(String name) {

		explicitWait("addJobSuccessToast_css", 30);
		Assert.assertTrue(getElement("addJobSuccessToast_css").isDisplayed());
		Assert.assertEquals(getElement("jobNameDetailsPage_css").getText(),name);

	}

}
