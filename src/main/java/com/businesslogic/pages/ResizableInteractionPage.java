package com.businesslogic.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.business.utility.UtilityBase;

public class ResizableInteractionPage extends UtilityBase {
	
	private WebDriver driver=null;
	private JavascriptExecutor js=null;
	
	public ResizableInteractionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		js=(JavascriptExecutor)driver;
	}
	
	@FindBy(xpath="//div[@id='resizable']")
	private WebElement windowWidget;
	
	public void resizeWindowWidget(Long height,Long width)
	{
		driver.switchTo().frame(iframe);
		js.executeScript("arguments[0].setAttribute('style','height: "+height+"px; width: "+width+"px;')",windowWidget);
	}
}
