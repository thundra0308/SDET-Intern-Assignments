package handle.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryManager implements IRetryAnalyzer {

	int counter = 0;
	int max = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		if(counter<max) {
			counter+=1;
			return true;
		}
		return false;
	}

}
