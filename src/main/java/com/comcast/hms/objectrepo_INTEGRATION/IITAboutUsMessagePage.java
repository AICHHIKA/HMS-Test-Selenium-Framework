package com.comcast.hms.objectrepo_INTEGRATION;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class IITAboutUsMessagePage extends WebDriverUtility{

	WebDriver driver;
	public IITAboutUsMessagePage(WebDriver driver) {
		this.driver = driver;
		
	PageFactory.initElements(driver, this);
			
	}
	@FindBy(xpath="//h1[text()='Admin  | Update the About us Content']")
	private WebElement messageEdt;
	
	public WebElement getMessageEdt() {
		return messageEdt;
	}

}
