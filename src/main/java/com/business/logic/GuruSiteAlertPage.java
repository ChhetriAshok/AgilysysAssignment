/**
 * 
 */
package com.business.logic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.business.utility.BaseUtility;

/**
 * @author :Ramu Chhetri
 *
 */
public class GuruSiteAlertPage extends BaseUtility{
	
	private WebDriver driver=null;
	public GuruSiteAlertPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	@FindBy(xpath="//input[@name='uid']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	private WebElement loginBtn;
	
	public String checkAlertText(WebDriver driver)
	{
		String res="";
			try{
				Alert alert=driver.switchTo().alert();
				res=alert.getText(); 
				alert.accept();
			}
			catch(NoAlertPresentException e)
			{
				res="No Alert Present in the webpage!!!";
			}
			
			return res;
	}
	
	public void invalieLoginAlertCheck(String usrName,String pwd)
	{
		userName.sendKeys(usrName);
		password.sendKeys(pwd);
		loginBtn.click();
		
	}
	
}
