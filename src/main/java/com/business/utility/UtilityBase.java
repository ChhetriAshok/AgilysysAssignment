/**
 * 
 */
package com.business.utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


/**
 * @author :Ramu Chhetri
 *
 */
public class UtilityBase {
	
	private WebDriver driver=null;
	private static Properties prop=null;
	public UtilityBase()
	{
		String propertiesFilePath=System.getProperty("user.dir")+"/PropertiesFile/Parameter.properties";
		try{
			
			prop=new Properties();
			prop.load(new FileInputStream(propertiesFilePath));	
		}
		catch(Throwable e)
		{
			System.out.println("Can't load properties file . Plz check the path :"+propertiesFilePath);
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
	public void launchBrowser()
	{
		String driverPath=System.getProperty("user.dir")+"/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notification");
		opt.addArguments("--disable-geolocation");
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	public static String getData(String elementName)
	{
		return prop.getProperty(elementName);
	}
	
	public WebDriver getDriverInstance()
	{
		return driver;
	}
	@FindBy(xpath="//iframe[@class='demo-frame']")
	public WebElement iframe;
	
	
}
