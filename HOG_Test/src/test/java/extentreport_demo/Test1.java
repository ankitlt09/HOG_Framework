package extentreport_demo;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test1 extends Base
{
	WebDriver driver;
	
	@Test
	public void initialDemo()
	{
		//ExtentTest test= extent.createTest("Initial Demo");
		
		WebDriver driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		//test.fail("Result do not match");
		
		//extent.flush();
		
		
	}


}
