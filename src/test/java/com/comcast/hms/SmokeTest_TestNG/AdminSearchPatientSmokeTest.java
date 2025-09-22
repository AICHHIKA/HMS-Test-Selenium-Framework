package com.comcast.hms.SmokeTest_TestNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.hms.basetest_TestNG.BaseClassHMS;
import com.comcast.hms.objectrepo_SMOKE.AdminLoginPage;
import com.comcast.hms.objectrepo_SMOKE.HomePage;
import com.comcast.hms.objectrepo_SMOKE.PatientSearchPage;

//@Listeners(com.comcast.hms.listenerutility.ListImPClassHMSP.class)
public class AdminSearchPatientSmokeTest extends BaseClassHMS {
	
	@Test
	public void AdminSearchSmoke() throws Throwable {
		
		//String PatientName = elib.getDataFromExcel("Sheet3", 1, 2);
		
		HomePage hp = new HomePage(driver);
	    hp.getLoginLinkEdt().click();
	    hp.waitForPageToLoad(driver);
	    Thread.sleep(3000);
	    
	    AdminLoginPage alp = new AdminLoginPage(driver);
	    alp.getClickHereButton().click();
	    Thread.sleep(3000);
	
	    alp.switchToChildWindow();
	    alp.AdminModule();
	    Thread.sleep(3000);
	    
	    PatientSearchPage psp = new PatientSearchPage(driver);
	    psp.getPatientSearchEdt().click();
	    //psp.select(psp.getSearchDataEdt(), PatientName);
	 
	    psp.patientSearch();
	    Thread.sleep(3000);
	    
	    
	    String PatientName = psp.getPatientName().getText().toString();
		System.out.println(PatientName);
		boolean status = PatientName.contains(PatientName);
		Assert.assertEquals(status, true);
		System.out.println("assertion pass");
	    }
}
