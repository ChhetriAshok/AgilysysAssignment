/**
 * 
 */
package com.business.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author: Ramu Chhetri
 * this class is designed to launch the browser and create utility class
 */
public class BaseUtility {

	private WebDriver driver=null;
	protected static Properties prop=null;
	protected static FileInputStream fis=null;
	public BaseUtility()
	{
		String propertiesFilePath=System.getProperty("user.dir")+"/PropertiesFile/Parameter.properties";
		try{
			
			prop=new Properties();
			fis=new FileInputStream(propertiesFilePath);
			prop.load(fis);	
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
	public void scrollWindow(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
	public void scrollWindow(WebDriver driver, long x,long y)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
}
