package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import pageClasses.AddCandidatePageClass;
import pageClasses.AddCompanyPageClass;
import pageClasses.AddContactPageClass;
import pageClasses.AddJobPageClass;

public class TopNavBarClass extends PageBaseClass {

	public AddCandidatePageClass addCandidatePageClass;
	public AddCompanyPageClass addCompanyPageClass;
	public AddContactPageClass addContactPageClass;
	public AddJobPageClass addJobPageClass;
	
	public TopNavBarClass(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(css = "#sTest-addInAppBtn")
	public WebElement quickAdd_Btn;
	
	@FindBy(css = "#sTest-addCandidateInAppBtn")
	public WebElement quickAddCandidate_Btn;
	
	@FindBy(css = "#sTest-addCompanyInAppBtn")
	public WebElement quickAddCompany_Btn;
	
	@FindBy(css = "#sTest-addContactInAppBtn")
	public WebElement quickAddContact_Btn;
	
	@FindBy(css = "a#sTest-addJobInAppBtn")
	public WebElement quickAddJob_Btn;
	
	public AddCandidatePageClass openAddCandidatePage() {
		click(quickAdd_Btn);
		click(quickAddCandidate_Btn);
		addCandidatePageClass = new AddCandidatePageClass(driver, logger);
		PageFactory.initElements(driver, addCandidatePageClass);
		reportPass("Opened Add Candidate Page");
		return addCandidatePageClass;
	}

	public AddCompanyPageClass openAddCompanyPage() {
		click(quickAdd_Btn);
		click(quickAddCompany_Btn);
		addCompanyPageClass = new AddCompanyPageClass(driver, logger);
		PageFactory.initElements(driver, addCompanyPageClass);
		reportPass("Opened Add Candidate Page");
		return addCompanyPageClass;
	}
	
	public AddContactPageClass openAddContactPage() {
		click(quickAdd_Btn);
		click(quickAddContact_Btn);
		addContactPageClass = new AddContactPageClass(driver, logger);
		PageFactory.initElements(driver, addContactPageClass);
		reportPass("Opened Add Candidate Page");
		return addContactPageClass;
	}
	
	public AddJobPageClass openAddJobPage() {
		click(quickAdd_Btn);
		click(quickAddJob_Btn);
		addJobPageClass = new AddJobPageClass(driver, logger);
		PageFactory.initElements(driver, addJobPageClass);
		reportPass("Opened Add Candidate Page");
		return addJobPageClass;
	}
	
}
