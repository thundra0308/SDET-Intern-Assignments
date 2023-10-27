package com.selenium.assignment.testing;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.selenium.assignment.base.BaseUi;

//Class to Test Login and Logout Functionalities
public class LoginAndLogout extends BaseUi {

	//Test Method to Login Before Executing the Test Suite
	@BeforeSuite
	public void loginTest() {
		logger = report.createTest("Enter UserName And Password in Rediff : ");
		invokeBrower();
		openURL("url_recruitcrm_loginpage");
		elementEnterText("loginemail_css", "suryanshsingh03082001@gmail.com");
		elementEnterText("loginpass_css", "RCRMDEMO@rcrmdemo@2024");
		elementClick("loginbtn_css");
	}
	
	//Test Method to Logout After Executing the Test Suite
	@AfterSuite
	public void logoutTest() {
		
		elementClick("profileBtnTop_css");
		elementClick("profileBtnTopDialogoutBtn_css");
		
	}
	
}
