package com.comcast.hms.objectRepo_SYSTEM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class ADE2EDoctorModuleCreateAccountPage extends WebDriverUtility{

		WebDriver driver;
		public ADE2EDoctorModuleCreateAccountPage(WebDriver driver) {
			this.driver = driver;
			
		PageFactory.initElements(driver, this);
				
		}
		WebDriverUtility wutil = new WebDriverUtility();
		@FindBy(xpath="(//button[text()='Click Here'])[2]")
		private WebElement ClickHereBtn;
		
		@FindBy(xpath="//input[@name='docname']")
		private WebElement docNameEdt;
		
		@FindBy(xpath="//textarea[@name='clinicaddress']")
		private WebElement addressEdt;
		
		@FindBy(xpath="//input[@name='docfees']")
		private WebElement docfeeEdt;
		
		@FindBy(xpath="//input[@name='doccontact']")
		private WebElement docContactNumber;
		
		@FindBy(xpath="//input[@name=\"docemail\"]")
		private WebElement docMailEdt;
		
		@FindBy(xpath="//input[@name=\"npass\"]")
		private WebElement passwordEdt;
		
		@FindBy(xpath="//input[@name=\"cfpass\"]")
		private WebElement confirmPassEdt;
		
		@FindBy(xpath="//button[contains(text(),'Submit')]")
		private WebElement submitBtn;
		public WebElement getClickHereBtn() {
			return ClickHereBtn;
		}
		
		@FindBy(xpath="//span[text()=' Patients ']")
		private WebElement patientIcon;
		

		public WebElement getPatientIcon() {
			return patientIcon;
		}

		public WebElement getDocNameEdt() {
			return docNameEdt;
		}

		public WebElement getAddressEdt() {
			return addressEdt;
		}

		public WebElement getDocfeeEdt() {
			return docfeeEdt;
		}

		public WebElement getDocContactNumber() {
			return docContactNumber;
		}

		public WebElement getDocMailEdt() {
			return docMailEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getConfirmPassEdt() {
			return confirmPassEdt;
		}

		public WebElement getSubmitBtn() {
			return submitBtn;
		}
		
		@FindBy(xpath="//select[@name='Doctorspecialization']")
		private WebElement selectOption;
		
	    public WebElement getSelectOption() {
			return selectOption;
		}
	    @FindBy(xpath="//option[contains(text(),'Dental Care')]")
	    private WebElement dentalcareoptionedt;
	    @FindBy(xpath="//span[text()=' Manage Patients ']")
	    private WebElement managePatientEdt;
	    
	    @FindBy(xpath="//tr/td[text()='16.']/ancestor::tr/td/a/i[@class='fa fa-eye']")
	    private WebElement eyeIcon;
	    
	    
	    public WebElement getEyeIcon() {
			return eyeIcon;
		}

		public WebElement getManagePatientEdt() {
			return managePatientEdt;
		}

		public WebElement getDentalcareoptionedt() {
			return dentalcareoptionedt;
		}

		public void select(WebElement selectOption, String DentalCare ) {
			Select sel = new Select(selectOption);
			sel.selectByVisibleText(DentalCare);
		}
	    
		public void scrollToPage() {
			wutil.scrollBy(driver);
			
		}
		public void scrollDownPge() {
			wutil.scrollTo(driver);
		}
		
		public void alertPopUp() {
			wutil.switchToAlertAndAccept(driver);
		}
	    
		public void DoctorModuleCreationDetail(String docrorname, String doctorClentAddress, String doctorfee,String doctorContactNo,String doctorEmail, String password, String ConfirmPassword) throws InterruptedException {
				
			 docNameEdt.sendKeys(docrorname);
			 addressEdt.sendKeys(doctorClentAddress);
			 docfeeEdt.sendKeys(doctorfee);
			 docContactNumber.sendKeys(doctorContactNo);
			 docMailEdt.sendKeys(doctorEmail);
			 passwordEdt.sendKeys(password);
			 confirmPassEdt.sendKeys(ConfirmPassword);	
		     submitBtn.click();
			}
		}
