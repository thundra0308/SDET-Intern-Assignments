package com.selenium.assignment.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

//Class to Test Add Company Functionalities
public class AddCompany extends LoginAndLogout {

	//Add Company by Filling the Required Details
	@Test(priority = 3)
	public void addCompanyTest() {
		
		logger = report.createTest("Test : Add Company Test");
		
		//Wait for Add Button on Top to be Available
		explicitWait("addBtnTop_css", 30);
		
		//Click on Add Button Appeared on Top
		elementClick("addBtnTop_css");
		
		//Click on Add Company Icon Button on the Appeared Dialog Menu
		elementClick("addCompanyBtnTop_css");
		
		//Enter Company Name
		String compnayName = "Stark Industries";
		elementEnterText("addCompnayName_css", compnayName);
		
		waitLoad(2);
		
		//Click on Industry Button
		elementClick("addCompnayTypeBox_css");
		
		//Enter the Type of Industry and Select the Type from Drop-Down List
		String industry_type = "Manufacturing & Engineering";
		selectIndustryType(industry_type);
		
		explicitWait("addCompanySubmitBtn_css", 30);
		
		//Click on Submit Button
		elementClick("addCompanySubmitBtn_css");
		
		//Verify that the Company has been Added Successfully
		verifyCompanyAdded(compnayName);
		
	}
	
	//Verify that the Required Company has been Added Successfully
	public void verifyCompanyAdded(String name) {
		
		explicitWait("addCompanySuccessToast_css", 30);
		Assert.assertTrue(getElement("addCompanySuccessToast_css").isDisplayed());
		Assert.assertEquals(getElement("companyNameDetailsPage_css").getText(), name);
		
	}
	
	//Select the Industry Type
	public void selectIndustryType(String industry_type) {
		select(industry_type, "addCompanyTypeSearchBox_css", "addCompanyTypeSearchResults_css");
	}
	
}