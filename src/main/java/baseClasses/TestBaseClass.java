package baseClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.annotations.BeforeMethod;
import utilities.Constants;
import utilities.ExtentReportManager;

public class TestBaseClass {

	public WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	public int testStep;

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

	@BeforeMethod
	public void setup() {
		testStep = 0; // Initialise TestStep Counter for New Test
		invokeBrowser(Constants.browser); // Open Browser
	}

	@AfterMethod
	public void closeSetup() {
		report.flush();
		driver.close();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
}
