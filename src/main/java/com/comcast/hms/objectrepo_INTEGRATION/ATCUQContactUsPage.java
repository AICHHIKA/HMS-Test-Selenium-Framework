package com.comcast.hms.objectrepo_INTEGRATION;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class ATCUQContactUsPage extends WebDriverUtility {

	WebDriver driver;

	public ATCUQContactUsPage(WebDriver driver) {
		this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Enter Name']")
	private WebElement NameEdt;

	@FindBy(xpath = "//input[@placeholder='Enter Email Address']")
	private WebElement emailEdt;

	@FindBy(xpath = "//input[@placeholder='Enter Mobile Number']")
	private WebElement mobileNo;

	@FindBy(xpath = "//textarea[@placeholder='Enter Your Message']")
	private WebElement messageEdt;
	@FindBy(xpath = "//button[text()='Send Message']")
	private WebElement sendButton;

	public WebElement getsendButton() {
		return sendButton;
	}

	public WebElement getNameEdt() {
		return NameEdt;
	}

	public WebElement getEmailEdt() {
		return emailEdt;
	}

	public WebElement getMobileNo() {
		return mobileNo;
	}

	public WebElement getMessageEdt() {
		return messageEdt;
	}

	public void switchToAlertAndDissmiss(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void ContactUsDetails(String name, String email, String MobileNo, String message)
			throws InterruptedException {

		getNameEdt().sendKeys(name);
		getEmailEdt().sendKeys(email);
		getMobileNo().sendKeys(MobileNo);
		getMessageEdt().sendKeys(message);
		getsendButton().click();
	}
}
