package com.selenium.assignment.testing;

import org.testng.annotations.Test;

import com.selenium.assignment.base.BaseUi;

public class Login extends BaseUi {

	@Test(priority = 0)
	public void loginTest() {
		logger = report.createTest("Enter UserName And Password in Rediff : ");
		invokeBrower();
		openURL("url_recruitcrm_loginpage");
		elementEnterText("loginemail_css", "suryanshsingh03082001@gmail.com");
		elementEnterText("loginpass_css", "RCRMDEMO@rcrmdemo@2024");
		elementClick("loginbtn_css");
	}
	
}
