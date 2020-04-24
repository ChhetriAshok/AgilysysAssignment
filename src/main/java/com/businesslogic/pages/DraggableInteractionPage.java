/**
 * 
 */
package com.businesslogic.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.business.utility.UtilityBase;



/**
 * @author: Ramu Chhetri
 *
 */
public class DraggableInteractionPage extends UtilityBase {

	protected WebDriver driver=null;
	private JavascriptExecutor js=null;
	
	public DraggableInteractionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	
	}
	
	
	@FindBy(xpath="//div[@id='draggable']")
	private WebElement dragElementFrom;
	
	public void performDrapOperation(Long height,Long width)
	{
		driver.switchTo().frame(iframe);
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','position: relative; left: "+width+"px; top: "+height+"px;')",dragElementFrom);
	}
	
}
