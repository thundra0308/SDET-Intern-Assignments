package com.recruitcrm.testing;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//Class to Test Add Company Functionalities
public class AddCompanyTesting extends LoginTesting {

	//Add Company by Filling the Required Details
	@Test(priority = 3)
	public void addCompanyTest() {
		
		//Wait for Add Button on Top to be Available
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#sTest-addInAppBtn")));
		
		//Click on Add Button Appeared on Top
		WebElement addBtn = driver.findElement(By.cssSelector("#sTest-addInAppBtn"));
		addBtn.click();
		//Click on Add Company Icon Button on the Appeared Dialog Menu
		WebElement addBtn_company = driver.findElement(By.cssSelector("#sTest-addCompanyInAppBtn"));
		addBtn_company.click();
		
		//Enter Company Name
		WebElement company_name = driver.findElement(By.cssSelector("#sTest-companyNameTxt"));
		company_name.sendKeys("Stark Industries");
		
		//Click on Industry Button
		WebElement industry_btn = driver.findElement(By.cssSelector("#sTest-industryTxt div.dropdown-trigger > button"));
		industry_btn.click();
		//Enter the Type of Industry and Select the Type from Drop-Down List
		WebElement industry_search = driver.findElement(By.cssSelector("#sTest-industryTxt div.dropdown-menu input"));
		String industry_type = "Manufacturing & Engineering";
		industry_search.sendKeys(industry_type);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> industry_search_result = driver.findElements(By.cssSelector("#sTest-industryTxt div.dropdown-menu a div div"));
		for(WebElement e : industry_search_result) {
			String curr_industry = e.getText();
			if(curr_industry.equals(industry_type)) {
				e.click();
				break;
			}
		}
		//Verify the Industry Type Selected
		WebElement industry_type_span = driver.findElement(By.cssSelector("#sTest-industryTxt div.dropdown-trigger > button span.label-scroll"));
		Assert.assertEquals(industry_type_span.getText(), industry_type);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#sTest-companySubmitBtn")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sTest-companySubmitBtn")));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sTest-companySubmitBtn")));
		
		//Click on Submit Button
		driver.findElement(By.cssSelector("#sTest-companySubmitBtn")).click();
		
		//Verify that the Company has been Added Successfully
		verifyCompanyAddedTest("Stark Industries");
		
	}
	
	//Verify that the Required Company has been Added Successfully
	public void verifyCompanyAddedTest(String name) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[role='alert'].toast.is-success")));
		WebElement success = driver.findElement(By.cssSelector("div[role='alert'].toast.is-success"));
		Assert.assertTrue(success.isDisplayed());
		String actual_company_name = driver.findElement(By.cssSelector("#sTest-companyNameCompanyDpage")).getText();
		Assert.assertEquals(actual_company_name, name);
		
	}
	
}
