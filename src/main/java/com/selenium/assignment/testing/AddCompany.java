package com.selenium.assignment.testing;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//Class to Test Add Company Functionalities
public class AddCompany extends Login {

	//Add Company by Filling the Required Details
	@Test(priority = 3)
	public void addCompanyTest() {
		
		//Wait for Add Button on Top to be Available
		explicitWait("addBtnTop_css", 30);
		
		//Click on Add Button Appeared on Top
		elementClick("addBtnTop_css");
		
		//Click on Add Company Icon Button on the Appeared Dialog Menu
		elementClick("addCompanyBtnTop_css");
		
		//Enter Company Name
		String compnayName = "Stark Industries";
		elementEnterText("addCompnayName_css", compnayName);
		
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
	
	public void selectIndustryType(String industry_type) {
		
		elementEnterText("addCompanyTypeSearchBox_css", industry_type);
		waitLoad(2);
		List<WebElement> industry_search_result = getElements("addCompanyTypeSearchResults_css");
		for(WebElement e : industry_search_result) {
			String curr_industry = e.getText();
			if(curr_industry.equals(industry_type)) {
				e.click();
				break;
			}
		}
		
		//Verify the Industry Type Selected
		Assert.assertEquals(getElement("addCompanyTypeText_css").getText(), industry_type);
		
	}
	
}