/**
 * 
 */
package com.business.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.business.utility.BaseUtility;

/**
 * @author: Ramu Chhetri
 *
 */
public class NewToursAssertion extends BaseUtility{

		private WebDriver driver=null;
		public NewToursAssertion(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		}
	
		@FindBy(xpath="//div[@class='footer']")
		private WebElement footer;
		
		@FindBy(xpath="//img[@src='images/hdr_tips.gif']/following::tr[2]/td[2]/font")
		private WebElement tips_text;
		
		public void valdateTipsText(String expectedText)
		{
			scrollWindow(driver,footer);
			Assert.assertEquals(tips_text.getText(), expectedText);
			//System.out.println(tips_text.getText());			
		}
		
		
		@FindBy(xpath="//table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")
		private WebElement table_value1_text;
		
		@FindBy(xpath="//td[text()='THREE']/following::td[5]")
		private WebElement table_value2_text;
		
		@FindBy(xpath="//td[text()='10-ll-12']")
		private WebElement table_value3_text;
		
		public void innerTableTextValidation()
		{
			System.out.println(table_value1_text.getText());
			System.out.println(table_value2_text.getText());
			System.out.println(table_value3_text.getText());
		}
		
		
		
}
