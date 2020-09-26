package extentreport_demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

public class NopCommerceTest
{
	WebDriver driver;
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	@BeforeTest
	public void setExtent()
	{
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "test-output/myReport.html");
		
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Hostname", "Localhost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Ankit Tiwari");
		extent.setSystemInfo("Browser", "Chrome");
		
	}
	
	
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.nopcommerce.com");
		
	}
	
	@Test
	public void noCommerceTitleTest()
	{
		test = extent.createTest("noCommerceTitleTest");
		
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "nopCommerce demo store");
		
	}
	
	@Test
	public void noCommerceLogoTest()
	{
		test = extent.createTest("noCommerceLogoTest");
		
		boolean status = driver.findElement(By.xpath("//*[@id='nivo-slider']/a[2]/img")).isDisplayed();
		Assert.assertTrue(status);
		
		
		
	}
	
	@Test
	public void noCommerceLoginTest()
	{
		test = extent.createTest("noCommerceLogoTest");
		Assert.assertTrue(true);
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "TEST CASE FAILED IS" + result.getName());  // to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS" + result.getThrowable()); // to add error/ exception in class
			
			String screenshotPath = NopCommerceTest.getScreenshot(driver, result.getName());
			
			test.addScreenCaptureFromPath(screenshotPath);  //adding screen shot
			
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test Case SKIPPED IS" + result.getName());
		}
		
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test Case SKIPPED IS" + result.getName());
		}
			
		driver.quit();
		
			
	}
		
	public static String getScreenshot(WebDriver driver, String tname) throws IOException
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir ") + "./Screenshots" + tname +  dateName + ".png";
		File target = new File(destination);
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		return destination;

		
		
	}
		
	}
	


