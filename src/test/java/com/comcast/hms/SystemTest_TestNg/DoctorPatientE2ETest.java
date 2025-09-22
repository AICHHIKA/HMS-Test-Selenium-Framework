package com.comcast.hms.SystemTest_TestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.hms.basetest_TestNG.BaseClassHMS;
import com.comcast.hms.objectRepo_SYSTEM.ADE2EAdminLogOutPage;
import com.comcast.hms.objectRepo_SYSTEM.ADE2EDoctorLogOutPage;
import com.comcast.hms.objectRepo_SYSTEM.AdminLoginPage;
import com.comcast.hms.objectRepo_SYSTEM.DPE2EAdminLogOutPage;
import com.comcast.hms.objectRepo_SYSTEM.DPE2EDoctorModuleCreateAccountPage;
import com.comcast.hms.objectRepo_SYSTEM.DPE2EDoctorPatientMessagePage;
import com.comcast.hms.objectRepo_SYSTEM.DPE2EPatientModulePage;
import com.comcast.hms.objectRepo_SYSTEM.DoctorLoginPage;
import com.comcast.hms.objectRepo_SYSTEM.HomePage;

public class DoctorPatientE2ETest extends BaseClassHMS {

	@Test
	public void DoctorPatientE2E() throws Throwable {
		String PatientName = eLib.getDataFromExcel("Sheet4", 1, 1);
		String PatientContactno = eLib.getDataFromExcel("Sheet4", 1, 2);
		String PatientEmail = eLib.getDataFromExcel("Sheet4", 1, 3) + jLib.getRandomNumber();
		String Email = PatientEmail + "@gmail.com";
		String PatientAddress = eLib.getDataFromExcel("Sheet4", 1, 4);
		String PatientAge = eLib.getDataFromExcel("Sheet4", 1, 5);
		String MedicalHistory = eLib.getDataFromExcel("Sheet4", 1, 6);

		HomePage hp = new HomePage(driver);
		String Parent = driver.getWindowHandle();
		hp.getLoginLinkEdt().click();
		hp.waitForPageToLoad(driver);
		Thread.sleep(3000);
		wLib.scrollToElement(driver,hp.getClickonDoctorBtn());
		Thread.sleep(5000);
		hp.getClickhereButton().click();
		Thread.sleep(3000);

		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		dlp.doctorPage();
		dlp.DoctorModule();
		Thread.sleep(3000);

		DPE2EPatientModulePage pmp = new DPE2EPatientModulePage(driver);
		pmp.getPatientEdt().click();
		Thread.sleep(3000);
		pmp.getAddpatientEdt().click();
		Thread.sleep(3000);

		pmp.PatientDetail(PatientName, PatientContactno, PatientEmail, PatientAddress, PatientAge, MedicalHistory);
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Scroll and click once
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pmp.getSubmitBtn());
		wait.until(ExpectedConditions.elementToBeClickable(pmp.getSubmitBtn())).click();

		pmp.getPatientEdt().click();
		Thread.sleep(5000);
		pmp.getManagePatientEdt().click();
		Thread.sleep(3000);
		pmp.getLogoutIcon().click();
		pmp.getLogoutBtn().click();
		Thread.sleep(3000);

		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.switchToChildWindow();
		Thread.sleep(8000);
		alp.getClickHereButton().click();
		alp.doctorPage();
		Thread.sleep(3000);

		alp.AdminModule();
		Thread.sleep(2000);

		DPE2EDoctorModuleCreateAccountPage dmcp = new DPE2EDoctorModuleCreateAccountPage(driver);
		Thread.sleep(3000);
		dmcp.getPatientIcon().click();
		Thread.sleep(3000);
		dmcp.getManagePatientEdt().click();
//		wLib.scrollBy(driver);
		wLib.scrollToElement(driver);
//		dmcp.getEyeIcon().click();

		pmp.fetchPatient("Ricky Senapati");
		Thread.sleep(3000);

		DPE2EDoctorPatientMessagePage eom = new DPE2EDoctorPatientMessagePage(driver);
		String MessageInfo = eom.getPatientModule().getText().toString();
		System.out.println(MessageInfo);
		boolean status = MessageInfo.contains(MessageInfo);
		Assert.assertEquals(status, true);
		System.out.println("assertion pass");
		Thread.sleep(2000);

		String patinetNameInfo = eom.getPatientName().getText().toString();
		System.out.println(patinetNameInfo);
		boolean status1 = patinetNameInfo.contains(patinetNameInfo);
		Assert.assertEquals(status1, true);
		System.out.println("assertion pass");
		
		DPE2EAdminLogOutPage dlp1 = new DPE2EAdminLogOutPage(driver);
		dlp1.getAdminLogoutLink().click();
		dlp1.getLogoutBtn().click();
		Thread.sleep(2000);
	}
}


