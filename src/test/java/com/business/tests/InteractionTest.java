/**
 * 
 */
package com.business.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.business.utility.UtilityBase;
import com.businesslogic.pages.CalendarHandlePage;
import com.businesslogic.pages.DraggableInteractionPage;
import com.businesslogic.pages.DroppableInteractionPage;
import com.businesslogic.pages.ResizableInteractionPage;
import com.businesslogic.pages.SortableInteractionPages;

/**
 * @author: Ramu Chhetri
 *
 */
public class InteractionTest extends UtilityBase{
	
	private WebDriver driver=null;
	private DraggableInteractionPage dragPageObj=null;
	private DroppableInteractionPage dragAnddropPageObj=null;
	private SortableInteractionPages sortablePageObj=null;
	private ResizableInteractionPage resizeWidgetPageObj=null;
	private CalendarHandlePage calendarPageObj=null;
	public InteractionTest() {
		super();
	}
	
	@BeforeMethod
	public void launch()
	{
		launchBrowser();
		driver=getDriverInstance();
	}
	
	@Test(priority=1,alwaysRun=true,enabled=true)
	public void performDragOperation() throws InterruptedException
	{
		dragPageObj=new DraggableInteractionPage(driver);
		driver.get(UtilityBase.getData("Draggable_Page_URL"));
		dragPageObj.performDrapOperation(Long.parseLong(UtilityBase.getData("drag_top")),Long.parseLong(UtilityBase.getData("drag_left")));
		Thread.sleep(2000);		
	}
	
	@Test(priority=2,alwaysRun=true,enabled=true)
	public void performDragAndDropSpecificLocation() throws InterruptedException
	{
		dragAnddropPageObj=new DroppableInteractionPage(driver);
		driver.get(UtilityBase.getData("Droppable_Page_URL"));
		dragAnddropPageObj.performDrapAndDropInSpecificLocation();
		Thread.sleep(2000);
	}
	
	@Test(priority=3,alwaysRun=true,enabled=true)
	public void performSortOperation() throws InterruptedException
	{
		sortablePageObj=new SortableInteractionPages(driver);
		driver.get(UtilityBase.getData("Sortable_Page_URL"));
		sortablePageObj.performSortOperationDescendingOrder();
		Thread.sleep(2000);
	}
	@Test(priority=4,alwaysRun=true,enabled=true)
	public void resizeWidgetOperation() throws InterruptedException
	{
		resizeWidgetPageObj=new ResizableInteractionPage(driver);
		driver.get(UtilityBase.getData("Resizable_Page_URL"));
		resizeWidgetPageObj.resizeWindowWidget(Long.parseLong(UtilityBase.getData("resize_height")),Long.parseLong(UtilityBase.getData("resize_width")));
		Thread.sleep(2000);
	}
	
	@Test(priority=5,alwaysRun=true,enabled=true)
	public void handleDateOperation() throws Exception
	{
		calendarPageObj=new CalendarHandlePage(driver);
		driver.get(UtilityBase.getData("Calendar_Page_URL"));
		calendarPageObj.selectDateFromDatePicker(UtilityBase.getData("firstDate"));
		Thread.sleep(3000);
		//calendarPageObj.selectDateFromDatePicker(UtilityBase.getData("secondDate"));
		///Thread.sleep(3000);
	}
	@AfterMethod
	public void flush()
	{
		driver.quit();
		
	}
}
