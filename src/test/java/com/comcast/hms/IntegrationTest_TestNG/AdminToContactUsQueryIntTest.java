package com.comcast.hms.IntegrationTest_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.hms.basetest_TestNG.BaseClassHMS;
import com.comcast.hms.objectrepo_INTEGRATION.AdminModuleQueryPage;
import com.comcast.hms.objectrepo_INTEGRATION.IITAdminLoginPage;
import com.comcast.hms.objectrepo_INTEGRATION.ATCUQAdminModuleQueryPage;
import com.comcast.hms.objectrepo_INTEGRATION.ATCUQAdminLoginPage;
import com.comcast.hms.objectrepo_INTEGRATION.ATCUQContactUsPage;
import com.comcast.hms.objectrepo_SMOKE.HomePage;

public class AdminToContactUsQueryIntTest extends BaseClassHMS {

	@Test
	public void AdminToContactUsQuery() throws Throwable {
     HomePage hp = new HomePage(driver);
     hp.getContactUsEdt().click();
     Thread.sleep(3000);
     
        String Name = eLib.getDataFromExcel("Sheet1", 1, 1);
		String Email = eLib.getDataFromExcel("Sheet1", 1, 2);
		String PhoneNumber = eLib.getDataFromExcel("Sheet1", 1, 3);
		String comments = eLib.getDataFromExcel("Sheet1", 1, 4);
		
		ATCUQContactUsPage cup = new ATCUQContactUsPage(driver);
		cup.ContactUsDetails(Name, Email, PhoneNumber, comments);
		
		Thread.sleep(2000);
		cup.switchToAlertAndAccept(driver);
		Thread.sleep(3000);
		
		hp.getLoginLinkEdt().click();
		String Parent = driver.getWindowHandle();
		
		ATCUQAdminLoginPage alp = new ATCUQAdminLoginPage(driver);
		alp.getClickHereButton().click();
		alp.switchToChildWindow();
		alp.AdminModule();
	
		ATCUQAdminModuleQueryPage amp = new ATCUQAdminModuleQueryPage(driver);
		amp.getQueryEdt().click();
		amp.getUnreadQueryEdt().click();
		Thread.sleep(3000);
		
		String MessageInfo = amp.getManageQueryPage().getText().toString();
		System.out.println(MessageInfo);
		boolean status = MessageInfo.contains(MessageInfo);
		Assert.assertEquals(status, true);
		System.out.println("assertion pass");
	}
}
