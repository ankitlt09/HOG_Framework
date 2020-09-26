package com.HOG.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.HOG.PageObject.LoginPage;
import com.HOG.PageObject.Tournament;

public class TC_TournamentTest extends BaseClass
{
	@Test
	public void createTournament() throws InterruptedException
	{
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		Tournament t = new Tournament(driver);
		
		WebDriver driver=BaseClass.driver;
		
		
		
		
		lp.clickLoginButton();
		
		Thread.sleep(2000);
		lp.setUserName(username);
		logger.info("Enter username");
		
		lp.setPassword(password);
		logger.info("Enter password");
		
		
		
		Thread.sleep(2000);
		
		
		lp.clickLoginSubmit();
		
		
		if(driver.getTitle().equals("GameGods || Profile"))
		{
				logger.info("Website opened");
				
				//driver.findElement(By.xpath());
				//driver.findElement(By.xpath(""));
		}
		
		driver.manage().window().maximize();
		
		t.tournament(driver);
		Thread.sleep(5000);
		
		t.clickTournament();
		Thread.sleep(3000);
		
		t.tournamentLevel();
		
		t.tournamentTime();
		
		t.rule();
		
		t.settournamentTitle("PlayingGames");
		
		t.tournamentPlatform();
		
		
		t.tournamentGameID();
		
		
		t.settournamentDate("09/22/2020");
		
		
		t.setStartTime("5:00 PM");
		
		t.setEndDate("09/22/2020");
		
		t.setEndTime("6:00 PM");
		
		t.teams();
		
		t.rules(driver);
		
		t.coverImage("C:\\selenium\\gamer.jpg");
		
		t.logoImage("C:\\selenium\\logo.jpg");
		
		t.logout(driver);
		
		driver.close();
		logger.info("Script Completed");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
