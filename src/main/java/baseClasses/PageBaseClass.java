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

public class PageBaseClass extends TestBaseClass {

	public ExtentTest logger;

	public PageBaseClass(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	@FindBy(css = "div[role='alert'].toast.is-success")
	public WebElement isSuccess_Toast;

	/****************** OpenApplication ***********************/
	public LoginPageClass openPage(String url) {
		logger.log(Status.INFO, "Opening the WebSite");
		driver.get(url);
		logger.log(Status.PASS, "Successfully Opened the URL : "+url);
		LoginPageClass loginPage = new LoginPageClass(driver, logger);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}

	/****************** Reporting Functions ***********************/
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

	/****************** Capture Screen Shot ***********************/
	public void takeScreenShotOnFailure() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/****************** Select the Item from Drop-Down Menu ******************/
	public void select(String value, WebElement searchBox, List<WebElement> searchResult) {
		input(searchBox,value);
		List<WebElement> result = new ArrayList<>();
		int i = 1;
		while (i != 10) {
			result = searchResult;
			if (result.size() > 0 && !result.get(0).getText()
					.equals("Sorry, no matching options.")) {
				break;
			} else {
				waitLoad(1);
			}
			i++;
		}
		if (result.size() > 0) {
			boolean found = false;
			for (WebElement e : result) {
				if (value.equals(e.getText())) {
					found = true;
					click(e);
					break;
				}
			}
			if (!found)
				Assert.assertTrue(false, "Given Input '" + value + "' is Not Present! --- Input Size " + result.size());
		} else {
			Assert.assertTrue(false, "Given Input '" + value + "' is Not Present!");
		}
	}
	
	public void waitVisibilityAndClickable(WebElement webElement) {
		webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	public void input(WebElement input, String value) {
		try {
			waitVisibilityAndClickable(input);
			input.sendKeys(value);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void click(WebElement btn) {
		try {
			waitVisibilityAndClickable(btn);
			btn.click();
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void verifyDataAdded() {
		try {
			WebDriverWait wait_1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait_1.until(ExpectedConditions.visibilityOf(isSuccess_Toast));
			if(isSuccess_Toast.isDisplayed()) {
				reportPass("Candidate Added Successfully");
			} else {
				reportFail("Failed to Add Candidate");
			}	
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
}
