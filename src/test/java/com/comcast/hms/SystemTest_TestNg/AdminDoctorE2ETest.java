package com.comcast.hms.SystemTest_TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.hms.basetest_TestNG.BaseClassHMS;
import com.comcast.hms.generic.webdriverutility.WebDriverUtility;
import com.comcast.hms.objectRepo_SYSTEM.ADE2EAdminLogOutPage;
import com.comcast.hms.objectRepo_SYSTEM.ADE2EDoctorLogOutPage;
import com.comcast.hms.objectRepo_SYSTEM.ADE2EDoctorModuleCreateAccountPage;
import com.comcast.hms.objectRepo_SYSTEM.ADE2EDoctorProfilePage;
import com.comcast.hms.objectRepo_SYSTEM.AdminLoginPage;
import com.comcast.hms.objectRepo_SYSTEM.AdminModulePage;
import com.comcast.hms.objectRepo_SYSTEM.DoctorLoginPage;
import com.comcast.hms.objectRepo_SYSTEM.HomePage;

public class AdminDoctorE2ETest extends BaseClassHMS {

	@Test
	public void AdminDoctorE2E() throws Throwable {

		String DoctorName = eLib.getDataFromExcel("Sheet2", 1, 1);
		String DoctorClinicAdd = eLib.getDataFromExcel("Sheet2", 1, 2);
		String DoctorConsultancyFee = eLib.getDataFromExcel("Sheet2", 1, 3);
		String DoctorContactNo = eLib.getDataFromExcel("Sheet2", 1, 4);
		String DoctorEmail = eLib.getDataFromExcel("Sheet2", 1, 5)+jLib.getRandomNumber();
		String Email = DoctorEmail+"@gmail.com" ;
		String Password = eLib.getDataFromExcel("Sheet2", 1, 6);
		String ConfirmPassword = eLib.getDataFromExcel("Sheet2", 1, 7);
		String Option = eLib.getDataFromExcel("Sheet2", 1, 8);
 
		HomePage hp = new HomePage(driver);
		String Parent = driver.getWindowHandle();
		hp.getLoginLinkEdt().click();
		hp.waitForPageToLoad(driver);
		Thread.sleep(3000);

		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.getClickHereButton().click();
		Thread.sleep(3000);

		alp.switchToChildWindow();
		alp.AdminModule();
		Thread.sleep(3000);

		AdminModulePage amp = new AdminModulePage(driver);
		amp.getDoctorIconEdt().click();
		amp.getAddDoctorEdt().click();
		ADE2EDoctorModuleCreateAccountPage dmcp = new ADE2EDoctorModuleCreateAccountPage(driver);
		Thread.sleep(3000);

		dmcp.select(dmcp.getSelectOption(), Option);
		dmcp.DoctorModuleCreationDetail(DoctorName, DoctorClinicAdd, DoctorConsultancyFee, DoctorContactNo, Email,
			 	Password, ConfirmPassword);
		Thread.sleep(8000);
		dmcp.alertPopUp();
		Thread.sleep(3000);

		ADE2EAdminLogOutPage alpp = new ADE2EAdminLogOutPage(driver);
		alpp.getAdminLogoutLink().click();
		alpp.getLogoutBtn().click();
		Thread.sleep(5000);
		wLib.scrollToElement(driver,hp.getClickonDoctorBtn());
		Thread.sleep(5000);
		hp.getClickhereButton().click();
		Thread.sleep(3000);

		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		dlp.doctorPage();
		dlp.DoctorModule();
		Thread.sleep(3000);

		ADE2EDoctorProfilePage dpp = new ADE2EDoctorProfilePage(driver);
		dpp.getNameIcon().click();
		dpp.getProfilePgae().click();
		Thread.sleep(3000);

		String DoctorInfo = dpp.getProfileInformationEdt().getText().toString();
		System.out.println(DoctorInfo);
		boolean status1 = DoctorInfo.contains(DoctorInfo);
		Assert.assertEquals(status1, true);
		System.out.println("assertion pass");

		ADE2EDoctorLogOutPage dlp1 = new ADE2EDoctorLogOutPage(driver);
		dlp1.getLogoutIcon().click();
		Thread.sleep(2000);
		dlp1.getLogoutBtn().click();
		Thread.sleep(3000);
	}
}
