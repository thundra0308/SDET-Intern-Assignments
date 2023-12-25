package baseClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentReportManager;

public class TestBaseClass {

	public WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	/****************** Invoke Browser ***********************/
	public void invokeBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Mozila")) {
				driver = new FirefoxDriver();
			} else {
				driver = new EdgeDriver();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void flushReports() {
		report.flush();
		driver.close();
	}
	
	@AfterSuite
	public void quitDriverSession() {
		driver.quit();
	}
	
}
