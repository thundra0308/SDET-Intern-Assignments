package basic;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

// Class to Implement Launch of Firefox Browser
public class LaunchFirefox extends BaseClass {

	// TestNG Annotated Method to Launch Browser before Opening the URL
	@BeforeMethod
	public void openBrowser() {
		
		// Initialize Firefox WebDriver and Open the Browser
		driver = new FirefoxDriver();
		
		// Maximize the Browser Window
		driver.manage().window().maximize();
		
	}
	
}
