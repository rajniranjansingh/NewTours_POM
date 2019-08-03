package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() throws IOException
	{
		prop = new Properties();
		FileInputStream fl = new FileInputStream("/Users/rajniranjansingh/eclipse-workspace/PageObjectModel/src/main/java/com/crm/qa/config/config.properties");
		prop.load(fl);
	}

	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/rajniranjansingh/eclipse-workspace/LearningSeleniumTestNG/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browserName.contains("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "/Users/rajniranjansingh/eclipse-workspace/Launch/geckodriver");
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new SafariDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("URL"));
	}
}
