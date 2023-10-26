package com.selenium.assignment.testing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddContact extends Login {

	@Test(priority = 4)
	public void addContact() {

		// Wait for Add Button on Top to be Available
		explicitWait("addBtnTop_css",30);

		// Click on Add Button Appeared on Top
		elementClick("addBtnTop_css");
		
		elementClick("addContactBtnTop_css");
		
		String contactFirstName = "Jhon";
		String contactLastName = "Snow";
		elementEnterText("addContactFirstName_css", contactFirstName);
		elementEnterText("addContactLastName_css", contactLastName);
		
		List<String> companyBelongToNameList = new ArrayList<>();
		companyBelongToNameList.add("Capsule Corporation");
		companyBelongToNameList.add("Dunder Mifflin");
		addAndSelectCompanies(companyBelongToNameList);
		
		explicitWait("addCompanyBtnSubmit_css",30);
		
		elementClick("addCompanyBtnSubmit_css");
		
		verifyContactAdded(contactFirstName+" "+contactLastName);

	}
	
	// Verify that the Required Contact has been Added Successfully
	public void verifyContactAdded(String name) {

		explicitWait("addContactSuccessToast_css", 30);
		Assert.assertTrue(getElement("addContactSuccessToast_css").isDisplayed());
		Assert.assertEquals(getElement("contactNameDetailsPage_css").getText(),name);

	}
	
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
