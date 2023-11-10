package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

// Class for Elements and Logic Methods of : 'Add Company SideBar or Page'
public class AddCompanyPageClass extends PageBaseClass {

	public CompanyDetailsPageClass companyDetailsPageClass;
	
	// Constructor to Accept and Initialize the Class with the WebDriver and Extent Test of same Session
	public AddCompanyPageClass(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(css = "#sTest-companyNameTxt")
	public WebElement compnayName_Input;
	
	@FindBy(css = "#sTest-industryTxt div.dropdown-trigger > button")
	public WebElement industryType_Btn;
	
	@FindBy(css = "#sTest-industryTxt div.dropdown-menu input")
	public WebElement industryType_SearchInput;
	
	@FindBy(css = "#sTest-industryTxt div.dropdown-menu a div div")
	public List<WebElement> industryType_SearchResult;
	
	@FindBy(css = "#sTest-companySubmitBtn")
	public WebElement submit_Btn;
	
	// Method to Implement the Process of Adding a Company
	public CompanyDetailsPageClass addCompany(String companyName, String industryType) {
		input(compnayName_Input, companyName);
		click(industryType_Btn);
		select(industryType, industryType_SearchInput, industryType_SearchResult);
		click(submit_Btn);
		verifyDataAdded();
		companyDetailsPageClass = new CompanyDetailsPageClass(driver, logger);
		PageFactory.initElements(driver, companyDetailsPageClass);
		reportPass("Opened the Added Companie's Details Page");
		return companyDetailsPageClass;
	}

}
