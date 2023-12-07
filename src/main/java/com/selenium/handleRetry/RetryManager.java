package com.selenium.handleRetry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryManager implements IRetryAnalyzer {

	int counter = 0;
	int total = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		if(counter<total) {
			counter+=1;
			return true;
		}
		return false;
	}

}
