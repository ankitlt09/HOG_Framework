package extentreport_demo;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo extends Base
{
	WebDriver driver;
	
	ExtentSparkReporter reporter;
	ExtentReports extent;
	
	@BeforeTest
	public ExtentReports extentReporterGenerator()
	{
		//ExtentReport, ExtentSparkReporter
		String path = System.getProperty("user.dir") + "\\report\\index.html";
		
	    reporter =  new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ankit Tiwari");
		return extent;
		
		
		
	}
	
	@Test
	public void initialDemo()
	{
		ExtentTest test= extent.createTest("Initial Demo");
		
		WebDriver driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		//test.fail("Result do not match");
		
		extent.flush();
		
		
	}

}
