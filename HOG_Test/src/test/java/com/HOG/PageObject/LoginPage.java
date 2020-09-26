package com.HOG.PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver ldriver;  // local driver
	
	public LoginPage(WebDriver rdriver)    // remote driver
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
		
	}
	
	@FindBy(xpath="/html/body/section[1]/div/div[2]/button[1]")
	@CacheLookup
	WebElement loginButton;
	
	
	@FindBy(name="username")
	@CacheLookup
	WebElement name;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//*[@id='LoginSubmit']")
	@CacheLookup
	WebElement loginsubmit;
	
	@FindBy(xpath="//*[@id='sidebar-wrapper']/div/div/div[2]/div[2]/ul/li[7]/a/span")
	@CacheLookup
	WebElement tournament;
	
	@FindBy(xpath="//button[@class='btn update_btn38']")
	@CacheLookup
	WebElement buttonTournament;
	
	
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public void setUserName(String uname)
	{
		name.sendKeys(uname);
	}
	
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickLoginSubmit()
	{
		loginsubmit.click();
	}
	
//	public void tournament(WebDriver driver)
//	{
//		
//		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//		jse2.executeScript("arguments[0].scrollIntoView()", tournament); 
//		//myelement.click();	
//		tournament.click();
//	}
//	
//	
//	public void clickTournament()
//	{
//		buttonTournament.click();
//	}
//	
	
	

}
