package com.comcast.hms.objectrepo_INTEGRATION;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class AdminModulePage extends WebDriverUtility{

	WebDriver driver;
	public AdminModulePage(WebDriver driver) {
		this.driver = driver;
		
	PageFactory.initElements(driver, this);
			
	}
	
	@FindBy(xpath="//span[text()=' Doctors ']")
	private WebElement DoctorIconEdt;
	
	public WebElement getDoctorIconEdt() {
		return DoctorIconEdt;
	}
	@FindBy(xpath="//span[text()=' Add Doctor']")
	private WebElement addDoctorEdt;
	
	public WebElement getAddDoctorEdt() {
		return addDoctorEdt;
	}
	
	@FindBy(xpath="//span[text()=' Appointment History ']")
	private WebElement appointmentHistory;
	
	public WebElement getAppointmentHistory() {
		return appointmentHistory;
	}
	

}
