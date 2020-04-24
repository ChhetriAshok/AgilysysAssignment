/**
 * 
 */
package com.businesslogic.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.business.utility.UtilityBase;

/**
 * @author :Ramu Chhetri
 *
 */
public class CalendarHandlePage extends UtilityBase {

	protected WebDriver driver=null;
	private JavascriptExecutor js=null;
	
	public CalendarHandlePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	
	}
	
	@FindBy(xpath="//input[@id='datepicker']")
	private WebElement datePicker;
	
	@FindBy(xpath="//div[@id='ui-datepicker-div']/div/a[1]/span")
	private WebElement datePrevBtn;
	
	@FindBy(xpath="//div[@id='ui-datepicker-div']/div/a[2]/span")
	private WebElement dateNextBtn;
	
	@FindBy(xpath="//span[@class='ui-datepicker-month']")
	private WebElement calendarMonth;
	
	@FindBy(xpath="//span[@class='ui-datepicker-year']")
	private WebElement calendarYear;
	
	
	public String getValueFromCalendar(Integer month)
	{
		LinkedHashMap<Integer, String> calendarMonth=new LinkedHashMap<Integer, String>();
		calendarMonth.put(1, "January");
		calendarMonth.put(2, "February");
		calendarMonth.put(3, "March");
		calendarMonth.put(4, "April");
		calendarMonth.put(5, "May");
		calendarMonth.put(6, "June");
		calendarMonth.put(7, "July");
		calendarMonth.put(8, "August");
		calendarMonth.put(9, "September");
		calendarMonth.put(10, "October");
		calendarMonth.put(11, "November");
		calendarMonth.put(12, "December");		
		
		return calendarMonth.entrySet().stream().filter(i->i.getKey().equals(month)).map(i->i.getValue()).collect(Collectors.toList()).get(0);
	}
	
	public void selectDateFromDatePicker(String dateFromParamFile) throws ParseException
	{
		datePicker.click();
		Date dateGiven=new SimpleDateFormat("MM/dd/yyyy").parse(dateFromParamFile);
		String dayOfParamFile=dateFromParamFile.split("/")[1];
		String yearOfParamFile=dateFromParamFile.split("/")[2];
		String monthOfParamFile=dateFromParamFile.split("/")[0];
		
		if(dateGiven.compareTo(new Date())<0)
		{
			do{
				try {
						if(getValueFromCalendar(Integer.parseInt(monthOfParamFile)).equals(calendarMonth.getText()) && yearOfParamFile.equals(calendarYear.getText()))
						{
							System.out.println("Loop Entering!!!!");
							driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='"+dayOfParamFile+"']")).click();
							System.out.println("Date Clicked!!!");
							break;
						}
						datePrevBtn.click();
						Thread.sleep(500);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			while(true);
			//while(getValueFromCalendar(Integer.parseInt(monthOfParamFile)).equals(calendarMonth.getText())&& yearOfParamFile.equals(calendarYear.getText()));
		}
		else if(dateGiven.compareTo(new Date())>0)
		{
			do{
				try {
						if(getValueFromCalendar(Integer.parseInt(monthOfParamFile)).equals(calendarMonth.getText()) && yearOfParamFile.equals(calendarYear.getText()))
						{
							System.out.println("Loop Entering!!!!");
							driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='"+dayOfParamFile+"']")).click();
							System.out.println("Date Clicked!!!");
							break;
						}
						dateNextBtn.click();
						Thread.sleep(500);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			while(true);
			
		}
		//datePicker.clear();
	}
	
	
	public void selectDate(String date) throws InterruptedException
	{
		datePicker.click();
		//datePicker.sendKeys(date);
		Thread.sleep(2000);
		datePicker.clear();
	}
	
	
	
}
