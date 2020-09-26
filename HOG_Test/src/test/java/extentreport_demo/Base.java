package extentreport_demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base
{
	WebDriver driver;
	public WebDriver initializeDriver()
	{
		System.setProperty("webdriver.chrome.driver",".\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		return driver;
	}

	
	public String getScreenshotPath(String testname, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\report\\" + testname +".png";
		File dest = new File(path);
		//File target = new File(System.getProperty("user.dir ") + "./Screenshots" + testname + ".png");
		FileUtils.copyFile(source, dest);
		
		return path;
		
	}
}
