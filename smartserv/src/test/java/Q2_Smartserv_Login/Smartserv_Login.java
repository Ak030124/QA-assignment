package Q2_Smartserv_Login;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import BaseClass.BaseClass;

public class Smartserv_Login extends BaseClass {
	WebDriver driver;
	
	@Test
	public void Q2_SmartservLogin() throws InterruptedException
	
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
		driver.close();
		
  }
}
