package com.comcast.hms.objectRepo_SYSTEM;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class PE2EPatientRegFirstPage extends WebDriverUtility{

	WebDriver driver;
		public PE2EPatientRegFirstPage(WebDriver driver) {
			this.driver = driver;
			
		PageFactory.initElements(driver, this);
				
		}	
		@FindBy(xpath="//h6[text()='Patient Login']/ancestor::div[@class='blog-single-det']//button[text()='Click Here']")
		private WebElement clickHereBtn;
		
		@FindBy(xpath="//a[contains(text(),'Create an account')]")
		private WebElement createAccountBtn;
		
		
		public WebElement getCreateAccountBtn() {
			return createAccountBtn;
		}

		public WebElement getClickHereBtn() {
			return clickHereBtn;
		}
		
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
		
		@FindBy(xpath="//span[contains(text(),'Ricky')] ")
		private WebElement logoutIcon;
		
		@FindBy(xpath="//a[contains(text(),'Log Out')] 	")
		private WebElement  logoutButton;
		
		
		public WebElement getLogoutIcon() {
			return logoutIcon;
		}

		public WebElement getLogoutButton() {
			return logoutButton;
		}

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
		
		public void switchToAlertAndAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
				
		public void PatientCreationDetail(String PatentName, String patienttAddress, String city,String email,String password, String Confirmpassword) throws InterruptedException {
			
			getNameEdt().sendKeys(PatentName);
			getAddressedt().sendKeys(patienttAddress);
			getCityEdt().sendKeys(city);
			getEmailedt().sendKeys(email);
			
			getPasswordedt().sendKeys(password);
			getPassword_againedt().sendKeys(Confirmpassword);
			Thread.sleep(2000);
			getButtonEdt().click();
			 Thread.sleep(3000);
			 }
	}
