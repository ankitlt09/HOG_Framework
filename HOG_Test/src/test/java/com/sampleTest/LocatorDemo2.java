package com.sampleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorDemo2 
{
	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver",".\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
		driver.manage().window().maximize();  // maximize web page
		
		//className
		
		int sliders = driver.findElements(By.className("homeslider-container")).size();
		System.out.println(sliders);

		//TagName
		int links=driver.findElements(By.tagName("a")).size();
		System.out.println(links);
		
		
		
		
		
		
	}

}
