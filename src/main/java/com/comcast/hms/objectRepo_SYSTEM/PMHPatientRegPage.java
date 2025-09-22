package com.comcast.hms.objectRepo_SYSTEM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class PMHPatientRegPage extends WebDriverUtility{
	
	WebDriver driver;
	public PMHPatientRegPage(WebDriver driver) {
		this.driver = driver;
		
	PageFactory.initElements(driver, this);
			
	}
	
	@FindBy(xpath="(//button[text()='Click Here'])[1]")
	private WebElement patientLoginEdt;
	
	public WebElement getPatientLoginEdt() {
		return patientLoginEdt;
	}
	@FindBy(xpath="//a[contains(text(),'Create an account')] ")
	private WebElement createAnAccountedt;
	
	@FindBy(xpath="//input[@name='full_name']")
	private WebElement nameEdt;
	
	@FindBy(xpath="//input[@name='address']")
	private WebElement addressedt;
	
	@FindBy(xpath="//input[@name='city']")
	private WebElement cityEdt;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailedt;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	private WebElement passwordedt;
	
	@FindBy(xpath="//input[@name=\"password_again\"]")
	private WebElement password_againedt;
	
	@FindBy(xpath="//button[@id=\"submit\"]")
	private WebElement buttonEdt;
	
	public WebElement getNameEdt() {
		return nameEdt;
	}

	public WebElement getAddressedt() {
		return addressedt;
	}

	public WebElement getCityEdt() {
		return cityEdt;
	}

	public WebElement getEmailedt() {
		return emailedt;
	}

	public WebElement getPasswordedt() {
		return passwordedt;
	}

	public WebElement getPassword_againedt() {
		return password_againedt;
	}

	public WebElement getButtonEdt() {
		return buttonEdt;
	}


}
