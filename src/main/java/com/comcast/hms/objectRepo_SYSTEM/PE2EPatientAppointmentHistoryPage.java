package com.comcast.hms.objectRepo_SYSTEM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class PE2EPatientAppointmentHistoryPage extends WebDriverUtility{

	WebDriver driver;
		public PE2EPatientAppointmentHistoryPage(WebDriver driver) {
			this.driver = driver;
			
		PageFactory.initElements(driver, this);
				
		}
		@FindBy(xpath="//span[text()=' Appointment History ']")
		private WebElement bookingHistory;
		
		public WebElement getBookingHistory() {
			return bookingHistory;
		}
		@FindBy(xpath="//h1[text()='User  | Appointment History']")
		private WebElement appointmentHistory;
		
		public WebElement getAppointmentHistory() {
			return appointmentHistory;
		}
		
		@FindBy(xpath="//h1[text()='Patients  | Appointment History']")
		private WebElement AdminModuleAppointmentHistory;
		
		public WebElement getAdminModuleAppointmentHistory() {
			return AdminModuleAppointmentHistory;
		}
	}

