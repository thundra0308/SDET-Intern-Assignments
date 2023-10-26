package com.selenium.assignment.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddJob extends Login {
	
	@Test(priority = 5)
	public void addJobTest() {
		
		// Wait for Add Button on Top to be Available
		explicitWait("addBtnTop_css", 30);

		// Click on Add Button on Top
		elementClick("addBtnTop_css");

		// Click on Add Job Icon Button on Appeared Dialog Menu
		elementClick("addJobBtnTop_css");
		
		String pipeline = "Hiring Pipeline 1";
		String pipelineSearchKey = "addJobHiringPipelineSearchInput_css";
		String pipelineSearchResult = "addJobHiringPipelineSearchResult_css";
		select(pipeline,pipelineSearchKey,pipelineSearchResult);
		
		String jobTitle = "Automation Testing";
		elementEnterText("addJobTitle_css", jobTitle);
		
		String numberOfJobs = "2";
		elementClick("addNumberOfJobBox_css");
		String numberOfJobsSearchKey = "addNumberOfJobSearchBox_css";
		String numberOfJobsSearchResult = "addNumberOfJobsResult_css";
		select(numberOfJobs,numberOfJobsSearchKey,numberOfJobsSearchResult);
		
		String jobCompany = "Capsule Corporation";
		String jobCompanySearchKey = "addJobCompanySearchInput_css";
		String jobCompanySearchResult = "addJobCompanySearchResult_css";
		select(jobCompany,jobCompanySearchKey,jobCompanySearchResult);
		
		explicitWait("addJobPrimaryContactSearchInput_css", 30);
		
		String contactName = "Bulma";
		String contactNameSearchKey = "addJobPrimaryContactSearchInput_css";
		String contactNameSearchResult = "addJobPrimaryContactSeacrhResult_css";
		select(contactName,contactNameSearchKey,contactNameSearchResult);
		
		explicitWait("addJobSubmitBtn_css", 30);
		
		elementClick("addJobSubmitBtn_css");
		
		verifyJobAdded(jobTitle);
		
	}
	
	// Verify that the Required Job has been Added Successfully
	public void verifyJobAdded(String name) {

		explicitWait("addJobSuccessToast_css", 30);
		Assert.assertTrue(getElement("addJobSuccessToast_css").isDisplayed());
		Assert.assertEquals(getElement("jobNameDetailsPage_css").getText(),name);

	}

}
