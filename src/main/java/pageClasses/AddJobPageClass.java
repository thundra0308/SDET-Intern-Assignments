package pageClasses;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import baseClasses.PageBaseClass;

// Class for Elements and Logic Methods of : 'Add Job SideBar or Page'
public class AddJobPageClass extends PageBaseClass {

	public JobDetailsPageClass jobDetailsPageClass;
	
	// Constructor to Accept and Initialize the Class with the WebDriver and Extent Test of same Session
	public AddJobPageClass(WebDriver driver, ExtentTest logger, int testStep) {
		super(driver, logger, testStep);
	}
	
	@FindBy(css = "div#sTest-hiringPipelineTxtBox div.vs__selected-options input")
	public WebElement hiringPipeline_SearchInput;
	
	@FindBy(css = "div#sTest-hiringPipelineTxtBox ul li span#sTest-hiringPipelineListName")
	public List<WebElement> hiringPipeline_SearchResult;
	
	@FindBy(css = "#sTest-jobNameTxt")
	public WebElement jobTitle_Input;
	
	@FindBy(css = "#sTest-jobNoOfopeningsTxt")
	public WebElement numberOfVacancy_Btn;
	
	@FindBy(css = "#sTest-jobNoOfopeningsTxt input")
	public WebElement numberOfVacancy_SearchInput;
	
	@FindBy(css = "#sTest-jobNoOfopeningsTxt div.dropdown-menu div.dropdown-content a")
	public List<WebElement> numberOfVacancy_SearchResult;
	
	@FindBy(css = "#sTest-companysearchControl")
	public WebElement company_SearchInput;
	
	@FindBy(css = "div#sTest-addJObCompanyLabel div.dropdown-menu div.dropdown-content a p")
	public List<WebElement> company_SearchResult;
	
	@FindBy(css = "div#sTest-addJobConactTxt div.vs__selected-options input")
	public WebElement primaryContact_SearchInput;
	
	@FindBy(css = "div#sTest-addJobConactTxt ul li")
	public List<WebElement> primaryContact_SearchResult;
	
	@FindBy(css = "button#sTest-companyAddBtn")
	public WebElement submit_Btn;
	
	// Method to Implement the Process of Adding a Job
	public JobDetailsPageClass addJob(String pipeline, String jobTitle, String vacancy, String compnay, String primaryContact) {
		select(pipeline, hiringPipeline_SearchInput, hiringPipeline_SearchResult, "Hiring Pipeline");
		input(jobTitle_Input, jobTitle, "Job Title");
		click(numberOfVacancy_Btn, "Vacancy");
		select(vacancy, numberOfVacancy_SearchInput, numberOfVacancy_SearchResult, "Vacancy");
		select(compnay, company_SearchInput, company_SearchResult, "Company");
		select(primaryContact, primaryContact_SearchInput, primaryContact_SearchResult, "Primary Contact");
		click(submit_Btn, "Submit");
		verifyDataAdded();
		jobDetailsPageClass = new JobDetailsPageClass(driver, logger, testStep);
		PageFactory.initElements(driver, jobDetailsPageClass);
		reportPass("Opened Job Details Page");
		return jobDetailsPageClass;
	}

}
