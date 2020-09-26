package com.HOG.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tournament 
{
	
    WebDriver ldriver;  // local driver
	
	public Tournament(WebDriver rdriver)    // remote driver
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Tournaments')]")
	@CacheLookup
	WebElement tournament;
	

	@FindBy(xpath="//button[@class='btn update_btn38']")
	@CacheLookup
	WebElement buttonTournament;
	
	@FindBy(id="TournamentLevel")
	@CacheLookup
	WebElement level;
	
	
	@FindBy(id="TournamentTimeZone")
	@CacheLookup
	WebElement time;
	
	@FindBy(xpath="//input[@value='0']")
	@CacheLookup
	WebElement rule;
	
	@FindBy(id="TournamentTitle")
	@CacheLookup
	WebElement title;
	
	@FindBy(id="TournamentPlatform")
	@CacheLookup
	WebElement platform;
	
	
	@FindBy(id="TournamentGameID")
	@CacheLookup
	WebElement gameId;
	
	
	@FindBy(id="TournamentDate")
	@CacheLookup
	WebElement date;
	
	
	@FindBy(id="TournamentStartTime")
	@CacheLookup
	WebElement sTime;
	
	
	
	@FindBy(id="TournamentExpirationDate")
	@CacheLookup
	WebElement eDate;
	
	@FindBy(id="TournamentExpirationTime")
	@CacheLookup
	WebElement eTime;
	
	
	
	@FindBy(id="TournamentTeams")
	@CacheLookup
	WebElement teams;
	
	@FindBy(id="TournamentRules_1")
	@CacheLookup
	WebElement rules;
	
	@FindBy(name="CoverImage")
	@CacheLookup
	WebElement cover;
	
	
	@FindBy(name="Logo")
	@CacheLookup
	WebElement logo;
	
	@FindBy(xpath="//div[@class='col-lg-6 profile_logout']//a")
	@CacheLookup
	WebElement logout;
	
	
	
		
	public void tournament(WebDriver driver)
	{
		JavascriptExecutor jse2 = (JavascriptExecutor)ldriver;
      	jse2.executeScript("arguments[0].scrollIntoView()", tournament); 
		tournament.click();  
		
		
	}	
	
	public void clickTournament()
	{
		new WebDriverWait(ldriver, 10).
		until(ExpectedConditions.elementToBeClickable(buttonTournament));
		
		buttonTournament.click();
	}
	
	
	public void tournamentLevel()
	{
		Select t_level = new Select(level);
		t_level.selectByVisibleText("Professional");
	}
	
	public void tournamentTime()
	{
		Select zone = new Select((time));
		zone.selectByVisibleText("Asia/Kolkata");
	}
	
	public void rule()
	{
		rule.click();
	}

	public void settournamentTitle(String tourtitle)
	{
		title.sendKeys(tourtitle);
	}
	
	public void tournamentPlatform()
	{
		Select  plat= new Select(platform);
		plat.selectByIndex(0);
		
	}
	
	public void tournamentGameID()
	{
		Select game = new Select(gameId);
		game.selectByVisibleText("PUBG");
	}
	
	public void settournamentDate(String d)
	{
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].setAttribute('value', '"+d+"');" , date);
		
	}
	
	public void setStartTime(String time) throws InterruptedException
	{
		sTime.clear();
		Thread.sleep(2000);
		String  start = "5:00 PM";
		
		sTime.sendKeys(time);
		
	}
	
	public void setEndDate(String date)
	{
		eDate.sendKeys(date);
		
	}
	
	public void setEndTime(String time)
	{
		eTime.clear();
		String  exp = "6:00 PM";
		eTime.sendKeys(time);
	}
	
	
	public void teams()
	{
		Select team = new Select(teams);
		team.selectByVisibleText("08");
	}
	
	public void rules(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", rules);
		WebElement iFrame= driver.findElement(By.tagName("iframe"));
		
		 
		driver.switchTo().frame(iFrame);
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("html")).sendKeys("Create your own rules");
		
		driver.switchTo().parentFrame();
		
		
	}
	
	
	
	public void coverImage(String image)
	{
		cover.sendKeys(image);
		
	}
	
	public void logoImage(String image)
	{
		logo.sendKeys(image);
		
	}
	
	public void logout(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", logout);
	}
	
}
