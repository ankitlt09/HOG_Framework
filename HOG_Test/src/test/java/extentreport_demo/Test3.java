package extentreport_demo;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test3 extends Base
{
	WebDriver driver;

	@Test
	public void editBoxDemo() {
		// ExtentTest test= extent.createTest("Initial Demo");

		WebDriver driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("hello");
		System.out.println(driver.getTitle());
		Assert.assertTrue(false);
		driver.close();
		// test.fail("Result do not match");

		// extent.flush();

	}

}
