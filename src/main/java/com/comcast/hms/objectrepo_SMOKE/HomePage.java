package com.comcast.hms.objectrepo_SMOKE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
	PageFactory.initElements(driver, this);
			
	}
	
	@FindBy(linkText="Home")
	private WebElement homePageLink;
	
	@FindBy(xpath="//div[@id='menu']//a[text()='Logins']")
	private WebElement LoginLinkEdt;
	
//	public void waitpageLoad(){
//		wLib.waitForPageToLoad(driver);
//	}
	@FindBy(xpath="//h6[.='Doctors login']/following-sibling::a/button[.='Click Here']")
	private WebElement clickhereButton;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getClickhereButton() {
		return clickhereButton;
	}

	@FindBy(xpath="//h2[.='Logins']")
	private WebElement clickonDoctorBtn;
	
	@FindBy(xpath="//h2[.='Logins']")
	private WebElement patientClickBtn;
		
	public WebElement getClickonPatientBtn() {
		return patientClickBtn;
	}

	public WebElement getClickonDoctorBtn() {
		return clickonDoctorBtn;
	}

	public WebElement getLoginLinkEdt() {
		return LoginLinkEdt;
	}

	@FindBy(linkText="Services")
	private WebElement ServicesEdt;
	
	@FindBy(linkText="About Us")
	private WebElement AboutUsEdt;
	
	@FindBy(linkText="Gallery")
	private WebElement GalleryEdt;
	
	@FindBy(linkText="Contact Us")
	private WebElement ContactUsEdt;
	
	@FindBy(linkText="Book an Appointment Us")
	private WebElement BookanAppointmentEdt;
	
	
	public WebElement getHomePageLink() {
		return homePageLink;
	}

	public WebElement getServicesEdt() {
		return ServicesEdt;
	}

	public WebElement getAboutUsEdt() {
		return AboutUsEdt;
	}

	public WebElement getGalleryEdt() {
		return GalleryEdt;
	}

	public WebElement getContactUsEdt() {
		return ContactUsEdt;
	}

	public WebElement getBookanAppointmentEdt() {
		return BookanAppointmentEdt;
	}
}
