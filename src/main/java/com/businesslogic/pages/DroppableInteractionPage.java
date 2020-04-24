/**
 * 
 */
package com.businesslogic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.business.utility.UtilityBase;

/**
 * @author :Ramu Chhetri
 *
 */
public class DroppableInteractionPage extends UtilityBase{

	private WebDriver driver=null;
	private Actions action=null;
	public DroppableInteractionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	
	
	@FindBy(xpath="//div[@id='draggable']")
	private WebElement srcDragDrop;
	
	@FindBy(xpath="//div[@id='droppable']")
	private WebElement tgtDragDrop;
	
	@FindBy(xpath="//div[@id='droppable']/p")
	private WebElement targetDroppedText;
	
	public void performDrapAndDropInSpecificLocation()
	{
		driver.switchTo().frame(iframe);
		action=new Actions(driver);
		action.dragAndDrop(srcDragDrop, tgtDragDrop).build().perform();;
		Assert.assertEquals(targetDroppedText.getText(),"Dropped!");
	}
	
}
