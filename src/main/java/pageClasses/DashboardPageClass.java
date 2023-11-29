package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import baseClasses.PageBaseClass;
import baseClasses.SideNavBarClass;
import baseClasses.TopNavBarClass;

//Class for Elements and Logic Methods of : 'Dashboard Page'
public class DashboardPageClass extends PageBaseClass {

	public TopNavBarClass topNavBarClass;
	public SideNavBarClass sideNavBarClass;
	
	// Constructor to Accept and Initialize the Class with the WebDriver and Extent Test of same Session
	public DashboardPageClass(WebDriver driver, ExtentTest logger, int testStep) {
		super(driver, logger, testStep);
		topNavBarClass = new TopNavBarClass(driver, logger, testStep);
		PageFactory.initElements(driver, topNavBarClass);
		sideNavBarClass = new SideNavBarClass(driver, logger, testStep);
		PageFactory.initElements(driver, sideNavBarClass);
	}
	
	// Method to Get Top Navigation Bar on Dashboard Page
	public TopNavBarClass getTopNavBarClass() {
		return topNavBarClass;
	}
	
	// Method to Get Side Navigation Bar on Dashboard Page
	public SideNavBarClass getSideNavBarClass() {
		return sideNavBarClass;
	}

}
