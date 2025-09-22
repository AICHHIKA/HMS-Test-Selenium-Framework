package com.comcast.hms.objectrepo_SMOKE;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement usernameEdt;

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	@FindBy(name = "password")
	private WebElement passwordEdt;

	@FindBy(name = "submit")
	private WebElement loginBtn;

	public WebDriver getDriver() {
		return driver;
	}

	public void loginAsAdmin(String url, String username, String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

	public void loginAsDoctor(String url, String username, String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

	public void loginAsPatient(String url, String username, String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
//		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		  wait.until(ExpectedConditions.alertIsPresent()); //Handle the alaert after login
//		  Alert alert =driver.switchTo().alert();
//		  System.out.println("Alert says:" +alert.getText()); 
//		  alert.accept();
		 
	}

	public void doctorPage() {
		// TODO Auto-generated method stub
		
	}

	public void DoctorModule() {
		// TODO Auto-generated method stub
		
	}

	public WebElement getClickHereButton() {
		// TODO Auto-generated method stub
		return null;
	}

	public void AdminModule() {
		// TODO Auto-generated method stub
		
	}

	public void waitAndClickDoctorLogin() {
		// TODO Auto-generated method stub
		
	}
}
//I have shared my POM page class , create script , base class for the same