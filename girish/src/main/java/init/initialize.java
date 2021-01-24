package init;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class initialize {

	  WebDriver driver;

	  @Step("This is init for driver test 1")
	public  WebDriver init() throws MalformedURLException {
	//DesiredCapabilities cap =  new DesiredCapabilities();
	//	cap.setBrowserName(BrowserType.CHROME);
//		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),cap);
		System.setProperty("webdriver.chrome.driver","/Users/girishu/practice/girish/src/main/java/resource/chromedriver 3" );
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		return driver;
	}
	
	  @Attachment(value="Page screenshot" , type = "image/png")
	public  String getScreenShot(String filename, WebDriver driver) throws IOException {
		System.out.println("File is "+System.getProperty("user.dir")+"/reports/"+filename+".png");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"/reports/"+filename+".png";
		FileUtils.copyFile(src, new File(dest));
		return System.getProperty("user.dir")+"/reports/"+filename+".png";
	}
	  
	  @Attachment(value="{0}" , type ="text/plain")
	  public  String getlogForFailure(String filename) throws IOException {
			System.out.println("File is "+System.getProperty("user.dir")+"/reports/"+filename+".png");
	
			return System.getProperty("user.dir")+"/reports/"+filename+".png";
		}
	  



}
