package com.comcast.hms.objectrepo_INTEGRATION;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class AdminLogOutPage extends WebDriverUtility {
	
	WebDriver driver;
	public void AdminLogoutPage(WebDriver driver) {
		this.driver = driver;
		
	PageFactory.initElements(driver, this);
			
	}
	@FindBy(xpath="//span[@class='username']")
	private WebElement adminLogoutLink;
	
	public WebElement getAdminLogoutLink() {
		return adminLogoutLink;
	}
	@FindBy(xpath="//a[contains(text(),'Log Out')] 	")
	private WebElement logoutBtn;
	
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
}
