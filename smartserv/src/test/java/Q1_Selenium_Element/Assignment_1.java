package Q1_Selenium_Element;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import BaseClass.BaseClass;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Assignment_1 extends BaseClass {
	public WebDriver driver;

	@Test
	public void Q1_seleniumWiki() throws InterruptedException, IOException

	{   //Open the page https://en.wikipedia.org/wiki/Selenium
		driver=Base();
		driver.get(config.getURL1());
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//Verify that the external links in “External links“ section work
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div/ul/li[12]/a/span[2][text()='External links']")).click();
		Thread.sleep(3000);
		
		//Click on the “Oxygen” link on the Periodic table at the bottom of page
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//td[@title='O, Oxygen']")).click();
		Thread.sleep(3000);
		
		//Verify that it is a “featured article”
		String expectedTooltip = "This is a featured article. Click here for more information.";
		WebElement ele = driver.findElement(By.xpath("//div[@class='mw-indicator']/a[contains(@title, 'This is a featured article')]"));
		String actualTooltip = ele.getAttribute("title");
		System.out.println("Actual Title of Tool Tip"+actualTooltip);
        if(actualTooltip.equals(expectedTooltip)) 
		{							
			System.out.println("Test Case Passed");					
		}
		
        //Take a screenshot of the right hand box that contains element properties
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(),"JPEG",new File("/Users/smartserv/eclipse-workspace/QA_Assignment/Screenshots/Q1_Screenshot"));
		Thread.sleep(3000);
		
		//Count the number of pdf links in “References“
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> listOfElements = driver.findElements(By.xpath("//span[@class='cs1-format' and text()='(PDF)']"));
        System.out.println("Number of Pdf:" +listOfElements.size());
        Thread.sleep(3000);
	}	
	
	//In the search bar on top right enter “pluto” and verify that the 2 nd suggestion is “Plutonium”
	@Test
	public void Q1_verifyPluto() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("pluto");
		String ActualTitle = driver.findElement(By.xpath("//a[contains(@href, 'search=Plutonium') and @title='Plutonium']")).getText();
		String ExpectedTitle = "Plutonium";
		AssertJUnit.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Assert passed = Second result is Plutonium");
		Thread.sleep(3000);
		driver.close();
	}
}
