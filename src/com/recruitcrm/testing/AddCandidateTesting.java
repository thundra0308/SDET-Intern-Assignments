package com.recruitcrm.testing;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//Class to Test Candidate Adding Functionalities
public class AddCandidateTesting extends LoginTesting {
	
	//Add Candidate by Filling all the Details Required
	@Test(priority = 1)
	public void addCandidateTest_1() {
		
		//Wait for Add Button on Top to be Available
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#sTest-addInAppBtn")));
		
		//Click on Add Button on Top
		WebElement addBtn = driver.findElement(By.cssSelector("#sTest-addInAppBtn"));
		addBtn.click();
		
		//Click on Add Candidate Icon Button on Appeared Dialog Menu
		WebElement addBtn_candidate = driver.findElement(By.cssSelector("#sTest-addCandidateInAppBtn"));
		addBtn_candidate.click();
		
		WebElement first_name = driver.findElement(By.cssSelector("#sTest-candidateFirstName"));
		WebElement last_name = driver.findElement(By.cssSelector("#sTest-candidateLastName"));
		WebElement email = driver.findElement(By.cssSelector("#sTest-candidateEmail"));
		WebElement phone = driver.findElement(By.cssSelector("#sTest-candidateMobile"));
		
		//Enter First Name
		first_name.sendKeys("Alan");
		//Enter Last Name
		last_name.sendKeys("Walker");
		//Enter Email
		email.sendKeys("alan@gmail.com");
		//Enter Phone Number
		phone.sendKeys("1111111111");
		
		//Click on Submit Button
		WebElement submit = driver.findElement(By.cssSelector("#sTest-candidateAddBtn"));
		submit.click();
		
		//Verify that the Candidate has been Added Successfully
//		verifyAddedCandidate("Alan Walker");
		
	}
	
	//Add Candidate by Uploading the CV
	@Test(priority = 2)
	public void addCandidateTest_2() {
		
		//Wait for Previous Test Processing
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#sTest-candidateNameDetailPage")));
		//Wait for Add Button to Appear on Top
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#sTest-addInAppBtn")));
		
		
		
		//Click on Add Button on Top
		WebElement addBtn = driver.findElement(By.cssSelector("#sTest-addInAppBtn"));
		addBtn.click();
		
		//Click on Add Candidate Icon Button on Appeared Dialog Menu
		WebElement addBtn_candidate = driver.findElement(By.cssSelector("#sTest-addCandidateInAppBtn"));
		addBtn_candidate.click();
		
		//Upload the CV in the Upload Box
		WebElement upload_cv = driver.findElement(By.cssSelector("#sTest-uploadFile-candidateAddResume"));
		String file_path = "C:\\Users\\surya\\Downloads\\New-York-Resume-Template-Creative.pdf";
		upload_cv.sendKeys(file_path);
		
		//Wait for Upload to Complete
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Click on Submit Button
		WebElement submit = driver.findElement(By.cssSelector("#sTest-candidateAddBtn"));
		submit.click();
		
//		try {
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//Verify that the Candidate has been Added Successfully
//		verifyAddedCandidate("Robert Cooper");
		
	}
	
	//Verify that the Candidate has been Added Successfully
//	public void verifyAddedCandidate(String name) {
//		
//		//Wait for the Data Refresh and Opening of the Added Candidate Page
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#sTest-candidateNameDetailPage")));
//				
//		//Verify that the Added Candidate is Correct
//		String actual_candidate_name = driver.findElement(By.cssSelector("#sTest-candidateNameDetailPage")).getText();
//		Assert.assertEquals(actual_candidate_name, name);
//		
//	}
	
}
