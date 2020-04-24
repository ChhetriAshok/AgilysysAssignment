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

import com.business.utility.UtilityBase;

/**
 * @author: Ramu Chhetri
 *
 */
public class SortableInteractionPages extends UtilityBase{
	private WebDriver driver=null;
	private Actions action=null;
	public SortableInteractionPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	
	@FindBy(xpath="//ul[@id='sortable']/li[text()='Item 7']")
	private WebElement list_item7;
	
	@FindBy(xpath="//ul[@id='sortable']/li[text()='Item 1']")
	private WebElement list_item1;
	
	@FindBy(xpath="//ul[@id='sortable']/li[text()='Item 6']")
	private WebElement list_item6;
	
	@FindBy(xpath="//ul[@id='sortable']/li[text()='Item 2']")
	private WebElement list_item2;
	
	@FindBy(xpath="//ul[@id='sortable']/li[text()='Item 5']")
	private WebElement list_item5;
	
	@FindBy(xpath="//ul[@id='sortable']/li[text()='Item 3']")
	private WebElement list_item3;
	
	@FindBy(xpath="//ul[@id='sortable']/li[text()='Item 4']")
	private WebElement list_item4;
	
	
	public void performSortOperationDescendingOrder()
	{
		driver.switchTo().frame(iframe);
		action=new Actions(driver);
		action.dragAndDrop(list_item7, list_item1).build().perform();
		action.dragAndDrop(list_item6, list_item1).build().perform();
		action.dragAndDrop(list_item5, list_item1).build().perform();
		action.dragAndDrop(list_item4, list_item1).build().perform();
		action.dragAndDrop(list_item3, list_item1).build().perform();
		action.dragAndDrop(list_item2, list_item1).build().perform();
	}
	
}
