package docker;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class parallelexecution2 {
	
	@Test
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Cases Description: verify test 3")
	@Story("Story Name:This is a story for test 3")
	public void test3() {
		System.out.println("This is test 3");
	}
	
	@Test
	@Severity(SeverityLevel.MINOR)
	@Description("Test Cases Description: verify test 4")
	@Story("Story Name:This is a story for test 4")
	public void test4() {
		System.out.println("This is test 4");
	}

}
