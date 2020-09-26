package extentreport_demo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class DemoTestCase 
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass()
	{
		htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		
		
		extent = new ExtentReports();
		extent.setSystemInfo("Tested By", "Ankit Tiwari");
		extent.setSystemInfo("Browser", "chrome");
		
		extent.attachReporter(htmlReporter);
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("https://www.letskodeit.com");
		
	}
	
	@Test
	public void testPass()
	{
		
		extentTest = extent.createTest("Successfult Test");
		
		extentTest.log(Status.PASS, "Test Method Successful");				
	}
	
	@Test
	public void testFail()
	{
		//driver.get("https://www.letskodeit.com");
		extentTest = extent.createTest("Successfult Test");
		
		extentTest.log(Status.FAIL, "Test Method Failed");
		Assert.fail("Executing fail method");
	}
	
	@Test
	public void testSkip()
	{
		//driver.get("https://www.letskodeit.com");
		extentTest = extent.createTest("Successfult Test");
		
		extentTest.log(Status.SKIP, "Test Method Skiped");	
		
		throw new SkipException("Executing Skipped Test Method");
	}

	@AfterMethod
	public void afterMethod() 
	{
		extent.flush();
	}

	

	@AfterClass
	public void afterClass() {
	}

}
