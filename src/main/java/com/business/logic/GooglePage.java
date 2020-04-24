/**
 * 
 */
package com.business.logic;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Cookie;
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
public class GooglePage extends BaseUtility{
	
	private WebDriver driver=null;
	
	public GooglePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	
	public void getAllCookiesFromGooglePage()
	{
		Set<Cookie> cookies=driver.manage().getCookies();
		cookies.forEach(i->System.out.println(i));
	}
	
	@FindBy(xpath="//div[@class='NDJGM']/div/h1")
	private WebElement about_these_text; 
	
	@FindBy(xpath="//div[@class='NDJGM']//p[1]")
	private WebElement about_these_first_para;
	
	@FindBy(xpath="//div[@class='NDJGM']//p[2]")
	private WebElement about_these_second_para;
	
	@FindBy(xpath="//div[@class='NDJGM']//p[3]")
	private WebElement about_these_third_para;
	
	@FindBy(xpath="//div[@class='NDJGM']//p[4]")
	private WebElement about_these_fourth_para;
	
	@FindBy(xpath="//div[@class='NDJGM']//p[5]")
	private WebElement about_these_fifth_para;
	
	@FindBy(xpath="//div[@class='NDJGM']//p[6]")
	private WebElement about_these_sixth_para;
	
	@FindBy(xpath="//div[@class='NDJGM']//p[7]")
	private WebElement about_these_seventh_para;
	
	@FindBy(xpath="//div[@class='NDJGM']//p[8]")
	private WebElement about_these_eighth_para;
	
	
	@FindBy(xpath="//div[@class='NDJGM']//a[text()='organizations']")
	private WebElement organization_link;
	
	@FindBy(xpath="//div[@class='NDJGM']//a[text()='services']")
	private WebElement services_link;
	
	@FindBy(xpath="//div[@class='NDJGM']/div/p[4]/a")
	private WebElement service_specific_link;
	
	@FindBy(xpath="//div[@class='NDJGM']//a[text()='your content']")
	private WebElement your_content_link;
	
	public void validateGoogleTermsAndServiceHeader(String expectedText)
	{
		Assert.assertEquals(about_these_text.getText(), expectedText);
	}
	
	public void validateGoogleTermsOfServiceParaTexts()
	{
		Assert.assertEquals(about_these_first_para.getText(), BaseUtility.getData("about_these_first_para"));
		Assert.assertEquals(about_these_second_para.getText(), BaseUtility.getData("about_these_second_para"));
		Assert.assertEquals(about_these_third_para.getText(), BaseUtility.getData("about_these_third_para"));
		Assert.assertEquals(about_these_fourth_para.getText(), BaseUtility.getData("about_these_fourth_para"));
		Assert.assertEquals(about_these_fifth_para.getText(), BaseUtility.getData("about_these_fifth_para"));
		Assert.assertEquals(about_these_sixth_para.getText(), BaseUtility.getData("about_these_sixth_para"));
		Assert.assertEquals(about_these_seventh_para.getText(), BaseUtility.getData("about_these_seventh_para"));
		Assert.assertEquals(about_these_eighth_para.getText(), BaseUtility.getData("about_these_eighth_para"));
	}
	public boolean validateLinksUnderTermsService()
	{
		String org_link=organization_link.getAttribute("href");
		String serv_link=services_link.getAttribute("href");
		String serv_spec_link=service_specific_link.getAttribute("href");
		String your_cont_link=your_content_link.getAttribute("href");
		
		if(org_link.isEmpty()&&serv_link.isEmpty()&&serv_spec_link.isEmpty()&&your_cont_link.isEmpty())
			return false;
		else
			return true;				
	}
	
	@FindBy(xpath="//a[text()='About Google']")
	private WebElement about_google_link_footer;
	
	@FindBy(xpath="//a[text()='Privacy']")
	private WebElement privacy_link_footer;
	
	@FindBy(xpath="//a[text()='Terms']")
	private WebElement terms_footer;
	
	public boolean validateFooters()
	{
		String about_link=about_google_link_footer.getAttribute("href");
		String privacy_link=privacy_link_footer.getAttribute("href");
		String terms_link=terms_footer.getAttribute("href");

		if(about_link.isEmpty() && privacy_link.isEmpty() && terms_link.isEmpty())
			return false;
		else
			return true;
	}
	
}
