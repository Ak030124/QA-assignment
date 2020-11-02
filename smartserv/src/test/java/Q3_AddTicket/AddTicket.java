package Q3_AddTicket;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import BaseClass.BaseClass;

public class AddTicket extends BaseClass {
public WebDriver driver;
	
	@Test
	public void Q3_AddTicket() throws InterruptedException
	
	{
		driver=Base();
		driver.get(config.getURL());
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath(config.getUname())).sendKeys(config.V1());
		Thread.sleep(2000);
		driver.findElement(By.xpath(config.Pass())).sendKeys(config.V2());
		Thread.sleep(2000);
		driver.findElement(By.xpath(config.Login())).click();
		Thread.sleep(12000);
		driver.findElement(By.xpath("//div[@id='tkt-pnl']")).click();
		Thread.sleep(5000);
		
		
		JavascriptExecutor Ticket = (JavascriptExecutor)driver;
		Ticket.executeScript("document.getElementById('addNewTicketBtn').click();");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//select[@class='jobWorkType'])[1]")).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select/option[text()='Install']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@placeholder=' Job Description *']")).sendKeys("QA");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Please type to create new or search from existing job type']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[text()='Bike']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Enter address, phone number, or name of Billing or Service location']")).sendKeys("1");
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
	    WebElement menuOption = driver.findElement(By.xpath(("//tr[@id='resultServ10' and @class='serviceResult']")));
	    actions.moveToElement(menuOption).perform();
	    menuOption.click();
	    
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//button[text()='Next'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class='endDate date-picker hasDatepicker']")).click();
		driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/following::table/tbody/tr[4]/td[4]/a[text()='25']")).click();
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//button[text()='Next'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		driver.close();
	}
}
