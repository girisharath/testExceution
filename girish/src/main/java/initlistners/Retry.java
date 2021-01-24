package initlistners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	int count=0;
	int max=3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<max) {
			count++;
			return true;
		}
		return false;
	}

	
}
