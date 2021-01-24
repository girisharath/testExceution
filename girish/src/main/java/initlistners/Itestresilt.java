package initlistners;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import init.ExtentReportsUtil;
import init.initialize;

public class Itestresilt extends initialize implements ITestListener{


	public   ExtentTest test;
	ExtentReports extent = ExtentReportsUtil.initExtentReports();
	private  ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		// not implemented

	}


	public void onTestFailure(ITestResult result) {
		
		WebDriver driver = null;
		extentTest.get().fail(result.getThrowable());
		
		Object testObject = result.getInstance();
		Class clazz = result.getTestClass().getRealClass();
		try {
			driver = (WebDriver)clazz.getDeclaredField("driver").get(testObject);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShot(result.getMethod().getMethodName(), driver),result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		// not implemented
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
