package com.selenium.assignment.testing;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//Class to Test Add Candidate Functionalities
public class AddCandidate extends LoginAndLogout {

	//Test Method to Add Candidate by Manually Filling the Details
	@Test(priority = 1)
	public void addCandidateTest_Manual() {

		// Wait for Add Button on Top to be Available
		explicitWait("addBtnTop_css", 30);

		// Click on Add Button on Top
		elementClick("addBtnTop_css");

		// Click on Add Candidate Icon Button on Appeared Dialog Menu
		elementClick("addCandidateBtnTop_css");

		// Enter First Name
		elementEnterText("addCandidateFirstName_css", "Alan");
		// Enter Last Name
		elementEnterText("addCandidateLastName_css", "Walker");
		
		explicitWait("addCandidateBtnSubmit_css", 30);

		// Click on Submit Button
		elementClick("addCandidateBtnSubmit_css");

		// Verify that the Candidate has been Added Successfully
		verifyCandidateAdded("Alan Walker");

	}

	//Test Method to Add Candidate by Uploading the CV
	@Test(priority = 2)
	public void addCandidateTest_Auto() {

		// Wait for Previous Test Processing
		explicitWait("addBtnTop_css", 30);

		// Click on Add Button on Top
		elementClick("addBtnTop_css");

		// Click on Add Candidate Icon Button on Appeared Dialog Menu
		elementClick("addCandidateBtnTop_css");

		// Upload the CV in the Upload Box
		String file_path = System.getProperty("user.dir") + "/upload-files/Resume.pdf";
		elementEnterText("addCandidateUploadResume_css", file_path);

		// Wait for Upload to Complete
		WebDriverWait wait_1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait_1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#sTest-candidateAddBtn.is-loading")));
		
		// Click on Submit Button
		elementClick("addCandidateBtnSubmit_css");

		// Verify that the Candidate has been Added Successfully
		verifyCandidateAdded("Robert Cooper");

	}

	// Verify that the Candidate has been Added Successfully
	public void verifyCandidateAdded(String name) {

		explicitWait("addCandidateSuccessToast_css", 30);
		Assert.assertTrue(getElement("addCandidateSuccessToast_css").isDisplayed());
		String actual_candidate_name = getElement("candidateNameDetailsPage_css").getText();
		Assert.assertEquals(actual_candidate_name, name);

	}

}
