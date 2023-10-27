package com.recruitcrm.testing;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;

//Class to Test Login Page Functionalities
public class LoginTesting extends Base {

	// Login using Credentials
	@BeforeTest
	public void testLogin() {
		
		//Enter Email
		driver.findElement(By.cssSelector("section.loginSection > form input[id='sTestEmail']")).sendKeys("suryanshsingh03082001@gmail.com");
		
		//Enter Password
		driver.findElement(By.xpath("//section[@class='loginSection']/form//input[@id='sTestPassword']")).sendKeys("RCRMDEMO@rcrmdemo@2024");
		
		//Click on Login Button
		driver.findElement(By.id("sTestLoginBtn")).click();
		
	}
	
}
