package com.comcast.hms.objectRepo_SYSTEM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class PMHDoctorLogOutPage extends WebDriverUtility {

	WebDriver driver;

	public PMHDoctorLogOutPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[contains(text(),'Aichhika')] ")
	private WebElement logoutIcon;

	@FindBy(xpath = "//a[contains(text(),'Log Out')] 	")
	private WebElement logoutBtn;

	public WebElement getLogoutIcon() {
		return logoutIcon;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

}
