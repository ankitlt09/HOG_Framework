package com.HOG.TestCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HOG.PageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		
		
		
		lp.clickLoginButton();
		
		Thread.sleep(2000);
		lp.setUserName(username);
		logger.info("Enter username");
		
		lp.setPassword(password);
		logger.info("Enter password");
		
		
		
		Thread.sleep(2000);
		
		
		lp.clickLoginSubmit();
		
		
		
		Assert.assertTrue(false);
		
		
		
		
		/*if(driver.getTitle().equals("GameGods || Profile"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
			
			
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
		String email = randomString()+"@gmail.com";
		
		
		
	}
	
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
	
	public String randomNum()
	{
		String generatedString = RandomStringUtils.randomNumeric(5);
		return generatedString;*/
		
	}
	
	

}
