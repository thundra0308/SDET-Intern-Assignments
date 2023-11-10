package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

// Class for Elements and Logic Methods of : 'Add Contact SideBar or Page'
public class AddContactPageClass extends PageBaseClass {

	public ContactDetailsPageClass contactDetailsPageClass;
	
	// Constructor to Accept and Initialize the Class with the WebDriver and Extent Test of same Session
	public AddContactPageClass(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(css = "#sTest-contactFirstnameTxt")
	public WebElement firstName_Input;
	
	@FindBy(css = "#sTest-contactLastnameTxt")
	public WebElement lastName_Input;
	
	@FindBy(css = "#sTest-searchCompanyName div.vs__selected-options input")
	public WebElement companyNames_SearchInput;
	
	@FindBy(css = "#sTest-searchCompanyName ul li")
	public List<WebElement> compnayNames_SearchResult;
	
	@FindBy(css = "#sTest-contactAddBtn")
	public WebElement submit_Btn;
	
	// Method to Implement the Process of Adding a Contact
	public ContactDetailsPageClass addContact(String firstName, String lastName, List<String> companies) {
		input(firstName_Input, firstName);
		input(lastName_Input, lastName);
		for(String companyName : companies) {
			select(companyName, companyNames_SearchInput, compnayNames_SearchResult);
		}
		click(submit_Btn);
		verifyDataAdded();
		contactDetailsPageClass = new ContactDetailsPageClass(driver, logger);
		PageFactory.initElements(driver, contactDetailsPageClass);
		reportPass("Opened Added Contact Details Page");
		return contactDetailsPageClass;
	}

}
