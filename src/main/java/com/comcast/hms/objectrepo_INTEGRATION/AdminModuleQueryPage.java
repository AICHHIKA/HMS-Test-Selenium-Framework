package com.comcast.hms.objectrepo_INTEGRATION;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class AdminModuleQueryPage extends WebDriverUtility {

	WebDriver driver;
	public AdminModuleQueryPage(WebDriver driver) {
		this.driver = driver;
		
	PageFactory.initElements(driver, this);
			
	}
	@FindBy(xpath="//span[text()=' Conatctus Queries ']")
	private WebElement queryEdt;
	
	@FindBy(xpath="//span[text()=' Unread Query ']")
	private WebElement unreadQueryEdt;
	
	public WebElement getQueryEdt() {
		return queryEdt;
	}

	public WebElement getUnreadQueryEdt() {
		return unreadQueryEdt;
	}
	
	@FindBy(xpath="//h1[text()='Admin | Manage Unread Queries']")
	private WebElement manageQueryPage;
	
	public WebElement getManageQueryPage() {
		return manageQueryPage;
	}

}
