package com.alist.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
public class BaseClass {
	
	
	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	
	public static Properties prop;
	static FileInputStream file;
	static FileInputStream file1;
	String filepath = "/home/enterpi/Desktop/eclipse-workspace/A-List/src/test/resources/TestConfig.properties";
	
	public BaseClass() 
	{
		
		
		try {
			prop = new Properties();
			file1 = new FileInputStream("/home/enterpi/Desktop/eclipse-workspace/A-List/src/test/resources/log4j.properties");
			prop.load(file1);
			prop.setProperty("log4j.appender.File.File", "/src/man/resources/" +"print.log");
			 file = new FileInputStream(filepath);
			
			if(file!= null)
			{
				prop.load(file);
				
			}
			}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} 
		
		
	}
	
//	@Test
//	public void driverGet( ) {
//		System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath"));
//		driver = new ChromeDriver();
//	}
//	
	public static void Initialization() 
	{
		String Browsername = prop.getProperty("Browser");
		String url  = prop.getProperty("url");
		/*
		 * if(file!= null) { System.out.println("Loaded properties file" +file);
		 * System.out.println(Browsername +"browsername"); }
		 */
		
		if (Browsername.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath"));
			//driver - new ChromeDriver(;)
			
			ChromeOptions options = new ChromeOptions();
		//	System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath"));
			options.setBinary(prop.getProperty("chromepath"));
			
			options.addArguments("--no-sandbox");
			options.addArguments("--headless");
			//options.addArguments("disable-gpu");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	       // options.addArguments("--disable-dev-shm-usage");
			
			
		}
		else if (Browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",prop.getProperty("firepath"));
			driver = new FirefoxDriver();
			
		}
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public void getScreenshot(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("//home//enterpi//Desktop//eclipse-workspace//A-List//screenshots//" +result+ "screenshot.png"));
		
	}

}