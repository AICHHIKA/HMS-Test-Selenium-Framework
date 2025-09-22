package com.comcast.hms.objectrepo_INTEGRATION;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class IITAdminLoginPage extends WebDriverUtility{
	
	WebDriver driver;
	public IITAdminLoginPage(WebDriver driver) {
		this.driver = driver;
		
	PageFactory.initElements(driver, this);
			
	}
	
	WebDriverUtility wutil = new WebDriverUtility();
	
	@FindBy(xpath="(//button[text()='Click Here'])[3]")
	private WebElement ClickHereButton;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement AdminUserNameEdt;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement AdminPasswordEdt;
	
	@FindBy(xpath="//button[contains(text(),'Login')] ")
	private WebElement submitBtnEdt;
	
	public WebElement getClickHereButton() {
		return ClickHereButton;
	}

	public WebElement getAdminUserNameEdt() {
		return AdminUserNameEdt;
	}

	public WebElement getAdminPasswordEdt() {
		return AdminPasswordEdt;
	}

	public WebElement getSubmitBtnEdt() {
		return submitBtnEdt;
	}
	public void switchToChidWindow() {
		wutil.switchToTabOnUrl(driver, null);
	}
	
	public void switchToChildWindow() {
		 String parentWindow = driver.getWindowHandle();

		 // Get all window handles
		 Set<String> allWindows = driver.getWindowHandles();

		 for (String window : allWindows) {
		     if (!window.equals(parentWindow)) {
		         // Switch to the new window
		         driver.switchTo().window(window);
		         break;
		     }}
	}
	
	 public void AdminModule() {
			driver.manage().window().maximize();
			getAdminUserNameEdt().sendKeys("admin");
			getAdminPasswordEdt().sendKeys("Test@12345");
			getSubmitBtnEdt().click();
			}
	 
	 public void doctorPage() {
		 String currentsession = driver.getWindowHandle();
  	   Set<String> cids = driver.getWindowHandles();
  	   for(String cid:cids) {
  		   driver.switchTo().window(cid);
  	   }
	}
}
