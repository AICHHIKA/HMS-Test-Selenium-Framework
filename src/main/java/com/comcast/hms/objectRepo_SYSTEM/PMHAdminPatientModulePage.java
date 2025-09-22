package com.comcast.hms.objectRepo_SYSTEM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class PMHAdminPatientModulePage extends WebDriverUtility {
	
	WebDriver driver;
	public PMHAdminPatientModulePage(WebDriver driver) {
		this.driver = driver;
		
	PageFactory.initElements(driver, this);
			
	}
	@FindBy(xpath="//span[text()=' Patients ']")
	private WebElement patientModuleEdt;
	
	@FindBy(xpath="//span[text()=' Manage Patients ']")
	private WebElement managepatientLink;
	public WebElement getPatientModuleEdt() {
		return patientModuleEdt;
	}

	public WebElement getManagepatientLink() {
		return managepatientLink;
	}

}
