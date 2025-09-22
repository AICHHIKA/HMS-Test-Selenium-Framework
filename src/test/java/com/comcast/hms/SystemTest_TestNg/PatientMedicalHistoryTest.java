package com.comcast.hms.SystemTest_TestNg;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.comcast.hms.basetest_TestNG.BaseClassHMS;
import com.comcast.hms.objectRepo_SYSTEM.AdminLoginPage;
import com.comcast.hms.objectRepo_SYSTEM.DoctorLoginPage;
import com.comcast.hms.objectRepo_SYSTEM.HomePage;
import com.comcast.hms.objectRepo_SYSTEM.PMHAddMedicalHistoryPage;
import com.comcast.hms.objectRepo_SYSTEM.PMHAdminPatientModulePage;
import com.comcast.hms.objectRepo_SYSTEM.PMHDoctorLogOutPage;
import com.comcast.hms.objectRepo_SYSTEM.PMHPatientModulePage;

public class PatientMedicalHistoryTest extends BaseClassHMS {

	@Test
	public void PatientMedicalHistory() throws Throwable {
		String PatientName = eLib.getDataFromExcel("Sheet6", 1, 1);
		String PatientContactno = eLib.getDataFromExcel("Sheet6", 1, 2);
		String PatientEmail = eLib.getDataFromExcel("Sheet6", 1, 3) + jLib.getRandomNumber();
		String Email = PatientEmail + "@gmail.com";
		String PatientAddress = eLib.getDataFromExcel("Sheet6", 1, 4);
		String PatientAge = eLib.getDataFromExcel("Sheet6", 1, 5);
		String MedicalHistory = eLib.getDataFromExcel("Sheet6", 1, 6);

		String BloodPressure = eLib.getDataFromExcel("Sheet6", 5, 1);
		String BloodSugar = eLib.getDataFromExcel("Sheet6", 5, 2);
		String Weight = eLib.getDataFromExcel("Sheet6", 5, 3);
		String BodyTemprature = eLib.getDataFromExcel("Sheet6", 5, 4);
		String Prescription = eLib.getDataFromExcel("Sheet6", 5, 5);

		HomePage hp = new HomePage(driver);
		String Parent = driver.getWindowHandle();
		hp.getLoginLinkEdt().click();
		hp.waitForPageToLoad(driver);
		hp.getClickhereButton().click();
		Thread.sleep(3000);

		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		dlp.doctorPage();
		dlp.DoctorModule();
		Thread.sleep(3000);
			
		PMHPatientModulePage pmp = new PMHPatientModulePage(driver);
		pmp.getPatientEdt().click();
		Thread.sleep(3000);
		pmp.getAddpatientEdt().click();
		Thread.sleep(3000);
		pmp.PatientDetail(PatientName, PatientContactno, PatientEmail, PatientAddress, PatientAge, MedicalHistory);
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		// Scroll and click once
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pmp.getSubmitBtn());
		pmp.getSubmitBtn().click();
//		wait.until(ExpectedConditions.elementToBeClickable(pmp.getSubmitBtn())).click();

		pmp.getPatientEdt().click();
		pmp.getManagePatientEdt().click();
		pmp.getEyeIconEdt().click();
		wLib.scrollToElement(driver, pmp.getAddMedicalHistoryBtn());

		pmp.getAddMedicalHistoryBtn().click();
		Thread.sleep(3000);  

		PMHAddMedicalHistoryPage amhp = new PMHAddMedicalHistoryPage(driver);

		amhp.PatientCreationDetail(BloodPressure, BloodSugar, Weight, BodyTemprature, Prescription);
		Thread.sleep(3000);
		amhp.switchToAlertAndAccept(driver);
		Thread.sleep(3000);

		PMHDoctorLogOutPage dlp1 = new PMHDoctorLogOutPage(driver);
		dlp1.getLogoutIcon().click();
		dlp1.getLogoutBtn().click();
		Thread.sleep(3000);
		driver.close();

		driver.switchTo().window(Parent);
		hp.getLoginLinkEdt().click();
		Thread.sleep(3000);
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.getClickHereButton().click();
		alp.switchToChildWindow();
		alp.AdminModule();
		Thread.sleep(3000);

		PMHAdminPatientModulePage app = new PMHAdminPatientModulePage(driver);
		app.getPatientModuleEdt().click();
		app.getManagepatientLink().click();
	}
}
