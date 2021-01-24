package docker;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import init.initialize;
import initlistners.Itestresilt;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({Itestresilt.class})
public class parallelexecution {
	
	public WebDriver driver;
	
	@Test(description="verify test 1")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Cases Description: verify test 1")
	@Story("Story Name:This is a story for test 1")
	
	public void test1() throws MalformedURLException {
		initialize in = new initialize();
		driver = in.init();
		System.out.println("This is test 1");
		System.out.println("Title is ------------> "+driver.getTitle());
		Assert.assertTrue(false);
		
		driver.close();
	}
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Cases Description: verify test 2")
	@Story("Story Name:This is a story for test 2")
	public void test2() {
		System.out.println("This is test 2");
	}

}
