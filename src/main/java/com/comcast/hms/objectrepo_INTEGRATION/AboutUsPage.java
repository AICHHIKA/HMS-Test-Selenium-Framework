package com.comcast.hms.objectrepo_INTEGRATION;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class AboutUsPage extends WebDriverUtility {

	WebDriver driver;
	public AboutUsPage(WebDriver driver) {
		this.driver = driver;
		
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Pages')]")
	private WebElement pageEdt;

	@FindBy(xpath="//span[contains(text(),'About Us')]")
	private WebElement aboutUspageEdt;
	
	public WebElement getPageEdt() {
		return pageEdt;
	}

	public WebElement getAboutUspageEdt() {
		return aboutUspageEdt;
	}
	
	// Business Library Methods (optional - more readable in test scripts)
		public void navigateToAboutUsPage() {
			pageEdt.click();
			aboutUspageEdt.click();
	}
}
