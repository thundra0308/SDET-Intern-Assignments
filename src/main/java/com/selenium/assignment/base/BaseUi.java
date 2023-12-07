package com.selenium.assignment.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.assignment.utils.DateUtil;
import com.selenium.assignment.utils.ExtentReportManager;

public class BaseUi {

	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;
	public static WebDriverWait webDriverWait;
	SoftAssert softAssert = new SoftAssert();

	public void invokeBrower() {

		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/objectRepository/projectConfig.properties");
			prop.load(file);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		try {
			String browserName = prop.getProperty("browserName");
			if (browserName.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equals("edge")) {
				driver = new EdgeDriver();
			} else {
				Assert.assertTrue(false, "Current Browser is Not Applicable");
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();

	}

	public void openURL(String page) {

		try {
			driver.get(prop.getProperty(page));
			reportPass(page + " : URL is Identified Successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
			e.printStackTrace();
		}

	}

	public void quitBrowser() {
		driver.quit();
	}

	public void tearDown() {
		driver.close();
	}

	public void elementEnterText(String locatorKey, String data) {
		try {
			getElement(locatorKey).sendKeys(data);
			reportPass(data + " - Entered successfully in locatorKey Element : " + locatorKey);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	public void elementClick(String locatorKey) {
		try {
			getElement(locatorKey).click();
			reportPass(locatorKey + " : Element Clicked Successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public WebElement getElement(String locatorKey) {
		String locator = prop.getProperty(locatorKey);
		WebElement element = null;
		try {
			if (locatorKey.endsWith("_id")) {
				element = driver.findElement(By.id(locator));
				logger.log(Status.INFO, "locatorKey Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_xpath")) {
				element = driver.findElement(By.xpath(locator));
				logger.log(Status.INFO, "locatorKey Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_classname")) {
				element = driver.findElement(By.className(locator));
				logger.log(Status.INFO, "locatorKey Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_css")) {
				element = driver.findElement(By.cssSelector(locator));
				logger.log(Status.INFO, "locatorKey Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_linktext")) {
				element = driver.findElement(By.linkText(locator));
				logger.log(Status.INFO, "locatorKey Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_partiallinktext")) {
				element = driver.findElement(By.partialLinkText(locator));
				logger.log(Status.INFO, "locatorKey Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_name")) {
				element = driver.findElement(By.name(locator));
				logger.log(Status.INFO, "locatorKey Identidied : " + locatorKey);
			} else {
				reportFail("Failing the Testcase, Invalid locatorKey " + locatorKey);
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		return element;
	}
	
	public List<WebElement> getElements(String locatorKey) {
		String locator = prop.getProperty(locatorKey);
		List<WebElement> element = new ArrayList<>();
		try {
			if (locatorKey.endsWith("_id")) {
				element.addAll(driver.findElements(By.id(locator)));
				logger.log(Status.INFO, "locatorKey Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_xpath")) {
				element.addAll(driver.findElements(By.xpath(locator)));
				logger.log(Status.INFO, "locatorKey Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_classname")) {
				element.addAll(driver.findElements(By.className(locator)));
				logger.log(Status.INFO, "locatorKey Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_css")) {
				element.addAll(driver.findElements(By.cssSelector(locator)));
				logger.log(Status.INFO, "locatorKey Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_linktext")) {
				element.addAll(driver.findElements(By.linkText(locator)));
				logger.log(Status.INFO, "locatorKey Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_partiallinktext")) {
				element.addAll(driver.findElements(By.partialLinkText(locator)));
				logger.log(Status.INFO, "locatorKey Identidied : " + locatorKey);
			} else if (locatorKey.endsWith("_name")) {
				element.addAll(driver.findElements(By.name(locator)));
				logger.log(Status.INFO, "locatorKey Identidied : " + locatorKey);
			} else {
				reportFail("Failing the Testcase, Invalid locatorKey " + locatorKey);
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		return element;
	}
	
	public void waitForPageLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int i = 0;
		while (i != 180) {
			String pageState = (String) js.executeScript("return document.readyState;");
			if (pageState.equals("complete")) {
				break;
			} else {
				waitLoad(1);
			}
		}

		waitLoad(2);

		i = 0;
		while (i != 180) {
			Boolean jsState = (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active == 0;");
			if (jsState) {
				break;
			} else {
				waitLoad(1);
			}
		}
	}

	public void waitLoad(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void explicitWait(String locatorKey, int seconds) {
		String locator = prop.getProperty(locatorKey);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		try {
			if (locatorKey.endsWith("_id")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
			} else if (locatorKey.endsWith("_xpath")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			} else if (locatorKey.endsWith("_classname")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locator)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
				wait.until(ExpectedConditions.elementToBeClickable(By.className(locator)));
			} else if (locatorKey.endsWith("_css")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
			} else if (locatorKey.endsWith("_linktext")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locator)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText(locator)));
			} else if (locatorKey.endsWith("_partiallinktext")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(locator)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
				wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(locator)));
			} else if (locatorKey.endsWith("_name")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
				wait.until(ExpectedConditions.elementToBeClickable(By.name(locator)));
			} else {
				reportFail(
						"Failing the Testcase, Invalid locatorKey " + locatorKey);
			}
		} catch (Exception e) {

			reportFail(e.getMessage());
			e.printStackTrace();
			
		}
	}
	
	public void select(String name, String searchBoxKey, String resultKey) {
		
		try {
			elementEnterText(searchBoxKey, name);
			List<WebElement> result = new ArrayList<>();
			int i = 1;
			while (i != 10) {
				result = getElements(resultKey);
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
					if (name.equals(e.getText())) {
						found = true;
						e.click();
						break;
					}
				}
				if (!found)
					Assert.assertTrue(false, "Given Input '" + name
							+ "' is Not Present! --- Input Size " + result.size());
			} else {
				Assert.assertTrue(false,
						"Given Input '" + name + "' is Not Present!");
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	
	public void assertTrue(boolean flag) {
		softAssert.assertTrue(flag);
	}

	public void assertfalse(boolean flag) {
		softAssert.assertFalse(flag);
	}

	public void assertequals(String actual, String expected) {
		try{
			logger.log(Status.INFO, "Assertion : Actual is -" + actual + " And Expacted is - " + expected);
			softAssert.assertEquals(actual, expected);
		}catch(Exception e){
			reportFail(e.getMessage());
		}
		
	}

	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}
	
	public void takeScreenShotOnFailure() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");
		} catch (IOException e) {
			reportFail(e.getMessage());
		}

	}
	
	@AfterMethod
	public void afterTestMethod() {
		softAssert.assertAll();
	}
	
	public void endReport() {
	report.flush();
	}
	
}
