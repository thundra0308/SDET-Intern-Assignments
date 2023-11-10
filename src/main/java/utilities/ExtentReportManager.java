package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	//public static ExtentHtmlReporter htmlReporter;
		public static ExtentReports report;
		
		public static ExtentReports getReportInstance(){
			
			if(report == null){
				String reportName = DateUtil.getTimeStamp() + ".html";
				ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + reportName);
				report =  new ExtentReports();
				report.attachReporter(htmlReporter);
				
				report.setSystemInfo("OS", "Windows 11");
				report.setSystemInfo("Environment", "UAT");
				report.setSystemInfo("Build Number", "10.8.1");
				report.setSystemInfo("Browser", "Chrome");
				
				htmlReporter.config().setDocumentTitle("UAT UI Automation Results");
				htmlReporter.config().setReportName("All Headlines UI Test Report");
				htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
			}
			
			return report;
		}

}
