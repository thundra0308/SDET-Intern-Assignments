package basic;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

// Class to Implement Launch of Chrome Browser
public class LaunchChrome extends BaseClass {

	// TestNG Annotated Method to Launch Browser before Opening the URL
	@BeforeMethod
	public void openBrowser() {
		
		// Initialize Chrome WebDriver and Open the Browser
		driver = new ChromeDriver();  
		
		// Maximize the Browser Window
		driver.manage().window().maximize();
		
	}
	
}
