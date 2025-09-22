package com.comcast.hms.objectrepo_SMOKE;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class RegisterPage extends WebDriverUtility {

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Locators for patient registration form
	@FindBy(name = "full_name")
	private WebElement fullNameEdt;

	@FindBy(name = "address")
	private WebElement addressEdt;

	@FindBy(name = "city")
	private WebElement cityEdt;

	@FindBy(name = "email")
	private WebElement emailEdt;

	@FindBy(name = "password")
	private WebElement passwordEdt;

	@FindBy(name = "password_again")
	private WebElement confirmPasswordEdt;

	@FindBy(name = "submit")
	private WebElement submitBtn;

	// Action methods
	public void registerPatient(String fullName, String address, String city, String gender, String email,
			String password, WebDriver driver) {
		fullNameEdt.sendKeys(fullName);
		addressEdt.sendKeys(address);
		cityEdt.sendKeys(city);

		emailEdt.sendKeys(email);
		passwordEdt.sendKeys(password);
		confirmPasswordEdt.sendKeys(password);

// Ensure the button is visible and clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));

// Scroll into view in case it's hidden
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);

// Final click
		submitBtn.click();
	}

}
