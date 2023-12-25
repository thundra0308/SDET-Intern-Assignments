package baseClasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import pageClasses.LoginPageClass;
import utilities.DateUtil;

public class PageBaseClass extends ElementFunction {

	public PageBaseClass(WebDriver driver, ExtentTest logger, int testStep) {
		this.driver = driver;
		this.logger = logger;
		this.testStep = testStep;
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	@FindBy(css = "div[role='alert'].toast.is-success")
	public WebElement isSuccess_Toast;

	/****************** OpenApplication ***********************/
	public LoginPageClass openPage(String url) {
		reportInfo("Opening the WebSite");
		driver.get(url);
		reportPass("Successfully Opened the URL");
		LoginPageClass loginPage = new LoginPageClass(driver, logger, testStep);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}

	public void verifyDataAdded() {
		try {
			reportInfo("Verifying the Added Data...");
			WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
			webDriverWait.until(ExpectedConditions.visibilityOf(isSuccess_Toast));
			if(isSuccess_Toast.isDisplayed()) {
				reportPass("Verified the Added Data Successfully");
			} else {
				reportFail("Failed to Add Data");
			}	
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
}
