package com.comcast.hms.objectrepo_SMOKE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class DepartmentGalleryPage extends WebDriverUtility {

	WebDriver driver;

	public DepartmentGalleryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Dental']")
	private WebElement dentalImg;

	@FindBy(xpath = "//button[text()='Cardiology']")
	private WebElement CardiologyImg;

	@FindBy(xpath = "//button[text()=' Neurology']")
	private WebElement NeurologyImg;

	@FindBy(xpath = "//button[text()='Laboratry']")
	private WebElement LaboratryImg;

	@FindBy(xpath = "//p[text()='View Our Gallery']")
	private WebElement galleryPageInfo;

	public WebElement getGalleryPageInfo() {
		return galleryPageInfo;
	}

	public WebElement getDentalImg() {
		return dentalImg;
	}

	public WebElement getCardiologyImg() {
		return CardiologyImg;
	}

	public WebElement getNeurologyImg() {
		return NeurologyImg;
	}

	public WebElement getLaboratryImg() {
		return LaboratryImg;
	}

}
