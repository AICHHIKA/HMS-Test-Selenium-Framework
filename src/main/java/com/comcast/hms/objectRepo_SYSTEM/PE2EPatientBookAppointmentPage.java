package com.comcast.hms.objectRepo_SYSTEM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class PE2EPatientBookAppointmentPage extends WebDriverUtility {

	WebDriver driver;
		public PE2EPatientBookAppointmentPage(WebDriver driver) {
			this.driver = driver;
			
		PageFactory.initElements(driver, this);
				
		}
		@FindBy(xpath="//span[text()=' Book Appointment ']")
		private WebElement bookAppointmentEdt;
		
		public WebElement getBookAppointmentEdt() {
			return bookAppointmentEdt;
		}
		@FindBy(xpath="//select[@name='Doctorspecialization']")
		private WebElement sepalization;
		
		@FindBy(xpath="//select[@name='doctor']")
		private WebElement doctor;
		
		@FindBy(xpath="//input[@name='appdate']")
		private WebElement dateSelection;
		
		
		@FindBy(xpath="//table/tbody/tr/td[.='28']")
		private WebElement dateEdt;
		
		public WebElement getDateSelection() {
			return dateSelection;
		}
		//		public WebElement getDateSelection() {
//			return dateSelection;
//		}
//		@FindBy(xpath="//input[@class='form-control datepicker']")
//		private WebElement dateEdt;
//		
		@FindBy(name = "submit")
		private WebElement submitBtn;
		
		public WebElement getSubmitBtn() {
			return submitBtn;
		}

		public WebElement getSepalization() {
			return sepalization;
		}

		public WebElement getDoctor() {
			return doctor;
		}

		public WebElement getDateEdt() {
			return dateEdt;
		}

		
		public void switchToAlertAndAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		
		public void select(WebElement element, String text) {
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}
		
		public void AppointmentDetail(String specilaization, String doctor) throws InterruptedException {
			
			getSepalization().sendKeys(specilaization);
			
			 getDoctor().sendKeys(doctor);
			 Thread.sleep(5000);
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getDateSelection());
		     getDateSelection().click();
			 getDateEdt().click();
			 Thread.sleep(3000);
//			 scrollintoviewbyjs(driver,getDateSelection());
	         Thread.sleep(10000);
			 //getDateSelection().sendKeys(date);
			 getSubmitBtn().click();
		}			
		
		private void scrollintoviewbyjs(WebDriver driver2, WebElement dateSelection2) {
			// TODO Auto-generated method stub
			
		}
		
	}

