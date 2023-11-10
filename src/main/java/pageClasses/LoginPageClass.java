package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import baseClasses.PageBaseClass;

// Class for Elements and Logic Methods of : 'Login Page'
public class LoginPageClass extends PageBaseClass {

	public DashboardPageClass dashboardPageClass;
	
	// Constructor to Accept and Initialize the Class with the WebDriver and Extent Test of same Session
	public LoginPageClass(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(css = "#sTestEmail")
	public WebElement email_Input;
	
	@FindBy(css = "#sTestPassword")
	public WebElement password_Input;
	
	@FindBy(css = "#sTestLoginBtn")
	public WebElement login_Btn;
	
	// Method to Implement the Process of Logging In
	public DashboardPageClass login(String email, String password) {
		input(email_Input,email);
		input(password_Input,password);
		click(login_Btn);
		dashboardPageClass = new DashboardPageClass(driver, logger);
		PageFactory.initElements(driver, dashboardPageClass);
		reportPass("Logged In Successfully");
		return dashboardPageClass;
	}
	
}
