package com.comcast.hms.objectRepo_SYSTEM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class DPE2EPatientModulePage {

	WebDriver driver;
	WebDriverUtility wlib;

	public DPE2EPatientModulePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
		wlib=new WebDriverUtility();

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

	@FindBy(xpath = "//textarea[@placeholder='Enter Patient Medical History(if any)']")
	private WebElement medicalHistory;

//		@FindBy(xpath="//button[@class='btn btn-o btn-primary']")
//		private WebElement addBtn;
//		
	@FindBy(xpath = "//span[@class='username']")
	private WebElement logoutIcon;
	@FindBy(xpath = "//a[contains(text(),'Log Out')] 	")
	private WebElement logoutBtn;

	@FindBy(xpath = "//i[@class='fa fa-eye']/ancestor::a[@href=\"view-patient.php?viewid=1\"]")
	private WebElement eyeIconEdt;

	@FindBy(xpath = "//button[@class='btn btn-primary waves-effect waves-light w-lg']")
	private WebElement addMedicalHistoryBtn;

	@FindBy(id = "submit")
	private WebElement submitBtn;

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

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

//		public WebElement getAddBtn() {
//			return addBtn;
//		}

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

		// Wait until the Add button is clickable

		// Scroll the Add button into view
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
//		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		// Click via JavaScript to bypass the footer intercept
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
	    
	}
	
	public void fetchPatient(String patientName)
	{
//		wlib.scrollUsingOffset(driver, 0, 800);
	    WebElement eyeIcon = driver.findElement(By.xpath("//table[@class='table table-hover']"
	    		+ "//tr/td[text()='" + patientName + "']/ancestor::tr//a/i[@class='fa fa-eye']"));

	        // Wait until it's clickable
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(eyeIcon));

	        try {
	            // Try normal click
	            eyeIcon.click();
	        } catch (ElementClickInterceptedException e) {
	            // If intercepted, scroll and force click using JavaScript
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eyeIcon);
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eyeIcon);
	        }
	    }

	}

//		driver.findElement(By.xpath("//table[@class='table table-hover']//tr["+PatientName+"]/td[7]")).click();

