package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
		public static ExtentReports report;
		
		public static ExtentReports getReportInstance(){
			
			if(report == null){
				String reportName = DateUtil.getTimeStamp() + ".html";
				ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + reportName);
				report =  new ExtentReports();
				report.attachReporter(sparkReporter);
				
				report.setSystemInfo("OS", "Windows 11");
				report.setSystemInfo("Environment", "UAT");
				report.setSystemInfo("Build Number", "10.8.1");
				report.setSystemInfo("Browser", "Chrome");
				
				sparkReporter.config().setDocumentTitle("UAT API Automation Results");
				sparkReporter.config().setReportName("API Test Report");
				sparkReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
			}
			
			return report;
		}

}
