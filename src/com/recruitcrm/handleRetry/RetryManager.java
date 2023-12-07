package com.recruitcrm.handleRetry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryManager implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int counter = 0;
		int total = 2;
		if(counter<total) {
			counter+=1;
			return true;
		}
		return false;
	}

}
