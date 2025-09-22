package com.comcast.hms.SmokeTest_TestNG;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.hms.basetest_TestNG.BaseClassHMS;
import com.comcast.hms.objectrepo_SMOKE.RegisterPage;

public class PatientRegistrationSMTest extends BaseClassHMS {

	@Test
	public void PatientRegistrationSmoke() throws Throwable {
		final Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false); 

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);

		String name = fLib.getDataFromPropertiesFile("patientname");
		String address = fLib.getDataFromPropertiesFile("patientaddress");
		String city = fLib.getDataFromPropertiesFile("patientcity");

		
		  // Generate random credentials dynamically 
//		String randomEmail =  jLib.getRandomEmail(); 
//		  String randomPassword = jLib.getRandomPassword();
		 

		String PATIENTREG_URL = fLib.getDataFromPropertiesFile("patientregurl");

		// Navigate to Registration Page
		driver.get(PATIENTREG_URL);

//		RegisterPage registerPage = new RegisterPage(driver);
//		registerPage.registerPatient(name, address, city,  PATIENTREG_URL, driver);

		/*
		 * // Example validation String actualTitle = driver.getTitle();
		 * Assert.assertTrue(actualTitle.contains("User Registration") ||
		 * actualTitle.contains("Home"), "Registration failed - Unexpected title:" +
		 * actualTitle);
		 * 
		 * System.out.println( "Patient Registration Completed with Email: " +
		 * randomEmail + " and Password: " + randomPassword);
		 */	
		}
}
