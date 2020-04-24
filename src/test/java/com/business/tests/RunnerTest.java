/**
 * 
 */
package com.business.tests;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.business.logic.GooglePage;
import com.business.logic.GuruSiteAlertPage;
import com.business.logic.JavaRelatedProblems;
import com.business.logic.NewToursAssertion;
import com.business.utility.BaseUtility;

/**
 * @author: Ramu Chhetri
 * This class is designed as runner class to run all the behaviors
 */
public class RunnerTest extends BaseUtility{
	
	private WebDriver driver=null;
	private NewToursAssertion newToursObj=null;
	private GuruSiteAlertPage guruPageObj=null;
	private GooglePage googlePageObj=null;
	private JavaRelatedProblems javaProblem=null;
	
	@BeforeMethod
	public void initiate()
	{
		launchBrowser();
		driver=getDriverInstance();
	}
	@Test(priority=1,alwaysRun=true,enabled=true)
	public void newToursValidation() throws InterruptedException
	{
		newToursObj=new NewToursAssertion(driver);
		driver.get(BaseUtility.getData("new_tours_url"));
		newToursObj.valdateTipsText(BaseUtility.getData("new_tours_assert_text"));
		Thread.sleep(2000);	
	}
	@Test(priority=2,alwaysRun=true,enabled=true)
	public void webTableTextExtractAndDateValidation()
	{
		newToursObj=new NewToursAssertion(driver);
		driver.get(BaseUtility.getData("web_table_url"));
		newToursObj.innerTableTextValidation();
	}
	
	@Test(priority=3,alwaysRun=true,enabled=true)
	public void alertvalidation() throws InterruptedException
	{
		guruPageObj=new GuruSiteAlertPage(driver);
		driver.get(BaseUtility.getData("guru_site_url"));
		guruPageObj.invalieLoginAlertCheck(BaseUtility.getData("userName"), BaseUtility.getData("password"));
		String alertText=guruPageObj.checkAlertText(driver);
		System.out.println(alertText);
		
	}
	@Test(priority=4,alwaysRun=true,enabled=true)
	public void googlePageOperations() throws InterruptedException
	{
		googlePageObj=new GooglePage(driver);
		driver.get(BaseUtility.getData("google_url"));
		googlePageObj.getAllCookiesFromGooglePage();
		
		//increment time task
		javaProblem =new JavaRelatedProblems();
		int hour=Integer.parseInt(BaseUtility.getData("hours_to_add"));
		int mins=Integer.parseInt(BaseUtility.getData("mins_to_add"));
		String resDate=javaProblem.incrementHoursAndMinsInDate(new Date(),hour,mins);
		System.out.println("Date = "+resDate);
		
		//search number -- task 6
		long arr[]={1,2,4,4,4,5,1};
		long num_to_search=4;
		System.out.println("Total count of "+num_to_search+" = "+javaProblem.getCount(arr, num_to_search)); 
	}
	
	@Test(priority=5,alwaysRun=true,enabled=true)
	public void validateGoogleTermsService()
	{
		googlePageObj=new GooglePage(driver);
		driver.get(BaseUtility.getData("google_terms_service_url"));
		googlePageObj.validateGoogleTermsAndServiceHeader(BaseUtility.getData("about_these_assert_text"));
		googlePageObj.validateGoogleTermsOfServiceParaTexts();
		
		boolean b=googlePageObj.validateLinksUnderTermsService();
		System.out.println("All links are valid true/false ="+b);
		
		boolean footerLink=googlePageObj.validateFooters();
		System.out.println("All Footers are valid true/false ="+footerLink);
	}
	
	@AfterMethod
	public void flushDriver() throws IOException
	{
		driver.quit();
	}
}
