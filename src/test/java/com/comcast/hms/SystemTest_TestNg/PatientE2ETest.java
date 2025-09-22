package com.comcast.hms.SystemTest_TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.hms.basetest_TestNG.BaseClassHMS;
import com.comcast.hms.objectRepo_SYSTEM.AdminLoginPage;
import com.comcast.hms.objectRepo_SYSTEM.AdminModulePage;
import com.comcast.hms.objectRepo_SYSTEM.DPE2EAdminLogOutPage;
import com.comcast.hms.objectRepo_SYSTEM.HomePage;
import com.comcast.hms.objectRepo_SYSTEM.PE2EAdminLogOutPage;
import com.comcast.hms.objectRepo_SYSTEM.PE2EPatientAppointmentHistoryPage;
import com.comcast.hms.objectRepo_SYSTEM.PE2EPatientBookAppointmentPage;
import com.comcast.hms.objectRepo_SYSTEM.PE2EPatientRegFirstPage;
import com.comcast.hms.objectRepo_SYSTEM.PatientLoginPage;

public class PatientE2ETest extends BaseClassHMS {

	@Test
	public void PatientE2E() throws Throwable {
		String PatientName = eLib.getDataFromExcel("Sheet5", 1, 1);
		String patientADD = eLib.getDataFromExcel("Sheet5", 1, 2);
		String PatientCity = eLib.getDataFromExcel("Sheet5", 1, 3);
		String PatientEmail = eLib.getDataFromExcel("Sheet5", 1, 4) + jLib.getRandomNumber();
		String Email = PatientEmail + "@gmail.com";
		String Password = eLib.getDataFromExcel("Sheet5", 1, 5);
		String ConfirmPassword = eLib.getDataFromExcel("Sheet5", 1, 6);

		String DoctorSpecilaztion = eLib.getDataFromExcel("Sheet5", 4, 1);
		String Doctor = eLib.getDataFromExcel("Sheet5", 4, 2);
		String Date = eLib.getDataFromExcel("Sheet5", 4, 3);

		HomePage hp = new HomePage(driver);
		String Parent = driver.getWindowHandle();
		hp.getLoginLinkEdt().click();
		hp.waitForPageToLoad(driver);
		Thread.sleep(3000);
		wLib.scrollToElement(driver, hp.getClickonPatientBtn());
		Thread.sleep(5000);
	
		PE2EPatientRegFirstPage prp = new PE2EPatientRegFirstPage(driver);
		prp.getClickHereBtn().click();
		Thread.sleep(2000);
		prp.switchToChildWindow();
		prp.getCreateAccountBtn().click();
		Thread.sleep(2000);
		prp.PatientCreationDetail(PatientName, patientADD, PatientCity, Email, Password, ConfirmPassword);
		Thread.sleep(5000);
		prp.switchToAlertAndAccept(driver);

		PatientLoginPage plp = new PatientLoginPage(driver);
		wLib.scrollToElement(driver, plp.getClickOnLoginLink());
		plp.getClickOnLoginLink().click();

		plp.PatientLogin();
		
		Thread.sleep(3000);

		PE2EPatientBookAppointmentPage pba = new PE2EPatientBookAppointmentPage(driver);
		Thread.sleep(2000);
		pba.getBookAppointmentEdt().click();
		Thread.sleep(3000);
		pba.AppointmentDetail(DoctorSpecilaztion, Doctor);
		Thread.sleep(5000);
		
		// Scroll and click once
				
		//Thread.sleep(3000);
//		wLib.scrollToElement(driver, pba.getDateEdt());
		//pba.getDateEdt().click();
		// Thread.sleep(3000);
		// pba.getSubmitBtn().click();

		pba.switchToAlertAndAccept(driver);
		Thread.sleep(2000);
		PE2EPatientAppointmentHistoryPage abp = new PE2EPatientAppointmentHistoryPage(driver);
		abp.getBookingHistory().click();
		Thread.sleep(3000);

		String patinetAppointmentInfo = abp.getAppointmentHistory().getText().toString();
		System.out.println(patinetAppointmentInfo);
		boolean status1 = patinetAppointmentInfo.contains(patinetAppointmentInfo);
		Assert.assertEquals(status1, true);
		System.out.println("assertion pass");
		
		Thread.sleep(2000);
		prp.getLogoutIcon().click();
		prp.getLogoutButton().click();
		Thread.sleep(3000);

		hp.getLoginLinkEdt().click();
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

		AdminModulePage amp = new AdminModulePage(driver);
		amp.getAppointmentHistory().click();
		Thread.sleep(3000);

		String AdminModuleAppointmentInfo = abp.getAdminModuleAppointmentHistory().getText().toString();
		System.out.println(AdminModuleAppointmentInfo);
		boolean status2 = AdminModuleAppointmentInfo.contains(AdminModuleAppointmentInfo);
		Assert.assertEquals(status2, true);
		System.out.println("assertion pass");
		
		PE2EAdminLogOutPage dlp1 = new PE2EAdminLogOutPage(driver);
		dlp1.getAdminLogoutLink().click();
		dlp1.getLogoutBtn().click();
		Thread.sleep(2000);
	}

}
