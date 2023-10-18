package basic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

//Base Class Which Executes the Test Method of Opening a URL
public class BaseClass {
	
	// Instance Variable of WebDriver Class
	public WebDriver driver;

	// TestNG Annotated Method for Opening a URL
	@Test
	public void openSite() {
		
		// Defining the URL to Visit
		String URL = "https://recruitcrm.io/"; 
		
		// Open the Given URL in a Browser
		driver.get(URL);
		
		// Fetching the Title from the Corresponding Webpage of the given URL
		String title = driver.getTitle();
		
		// Printing the Title of the Webpage
		System.out.println(title);
		
	}
	
}
