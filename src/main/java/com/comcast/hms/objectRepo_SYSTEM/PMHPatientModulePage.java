package com.comcast.hms.objectRepo_SYSTEM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class PMHPatientModulePage extends WebDriverUtility {

	WebDriver driver;

	public PMHPatientModulePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement patientEdt;

	public WebElement getPatientEdt() {
		return patientEdt;
	}

	@FindBy(xpath = "//span[text()=' Add Patient']")
	private WebElement addpatientEdt;

	public WebElement getAddpatientEdt() {
		return addpatientEdt;
	}

	@FindBy(xpath = "//span[text()=' Manage Patient ']")
	private WebElement managePatientEdt;

	public WebElement getManagePatientEdt() {
		return managePatientEdt;
	}

	@FindBy(xpath = "//input[@placeholder='Enter Patient Email id']")
	private WebElement patientEmail;

	public WebElement getPatientEmail() {
		return patientEmail;
	}

	@FindBy(xpath = "//input[@placeholder='Enter Patient Name']")
	private WebElement patientName;

	@FindBy(xpath = "//input[@placeholder='Enter Patient Contact no']")
	private WebElement patientContactNo;

	@FindBy(xpath = "//textarea[@placeholder='Enter Patient Address']")
	private WebElement patientAdd;

	@FindBy(xpath = "//input[@placeholder='Enter Patient Age']")
	private WebElement patientAge;

	@FindBy(name="medhis")
	private WebElement medicalHistory;

	@FindBy(id="submit")
	private WebElement submitBtn;

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	@FindBy(xpath = "//span[@class='username']")
	private WebElement logoutIcon;
	@FindBy(xpath = "//a[contains(text(),'Log Out')] 	")
	private WebElement logoutBtn;

	@FindBy(xpath = "(//i[@class='fa fa-eye'])[3]")
	private WebElement eyeIconEdt;

	@FindBy(xpath = "//button[@class='btn btn-primary waves-effect waves-light w-lg']")
	private WebElement addMedicalHistoryBtn;
	//button[contains(text(), 'Add Medical History')]
	
	public WebElement getAddMedicalHistoryBtn() {
		return addMedicalHistoryBtn;
	}

	public WebElement getEyeIconEdt() {
		return eyeIconEdt;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getLogoutIcon() {
		return logoutIcon;
	}

	public WebElement getPatientName() {
		return patientName;
	}

	public WebElement getPatientContactNo() {
		return patientContactNo;
	}

	public WebElement getPatientAdd() {
		return patientAdd;
	}

	public WebElement getPatientAge() {
		return patientAge;
	}

	public WebElement getMedicalHistory() {
		return medicalHistory;
	}

	public void PatientDetail(String Patientname, String contact, String email, String patientAdd, String patientAge,
			String medicalHistory) throws InterruptedException {

		getPatientName().sendKeys(Patientname);
		getPatientContactNo().sendKeys(contact);
		getPatientAdd().sendKeys(patientAdd);
		getPatientEmail().sendKeys(email);
		getPatientAge().sendKeys(patientAge);
		getMedicalHistory().sendKeys(medicalHistory);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Now safely click submit
//		WebElement submitBtn = driver.findElement(By.id("submit"));
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.scrollUsingOffset(driver, 0,800);
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
		/*
		 * // WebElement addBtn =
		 * driver.findElement(By.xpath("//button[@class='btn btn-o btn-primary']"));
		 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
		 * submitBtn);
		 */
//		getSubmitBtn().click();
//		Thread.sleep(3000);
	}
}
