package pageClasses;

import baseClasses.PageBaseClass;
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
	
	public TopNavBarClass(WebDriver driver, ExtentTest logger, int testStep) {
		super(driver, logger, testStep);
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
		click(quickAdd_Btn, "QuickAdd Button");
		click(quickAddCandidate_Btn, "Add Candidate Button");
		addCandidatePageClass = new AddCandidatePageClass(driver, logger, testStep);
		PageFactory.initElements(driver, addCandidatePageClass);
		reportPass("Opened Add Candidate Page");
		return addCandidatePageClass;
	}

	public AddCompanyPageClass openAddCompanyPage() {
		click(quickAdd_Btn, "QuickAdd Button");
		click(quickAddCompany_Btn, "Add Company Button");
		addCompanyPageClass = new AddCompanyPageClass(driver, logger, testStep);
		PageFactory.initElements(driver, addCompanyPageClass);
		reportPass("Opened Add Candidate Page");
		return addCompanyPageClass;
	}
	
	public AddContactPageClass openAddContactPage() {
		click(quickAdd_Btn, "QuickAdd Button");
		click(quickAddContact_Btn, "Add Contact Button");
		addContactPageClass = new AddContactPageClass(driver, logger, testStep);
		PageFactory.initElements(driver, addContactPageClass);
		reportPass("Opened Add Candidate Page");
		return addContactPageClass;
	}
	
	public AddJobPageClass openAddJobPage() {
		click(quickAdd_Btn, "QuickAdd Button");
		click(quickAddJob_Btn, "Add Job Button");
		addJobPageClass = new AddJobPageClass(driver, logger, testStep);
		PageFactory.initElements(driver, addJobPageClass);
		reportPass("Opened Add Candidate Page");
		return addJobPageClass;
	}
	
}
