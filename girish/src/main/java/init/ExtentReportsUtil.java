package init;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

import com.aventstack.extentreports.*;

public class ExtentReportsUtil {

	public static ExtentReports extentReports;
	public static ExtentSparkReporter extentSparkReporter;
	
	public static ExtentReports initExtentReports() {
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"index.html");
		extentSparkReporter.config().setDocumentTitle("TEST Doxker title");
		extentSparkReporter.config().setReportName("TEST REPORT");
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		return extentReports;

	}
}
