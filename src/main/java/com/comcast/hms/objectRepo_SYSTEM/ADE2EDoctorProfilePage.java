package com.comcast.hms.objectRepo_SYSTEM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class ADE2EDoctorProfilePage extends WebDriverUtility{

	WebDriver driver;
		public ADE2EDoctorProfilePage(WebDriver driver) {
			this.driver = driver;
			
		PageFactory.initElements(driver, this);
				
		}
		@FindBy(xpath="//span[contains(text(),'Aichhika')] ")
		private WebElement NameIcon;
		
	    @FindBy(xpath="//a[contains(text(),'My Profile')]")
		private WebElement profilePgae;
	    
		public WebElement getNameIcon() {
			return NameIcon;
		}

		public WebElement getProfilePgae() {
			return profilePgae;
		}
		
		@FindBy(xpath="//h1[text()='Doctor | Edit Doctor Details']")
		private WebElement profileInformationEdt;
		
		public WebElement getProfileInformationEdt() {
			return profileInformationEdt;
		}
	}

