package com.comcast.hms.objectRepo_SYSTEM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class PMHAddMedicalHistoryPage extends WebDriverUtility {

	WebDriver driver;

	public PMHAddMedicalHistoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Blood Pressure']")
	private WebElement BloodPresureEdt;

	@FindBy(xpath = "(//input[@placeholder='Blood Sugar'])[1]")
	private WebElement BooldSugarEdt;

	@FindBy(xpath = "//input[@placeholder='Weight']")
	private WebElement weightEdt;

	@FindBy(xpath = "(//input[@placeholder='Blood Sugar'])[2]")
	private WebElement BodyTemp;

	@FindBy(xpath = "//textarea[@placeholder='Medical Prescription']")
	private WebElement medicalPrescriptionEdt;

	public WebElement getBloodPresureEdt() {
		return BloodPresureEdt;
	}

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement submitBtn;

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getBooldSugarEdt() {
		return BooldSugarEdt;
	}

	public WebElement getWeightEdt() {
		return weightEdt;
	}

	public WebElement getBodyTemp() {
		return BodyTemp;
	}

	public WebElement getMedicalPrescriptionEdt() {
		return medicalPrescriptionEdt;
	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void PatientCreationDetail(String BloodPresure, String BloodSuger, String weight, String BloodTempre,
			String MedicalReport) throws InterruptedException {

		getBloodPresureEdt().sendKeys(BloodPresure);
		getBooldSugarEdt().sendKeys(BloodSuger);
		getWeightEdt().sendKeys(weight);
		getBodyTemp().sendKeys(BloodTempre);
		getMedicalPrescriptionEdt().sendKeys(MedicalReport);
		getSubmitBtn().click();

	}

}
