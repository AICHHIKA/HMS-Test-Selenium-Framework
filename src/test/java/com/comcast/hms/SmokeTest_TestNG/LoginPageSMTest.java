package com.comcast.hms.SmokeTest_TestNG;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.comcast.hms.basetest_TestNG.BaseClassHMS;
import com.comcast.hms.objectrepo_SMOKE.LoginPage;

public class LoginPageSMTest extends BaseClassHMS {
	
	@Test
	public void verifyAdminLogin() throws Throwable {

		String Admin_URL = fLib.getDataFromPropertiesFile("adminurl");
		String Admin_USERNAME = fLib.getDataFromPropertiesFile("adminusername");
		String Admin_PASSWORD = fLib.getDataFromPropertiesFile("adminpassword");

		LoginPage lp = new LoginPage(driver);
		lp.loginAsAdmin(Admin_URL, Admin_USERNAME, Admin_PASSWORD);
		System.out.println("Admin Login Successful");
	}

	@Test
	public void verifyDoctorLogin() throws Throwable {
		String DOCTOR_URL = fLib.getDataFromPropertiesFile("doctorurl");
		String DOCTOR_USERNAME = fLib.getDataFromPropertiesFile("doctorusername");
		String DOCTOR_PASSWORD = fLib.getDataFromPropertiesFile("doctorpassword");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginAsDoctor(DOCTOR_URL, DOCTOR_USERNAME, DOCTOR_PASSWORD);

		System.out.println("Doctor Login Successful");
	}

	@Test
	public void verifyPatientLogin() throws Throwable {
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		Thread.sleep(8000);

		String PATIENT_URL = fLib.getDataFromPropertiesFile("patienturl");
		String PATIENT_USERNAME = fLib.getDataFromPropertiesFile("patientusername");
		String PATIENT_PASSWORD = fLib.getDataFromPropertiesFile("patientpassword");

		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(8000);
		loginPage.loginAsPatient(PATIENT_URL, PATIENT_USERNAME, PATIENT_PASSWORD);
		System.out.println("Patient Login Successful");
		
	}  
}
