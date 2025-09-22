package com.comcast.hms.objectRepo_SYSTEM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class PatientLoginPage extends WebDriverUtility{
	
	WebDriver driver;
	public PatientLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(text(),'Log-in')]")
	private WebElement clickOnLoginLink;
		
	public WebElement getClickOnLoginLink() {
		return clickOnLoginLink;
	}
	@FindBy(xpath="//input[@name='username']")
	private WebElement userNameedt;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordEdt;
	
	@FindBy(name ="submit")
	private WebElement submitBtn;
	
	public WebElement getUserNameedt() {
		return userNameedt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public void PatientLogin() {
		
		getUserNameedt().sendKeys("ricky@gmail.com");
		getPasswordEdt().sendKeys("Ricky@123");
		getSubmitBtn().click();
	}

//	public WebElement getPatientEdt() {
//		// TODO Auto-generated method stub
//		return getPatientEdt();
//	}
}