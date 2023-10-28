package com.selenium.assignment.testing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//Class to Test Add Contact Functionalities
public class AddContact extends LoginAndLogout {

	//Test Method to Add Contact
	@Test(priority = 4)
	public void addContactTest() {

		logger = report.createTest("Test : Add Contact");
		
		// Wait for Add Button on Top to be Available
		explicitWait("addBtnTop_css",30);

		// Click on Add Button Appeared on Top
		elementClick("addBtnTop_css");
		
		//Click on Add Contact Button in the Appeared Dialog
		elementClick("addContactBtnTop_css");
		
		//Enter the Contact Name
		String contactFirstName = "Jhon";
		String contactLastName = "Snow";
		elementEnterText("addContactFirstName_css", contactFirstName);
		elementEnterText("addContactLastName_css", contactLastName);
		
		//Select the Names of the Company the Contact Belong To
		List<String> companyBelongToNameList = new ArrayList<>();
		companyBelongToNameList.add("Capsule Corporation");
		companyBelongToNameList.add("Dunder Mifflin");
		addAndSelectCompanies(companyBelongToNameList);
		
		explicitWait("addCompanyBtnSubmit_css",30);
		
		//Click on the Submit Button
		elementClick("addCompanyBtnSubmit_css");
		
		//Verify If the Contact has been Added Successfully
		verifyContactAdded(contactFirstName+" "+contactLastName);

	}
	
	// Verify that the Required Contact has been Added Successfully
	public void verifyContactAdded(String name) {

		explicitWait("addContactSuccessToast_css", 30);
		Assert.assertTrue(getElement("addContactSuccessToast_css").isDisplayed());
		Assert.assertEquals(getElement("contactNameDetailsPage_css").getText(),name);

	}
	
	//Select Company, the Contact Belong To.
	public void addAndSelectCompanies(List<String> companyBelongToNameList) {
		
		for (String name : companyBelongToNameList) {
			select(name,"addCompanyBelongToBox_css","addCompanyBelongToListContainer_css");
		}
		
		List<WebElement> companyBelongToAdded = getElements("addCompanyBelongToAddedList_css");
		HashSet<String> companyBelongToAddedSet = new HashSet<>();
		for(WebElement e : companyBelongToAdded) companyBelongToAddedSet.add(e.getText());
		for(String e : companyBelongToNameList) {
			if(!companyBelongToAddedSet.contains(e)) {
				Assert.assertTrue(false, e+" is not Present in the Selected Company List");
			}
		}
		
	}

}
