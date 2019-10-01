package com.iceridge.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.iceridge.testutilities.TestUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BaseClass 
{

	public static WebDriver driver;
	public static FileInputStream file;
	public static Properties prop;
	private TestUtil testUtilities; 
	public static Logger logger;
	
	public BaseClass() 
	{
		try
		{
		prop = new Properties();		
		file = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//iceridge//config//config.properties");
		prop.load(file);
		
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	public void setUp()
	{
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		else if(prop.getProperty("browser").equals("ie"))
    	{
    		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//Drivers//IEDriverServer.exe");
        	driver = new InternetExplorerDriver();
    	}
    	
    	logger = Logger.getLogger("Iceridge");
    	PropertyConfigurator.configure("log4j.properties");
    	
    	driver.manage().window().maximize();
    	driver.get(prop.getProperty("url"));
    	logger.info("URL is opened...");
        testUtilities = new TestUtil();
        driver.manage().timeouts().implicitlyWait(testUtilities.IMPLICITWAIT_SECONDS, TimeUnit.SECONDS);      
    }
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}
