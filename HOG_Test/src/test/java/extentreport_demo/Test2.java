package extentreport_demo;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test2 extends Base
{
	WebDriver driver;
	
	@Test
	public void googleDemo()
	{
		//ExtentTest test= extent.createTest("Initial Demo");
		
		WebDriver driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.close();
		//test.fail("Result do not match");
		
		//extent.flush();
		
		
	}


}
