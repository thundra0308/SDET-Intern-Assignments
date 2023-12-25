package pageClasses;

import baseClasses.PageBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import pageClasses.AdminSettingPageClass;

public class SideNavBarClass extends PageBaseClass {

	public AdminSettingPageClass adminSettingPageClass;
	
	public SideNavBarClass(WebDriver driver, ExtentTest logger, int testStep) {
		super(driver, logger, testStep);
	}
	
	@FindBy(css = "a.menu-link.setting")
	public WebElement adminSetting_Btn;
	
	public AdminSettingPageClass openAdminSettingPage() {
		click(adminSetting_Btn, "Admin Setting Button");
		adminSettingPageClass = new AdminSettingPageClass(driver, logger, testStep);
		PageFactory.initElements(driver, adminSettingPageClass);
		reportPass("Opened Admin Setting Page Successfully");
		return adminSettingPageClass;
	}

}
