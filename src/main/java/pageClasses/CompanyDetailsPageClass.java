package pageClasses;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class CompanyDetailsPageClass extends PageBaseClass {

	public CompanyDetailsPageClass(WebDriver driver, ExtentTest logger, int testStep) {
		super(driver, logger, testStep);
	}

}
