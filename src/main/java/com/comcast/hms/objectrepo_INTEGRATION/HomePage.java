package com.comcast.hms.objectrepo_INTEGRATION;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	WebDriverUtility wlib = new WebDriverUtility();
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Home")
	private WebElement homePageLink;
	
	@FindBy(xpath="//div[@id='menu']//a[text()='Logins']")
	private WebElement LoginLinkEdt;
	
	public void waitpageLoad(){
		wlib.waitForPageToLoad(driver);
	}
	@FindBy(xpath="(//button[text()='Click Here'])[2]")
	private WebElement clickonDoctorBtn;
	
	@FindBy(xpath="(//div[@class='container']//button[@class='btn btn-success btn-sm'])[1]")
	private WebElement patientClickBtn;
	
	
	public WebElement getPatientClickBtn() {
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
	
	@FindBy(xpath = "//a[normalize-space()='Contact Us']")
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
