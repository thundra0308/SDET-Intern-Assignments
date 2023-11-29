package pageClasses;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import baseClasses.PageBaseClass;

//Class for Elements and Logic Methods of : 'CandidateCustomFields Page'
public class CandidateCustomFieldsPageClass extends PageBaseClass {

	// Constructor to Accept and Initialize the Class with the WebDriver and Extent Test of same Session
	public CandidateCustomFieldsPageClass(WebDriver driver, ExtentTest logger, int testStep) {
		super(driver, logger, testStep);
	}
	
	@FindBy(css = "#sTest-addFieldBtn")
	public WebElement newCustomField_Btn;
	
	@FindBy(css = "input[name*='custumField']")
	public WebElement customFieldName_Input;
	
	@FindBy(css = "#sTest-enabled")
	public WebElement customFieldType_Btn;
	
	@FindBy(css = "#sTest-enabled div.dropdown-menu div.dropdown-content div.dropdown-item input")
	public WebElement customFieldType_SearchInput;
	
	@FindBy(css = "#sTest-enabled div.dropdown-menu div.dropdown-content a")
	public List<WebElement> customFieldType_SearchResult;
	
	@FindBy(css = "input[name*='dropddown_value']")
	public WebElement customFieldOptions_Input;
	
	@FindBy(css = "#sTest-saveCustomBtn")
	public WebElement save_Btn;
	
	@FindBy(css = "#sTest-deactivateAccountConfirmBtn")
	public WebElement deleteCustomFieldConfirm_Btn;
	
	@FindBy(css = "#sTest-customFieldName")
	public List<WebElement> allAddedCustomFieldNames_Txt;
	
	// Method to Implement the Process of Adding a Single Candidate Custom Field
	public void addCustomField(String customFieldName, String customFieldType, String customFieldOptions) {
		click(newCustomField_Btn, "New Custom Field Button");
		input(customFieldName_Input, customFieldName, "Field Name");
		click(customFieldType_Btn, "Field Type");
		select(customFieldType, customFieldType_SearchInput, customFieldType_SearchResult, "Field Type");
		if(customFieldOptions.length()>0) {
			input(customFieldOptions_Input, customFieldOptions, "Field Options");
		}
		click(save_Btn, "Save Button");
		waitVisibilityAndClickable(newCustomField_Btn);
		reportPass(customFieldType+": Type Field Added Successfully");
	}
	
	// Method to Implement the Process of Adding a Multiple Candidate Custom Fields
	public void addCustomFields(String[][] customFields) {
		for(String[] customField : customFields) {
			addCustomField(customField[0], customField[1], customField[2]);
		}
		verifyAddedCustomFields(customFields);
	}
	
	// Method to Verify that all the Required Candidate Custom Field have been Added
	public void verifyAddedCustomFields(String[][] customFields) {
		try {
			HashSet<String> set = new HashSet<>();
			List<WebElement> result = allAddedCustomFieldNames_Txt;
			for(WebElement e : result) set.add(e.getText());
			for(String[] e : customFields) {
				if(!set.contains(e[0])) {
					reportFail("Field Name : "+e[0]+" is not Present");
					break;
				}
			} 
			reportPass("All Custom Fields Added Successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	// Method to Implement the Process of Deleting Candidate Custom Fields
	public void deleteCustomFields(String[] customFieldNames) {
		WebDriverWait wait_1 = new WebDriverWait(driver, Duration.ofSeconds(2));
		for(String customFieldName : customFieldNames) {
			wait_1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+customFieldName+"')]/parent::p/parent::div/parent::div/parent::div//a[@id='sTest-removeCustomBtn']")));
			wait_1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+customFieldName+"')]/parent::p/parent::div/parent::div/parent::div//a[@id='sTest-removeCustomBtn']")));
			List<WebElement> list = driver.findElements(By.xpath("//span[contains(text(),'"+customFieldName+"')]/parent::p/parent::div/parent::div/parent::div//a[@id='sTest-removeCustomBtn']"));
			if(list.size()>0) {
				click(list.get(0), "Delete Button");
				click(deleteCustomFieldConfirm_Btn, "Confirm Button");
				webDriverWait.until(ExpectedConditions.invisibilityOf(deleteCustomFieldConfirm_Btn));
			}
		}
	}

}
