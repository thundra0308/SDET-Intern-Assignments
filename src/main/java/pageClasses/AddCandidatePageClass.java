package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

// Class for Elements and Logic Methods of : 'Add Candidate SideBar or Page'
public class AddCandidatePageClass extends PageBaseClass {
	
	public CandidateDetailsPageClass candidateDetailsPageClass;
	
	// Constructor to Accept and Initialize the Class with the WebDriver and Extent Test of same Session
	public AddCandidatePageClass(WebDriver driver, ExtentTest logger, int testStep) {
		super(driver, logger, testStep);
	}
	
	@FindBy(css = "#sTest-candidateFirstName")
	public WebElement firstName_Input;

	@FindBy(css = "#sTest-candidateLastName")
	public WebElement lastName_Input;
	
	@FindBy(css = "#sTest-candidateAddBtn")
	public WebElement submit_Btn;
	
	// Method to Implement the Process of Adding a Candidate
	public CandidateDetailsPageClass addCandidate(String firstName, String lastName) {
		input(firstName_Input,firstName,"FirstName");
		input(lastName_Input, lastName, "LastName");
		waitLoad(1);
		click(submit_Btn, "Submit");
		verifyDataAdded();
		candidateDetailsPageClass = new CandidateDetailsPageClass(driver, logger, testStep);
		PageFactory.initElements(driver, candidateDetailsPageClass);
		return candidateDetailsPageClass;
	}

	
	
}
