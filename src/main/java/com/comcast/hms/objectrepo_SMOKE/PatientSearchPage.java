package com.comcast.hms.objectrepo_SMOKE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class PatientSearchPage extends WebDriverUtility {

	WebDriver driver;

	public PatientSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Patient Search ']")
	private WebElement patientSearchEdt;

	@FindBy(xpath = "//input[@name='searchdata']")
	private WebElement searchDataEdt;

	@FindBy(xpath = "//button[@class='btn btn-o btn-primary']")
	private WebElement searchBtn;

	@FindBy(xpath = "//h4[text()='Result against \"Ricky Senapati\" keyword ']")
	private WebElement nameEdt;

	@FindBy(xpath = "//h1[text()='Admin | View Patients']")
	private WebElement patientName;

	public WebElement getPatientName() {
		return patientName;
	}

	public WebElement getPatientSearchEdt() {
		return patientSearchEdt;
	}

	public WebElement getSearchDataEdt() {
		return searchDataEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getNameEdt() {
		return nameEdt;
	}

	public void patientSearch() throws InterruptedException {
		getSearchDataEdt().sendKeys("Ricky Senapati");
		getSearchBtn().click();

	}

}
