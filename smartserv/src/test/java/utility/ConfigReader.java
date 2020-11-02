package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {


	Properties pro;	
	public ConfigReader()

	{
		try {
			File src= new File("F:\\Desktop\\TesT\\smartserv\\Configuration\\config.property");
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		}

		catch (Exception e) 
		{
			System.out.println("Exception is" +e.getMessage());
		} 
	}	

	//*****************************ChromeDriver*******************************************
	public String GetChromePath()

	{
		String path= pro.getProperty("ChromeDriver");
		return path;
	}
	//*******************************URL1**************************************************
	public String getURL()

	{
		String path1= pro.getProperty("URL");
		return path1;
	}

	//********************************URL2888888888888888**********************************
	public String getURL1()

	{
		String path2= pro.getProperty("URL1");
		return path2;
	}

	//*******r**************************UserName********************************************
	public String getUname()

	{
		String User= pro.getProperty("Uid");
		return User;
	}
	//**********************************F-Password********************************************
	public String Pass()

	{
		String Pass= pro.getProperty("Pass");
		return Pass;
	}
	
	//***********************************Login***********************************************
	public String Login()

	{
		String Log= pro.getProperty("Login");
		return Log;
	}
	
	//*************************************Id*************************************************
	public String V1()

	{
		String Value= pro.getProperty("ID");
		return Value;
	}

	//*******e******************************Password*******************************************	
	public String V2()

	{
		String P1= pro.getProperty("Password");
		return P1;
	}

}