package com.comcast.hms.objectRepo_SYSTEM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.basetest_TestNG.BaseClassHMS;
import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class DPE2EDoctorPatientMessagePage extends WebDriverUtility {

		WebDriver driver;
		public DPE2EDoctorPatientMessagePage(WebDriver driver) {
			this.driver = driver;
			
		PageFactory.initElements(driver, this);
				
		}
		@FindBy(xpath="//span[text()='Patients']")
		private WebElement patientModule;
		
		public WebElement getPatientModule() {
			return patientModule;
		}
		@FindBy(xpath="//td[text()='Ricky Senapati']")
		
//		@FindBy(xpath = "//span[contains(text(), 'Ricky Senapati')]")
		private WebElement patientName;
		
		public WebElement getPatientName() {
			return patientName;
		}
		
	}
