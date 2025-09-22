package com.comcast.hms.objectRepo_SYSTEM;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.fileutility.JavaUtility;
import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class DoctorLoginPage extends WebDriverUtility {

	WebDriver driver;
	public DoctorLoginPage(WebDriver driver) {
		this.driver = driver;
		
	PageFactory.initElements(driver, this);
			
	}
	@FindBy(name="username")
	private WebElement DoctoruserName;
	
	@FindBy(name="password")
	private WebElement DoctorPasswordEdt;
	
	@FindBy(xpath="//button[contains(text(),'Login')] ")
	private WebElement submitBtn;
	
	public WebElement getDoctoruserName() {
		return DoctoruserName;
	}

	public WebElement getDoctorPasswordEdt() {
		return DoctorPasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void switchToChildWindow() {
		 String parentWindow = driver.getWindowHandle();

		 // Get all window handles
		 Set<String> allWindows = driver.getWindowHandles();

		 for (String window : allWindows) {
		     if (!window.equals(parentWindow)) {
		         // Switch to the new window
		         driver.switchTo().window(window);
		         break;
		     }}}
	public void switchToChildWindowWithTitle() {
		 String parentWindow = driver.getWindowHandle();

		 // Get all window handles
		 Set<String> allWindows = driver.getWindowHandles();

		 for (String window : allWindows) {
		     if (!window.equals(parentWindow)) {
		         // Switch to the new window
		         driver.switchTo().window(window);
		         break;
		     }}}
	public void switchToTabOnTitle(WebDriver driver,String partailTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String windowID=it.next();
			driver.switchTo().window(windowID);
			
			String actUrl = driver.getTitle();
			if(actUrl.contains(partailTitle));
			break;
		}
		 //example of method overloading
	}
	public void doctorPage() {
		 String currentsession = driver.getWindowHandle();
  	   Set<String> cids = driver.getWindowHandles();
  	   for(String cid:cids) {
  		   driver.switchTo().window(cid);
  	   }
	}
	
	 public void DoctorModule() 
	 {
		 JavaUtility j=new JavaUtility();
		 int ran_value = j.getRandomNumber();
		 getDoctoruserName().sendKeys("aichhi@gmail.com");   
		 getDoctorPasswordEdt().sendKeys("Aichhi@123");
			submitBtn.click();
	}
}
