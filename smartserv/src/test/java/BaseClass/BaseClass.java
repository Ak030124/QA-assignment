package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.ConfigReader;

public class BaseClass {
	WebDriver driver;
	public static ExtentHtmlReporter reporter;
	public ConfigReader config = new ConfigReader();
	public WebDriver Base() throws InterruptedException
	
	{
		System.setProperty("webdriver.chrome.driver", config.GetChromePath());
		 driver = new ChromeDriver();
		return driver;
	}

}
