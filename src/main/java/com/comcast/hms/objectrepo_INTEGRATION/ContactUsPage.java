package com.comcast.hms.objectrepo_INTEGRATION;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class ContactUsPage extends WebDriverUtility {
	
	    WebDriver driver;
	    public ContactUsPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(name="fullname")
	    private WebElement fullNameTxt;

	    @FindBy(name="emailid")
	    private WebElement emailIdTxt;

	    @FindBy(name="mobileno")
	    private WebElement mobileNoTxt;

	    @FindBy(name="description")
	    private WebElement descriptionTxt;

	    @FindBy(xpath ="//button[text()='Send Message']")
	    private WebElement sendMessageBtn;
	    
//	    @FindBy(xpath = "//button[@type='submit' and text()='Send Message']")
//	    private WebElement submitBtn;
	    
	    @FindBy(xpath = "(//button[@class='btn btn-success btn-sm'])[4]") // adjust locator
        private WebElement successMsg;
//	    
//	    public void clickSubmit(WebDriver driver) {
//	        // Wait until clickable
//	        new WebDriverWait(driver, Duration.ofSeconds(10))
//	            .until(ExpectedConditions.elementToBeClickable(submitBtn));
//	        submitBtn.click();
//	    }
   
	    public WebElement getFullNameTxt() {
			return fullNameTxt;
		}

		public WebElement getEmailIdTxt() {
			return emailIdTxt;
		}

		public WebElement getMobileNoTxt() {
			return mobileNoTxt;
		}
		@FindBy(xpath = "//textarea[@name='description']")
			private WebElement comment;
		public WebElement getComment() {
			return comment;
		}

		public WebElement getSendMessageBtn() {
			return sendMessageBtn;
		}
		
		public WebElement getSuccessMsg() {
		    return successMsg;
		}

		// Business Methods
	    public void enterName(String fullname) {
	    	fullNameTxt.clear();
	        fullNameTxt.sendKeys(fullname);
	    }

	    public void enterEmail(String emailid) {
	    	emailIdTxt.clear();
	        emailIdTxt.sendKeys(emailid);
	    }

	    public void enterMobileNo(String mobileNo) {
	    	mobileNoTxt.clear();
	        mobileNoTxt.sendKeys(mobileNo);
	    }

	    public void enterDescription(String description) {
	    	descriptionTxt.clear();
	        descriptionTxt.sendKeys(description);
	    }
	    
	    public void clickSendMessageBtn() {
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.elementToBeClickable(sendMessageBtn))
	            .click();
	    }
	    
	    
	    public String getSuccessMessage1() {
	        return new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.visibilityOf(successMsg))
	            .getText();
	    }
	    
	    public String getSuccessMessage() {
	        // Wait until the success message is visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement msgElement = wait.until(ExpectedConditions.visibilityOf(successMsg));
	        return msgElement.getText();  // return the actual text
	    }
	    
	    public String handleSuccessAlert() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // wait for alert
	        String alertText = alert.getText();  // read the message
	        alert.accept(); // click OK
	        return alertText;
	    }

//	    public void clickSendMessageBtn() {
//	        sendMessageBtn.click();
//	    }
		/*
		 * public String getSuccessMessage() { // Adjust locator according to your AUT
		 * return driver.switchTo().alert().getText(); }
		 */

			public void enterContactDetails(String name, String email, String phone) {
			// TODO Auto-generated method stub
			
		}

		public void clickSubmit() {
			// TODO Auto-generated method stub
			
		}

		public void enterName1(String fullname) {
			// TODO Auto-generated method stub
			
		}

		public void enterEmail(Object emailid) {
			// TODO Auto-generated method stub
			
		}

		public void enterName(Object fullname) {
			// TODO Auto-generated method stub
			
		}

		public void ContactUsDetails(String name, String email, String phoneNumber, String comments) {
			// TODO Auto-generated method stub
			getFullNameTxt().sendKeys(name);
			getEmailIdTxt().sendKeys(email);
			getMobileNoTxt().sendKeys(phoneNumber);
			getComment().sendKeys(comments);
			getSendMessageBtn().click();
			
		}

		public void enterPhone(String phone) {
			// TODO Auto-generated method stub
			
		}

		public void getSuccessMessageElement() {
			// TODO Auto-generated method stub
		
		}

//		public String getSuccessMessage() {
//			return null;
//			// TODO Auto-generated method stub
//			
//		}
	}


