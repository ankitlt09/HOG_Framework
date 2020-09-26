package com.sampleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerJS 
{
	public static void main(String[] args)
	{
		
			System.setProperty("webdriver.chrome.driver",".\\chromedriver\\chromedriver.exe");
	
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.get("https://spicejet.com");
			
			WebElement date = driver.findElement(By.id("ctl00_mainContent_txt_Fromdate"));
			
			String dateVal ="30-12-2020";
			
			selectDateByJS(driver, date, dateVal);
			
			
	}
	
	public static void selectDateByJS(WebDriver driver, WebElement element, String date)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value', '"+date+"'):" , element);
	}
}
