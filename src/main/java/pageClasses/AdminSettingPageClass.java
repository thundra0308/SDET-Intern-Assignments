package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import baseClasses.PageBaseClass;

// Class for Elements and Logic Methods of : 'Admin Setting Page'
public class AdminSettingPageClass extends PageBaseClass {

	public CandidateCustomFieldsPageClass candidateCustomFieldsPageClass;
	
	// Constructor to Accept and Initialize the Class with the WebDriver and Extent Test of same Session
	public AdminSettingPageClass(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(css = "a[href='/v1/candidate-custom-fields']")
	public WebElement dc_candidateFields_Btn;
	
	// Method to Implement the Process of Opening the Candidate Custom Fields Page
	public CandidateCustomFieldsPageClass openCandidateCustomFieldsPage() {
		click(dc_candidateFields_Btn);
		candidateCustomFieldsPageClass = new CandidateCustomFieldsPageClass(driver, logger);
		PageFactory.initElements(driver, candidateCustomFieldsPageClass);
		reportPass("Opened Candidate Custom Filed Page");
		return candidateCustomFieldsPageClass;
	}

}
