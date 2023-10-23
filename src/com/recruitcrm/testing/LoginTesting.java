package com.recruitcrm.testing;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

//Class to Test Login Functionality
public class LoginTesting extends Base {

	// Login using Credentials
	@Test(priority = 0)
	public void testLogin() {
		
		//Enter Email
		driver.findElement(By.cssSelector("section.loginSection > form input[id='sTestEmail']")).sendKeys("suryanshsingh03082001@gmail.com");
		
		//Enter Password
		driver.findElement(By.xpath("//section[@class='loginSection']/form//input[@id='sTestPassword']")).sendKeys("RCRMDEMO@rcrmdemo@2024");
		
		//Click on Login Button
		driver.findElement(By.id("sTestLoginBtn")).click();
		
	}
	
}
