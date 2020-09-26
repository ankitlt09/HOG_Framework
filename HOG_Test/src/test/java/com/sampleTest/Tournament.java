package com.sampleTest;

import java.util.List;

//import org.apache.xalan.xsltc.compiler.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class Tournament 
{
	public static void main(String[] args) throws InterruptedException, FindFailed 
	{
		System.setProperty("webdriver.chrome.driver",".\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.gamegods.com");
		
		driver.findElement(By.xpath("/html/body/section[1]/div/div[2]/button[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("username")).sendKeys("ankit09lt");
		
		driver.findElement(By.name("password")).sendKeys("Developers*&94715");
		
		
		driver.findElement(By.xpath("//*[@id='LoginSubmit']")).click();
		
		Thread.sleep(5000);
		
		
       WebElement tournament = driver.findElement(By.xpath("//span[contains(text(),'Tournaments')]"));
       
       JavascriptExecutor jse2 = (JavascriptExecutor)driver;
       	 jse2.executeScript("arguments[0].scrollIntoView()", tournament); 
		tournament.click();  
		
		Thread.sleep(5000);
		
		WebElement button = driver.findElement(By.xpath("//button[@class='btn update_btn38']"));
		
		new WebDriverWait(driver, 10).
		until(ExpectedConditions.elementToBeClickable(button));
		
		button.click();
		
		Thread.sleep(3000);
		
		WebElement level = driver.findElement(By.id("TournamentLevel"));
		
		//new WebDriverWait(driver, 10).
		//until(ExpectedConditions.visibilityOf(button));
		
		Select t_level = new Select(level);
		t_level.selectByVisibleText("Professional");
		
		
		Select time = new Select(driver.findElement(By.id("TournamentTimeZone")));
		time.selectByVisibleText("Asia/Kolkata");
		
		
		driver.findElement(By.xpath("//input[@value='0']")).click();
		
		driver.findElement(By.id("TournamentTitle")).sendKeys("PlayTournament");
		
		
		Select platform = new Select(driver.findElement(By.id("TournamentPlatform")));
		platform.selectByIndex(0);
		
		Select game = new Select(driver.findElement(By.id("TournamentGameID")));
		game.selectByVisibleText("PUBG");
		
		WebElement element = driver.findElement(By.id("TournamentDate"));
		
		String date = "09/20/2020";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value', '"+date+"');" , element);
		
		WebElement sTime = driver.findElement(By.id("TournamentStartTime"));
		sTime.clear();
		Thread.sleep(2000);
		String  start = "5:00 PM";
		
		sTime.sendKeys(start);
		
		//js.executeScript("arguments[0].setAttribute('value', '"+start+"');" , sTime);
		
		WebElement eDate = driver.findElement(By.id("TournamentExpirationDate"));
		
		String end = "09/20/2020";
		
		eDate.sendKeys(end);
		
		//js.executeScript("arguments[0].setAttribute('value', '"+end+"');" , eDate);
		
		
		WebElement eTime = driver.findElement(By.id("TournamentExpirationTime"));
		eTime.clear();
		String  exp = "6:00 PM";
		eTime.sendKeys(exp);
		
		//js.executeScript("arguments[0].setAttribute('value', '"+exp+"');" , eTime);
		
		
		Thread.sleep(3000);
		
		Select teams = new Select(driver.findElement(By.id("TournamentTeams")));
		teams.selectByVisibleText("08");
		
		
		Select winner = new Select(driver.findElement(By.id("TournamentWinnerPoints")));
		winner.selectByVisibleText("10");
		
		Select runner1 = new Select(driver.findElement(By.id("TournamentRunnerup1Points")));
		runner1.selectByVisibleText("4");
		
		Select runner2 = new Select(driver.findElement(By.id("TournamentRunnerup2Points")));
		runner2.selectByVisibleText("1");
		
		
		WebElement rules = driver.findElement(By.id("TournamentRules_1"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", rules);
		
		
		WebElement iFrame= driver.findElement(By.tagName("iframe"));
		
		 
		driver.switchTo().frame(iFrame);
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("html")).sendKeys("Create your own rules");
		
		driver.switchTo().parentFrame();
		
		
		WebElement image=driver.findElement(By.name("CoverImage"));
		image.sendKeys("C:\\selenium\\gamer.jpg");
		
		WebElement logo =driver.findElement(By.name("Logo"));
		
		logo.sendKeys("C:\\selenium\\logo.jpg");
		
		
		
		
		
		//driver.findElement(By.xpath("//div[@id='cke_2_contents']//textarea")).sendKeys("Create Your Own Rules!");
		
		//driver.findElement(By.xpath("/html/body")).sendKeys("Create your own rules");
	
		//driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
       //driver.findElement(By.xpath("//html")).sendKeys("Create your own rules for the game!");
       
       Thread.sleep(5000);
       
       
       WebElement logout = driver.findElement(By.xpath("//div[@class='col-lg-6 profile_logout']//a"));
       
       //JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", logout);
       
       
      


//        driver.findElement(By.xpath("//*[@id='CreateTournament']/div/div[1]/div[10]/div[4]/div/span/button")).click();
//		//driver.findElement(By.xpath("//div[4]//div[1]//span[1]//button[1]")).click();
//		
//		String imageFilePath ="C:\\Selenium\\";
//		
//		String inputFilePath ="C:\\Selenium\\";
//		
//		Screen s = new Screen();
//		
//		Pattern fileInputTextbox = new Pattern(imageFilePath +"fileTextPath.PNG");
//		
//		Pattern openButton = new Pattern(imageFilePath + "open.PNG");
//		
//		//Thread.sleep(5000);
//		
//		s.wait(fileInputTextbox, 2000);
//		
//		s.type(fileInputTextbox, inputFilePath + "gamer.jpg");
//		
//		s.click(openButton);
//		
//		 driver.findElement(By.xpath("//div[@id='navbar']//div[2]//a[1]")).click();
		
		
		//driver.findElement(By.xpath("//a[text(), 'CREATE YOUR OWN'] ")).click();
		
		//driver.findElement(By.xpath("//*[@id='page-content-wrapper']/section/div/div/div[1]/div[3]/p/span/a/button/text()")).click();
       
       //driver.findElement(By.xpath("//a[contains(text(),'CREATE YOUR OWN']")).click();
		
		//driver.switchTo().alert().accept();
		
		
		
//		List <WebElement> navlist = driver.findElements(By.className("newtabs text-center"));
//		for(WebElement elem:navlist)
//		    if(elem.getAttribute("innerHTML").contains("+ Create New Tournament"))
//		        {
//		            elem.click();
//		            break;
//		        }
//		
//		
//		//Select prof = new Select(driver.findElement(By.name("TournamentLevel"));
//		WebElement testDropDown = driver.findElement(By.name("TournamentLevel"));  
//		Select dropdown = new Select(testDropDown); 
//		dropdown.selectByVisibleText("Professional");  
//		Thread.sleep(2000);
		
		/*WebDriverWait wait = new WebDriverWait(driver, 20);
		 
		// Here we will wait until element is not visible, if element is visible then it will return web element
		// or else it will throw exception
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("a[contains(text(),'+ Create New Tournament']")));
		
		element.click();
		*/
		/*List<WebElement> element=driver.findElements(By.cssSelector("div.newtabs text-center "));
		
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", element); 
		element.get(4).click(); */                                             
		
		//element.get(4).click();
		
       /* WebElement tournament= driver.findElement(By.xpath("//a[contains(text(),'+ Create New Tournament')]"));
        
        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", tournament); 
		tournament.click();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       ;
        
		
		//Thread.sleep(5000);
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		Thread.sleep(5000);
		
		
		/*WebElement tournament = driver.findElement(By.xpath("div[contains(@class, 'newtabs text-center') and contains(text(), '+ Create New Tournament')]"));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", tournament); 
		tournament.click();*/
		
		//driver.switchTo().alert().accept();
		
		
//		WebElement myelement = driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/div/div/div[7]/div[2]/a"));
//		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//		jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
//		myelement.click();				
    	/*Thread.sleep(5000);
		WebElement tournament =driver.findElement(By.xpath("//a[contains(text(),'+ Create New tournament')]"));
		

		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", tournament); 
		tournament.click();		*/
		
		
		
		//WebElement tournament =driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/div/div/div[7]/div[2]/a"));
		
//		new WebDriverWait(driver, 5).
//		until(ExpectedConditions.elementToBeClickable(tournament));
//		
//		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//		jse2.executeScript("arguments[0].scrollIntoView()", tournament); 
//		tournament.click();		
//		
//		driver.findElement(By.xpath("//button[@class='btn update_btn38']")).click();
		
		System.out.println("Script Completed");
		//driver.close();
		
		
		
			


		

           


	}

}
