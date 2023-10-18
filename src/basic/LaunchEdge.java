package basic;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

//Class to Implement Launch of Edge Browser
public class LaunchEdge extends BaseClass {

	// TestNG Annotated Method to Launch Browser before Opening the URL
	@BeforeMethod
	public void openBrowser() {
		
		// Initialize Edge WebDriver and Open the Browser
		driver = new EdgeDriver();
		
		// Maximize the Browser Window
		driver.manage().window().maximize();
		
	}
	
}
