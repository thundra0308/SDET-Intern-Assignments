package pageClasses;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class CandidateDetailsPageClass extends PageBaseClass {

	public CandidateDetailsPageClass(WebDriver driver, ExtentTest logger, int testStep) {
		super(driver, logger, testStep);
	}

}
