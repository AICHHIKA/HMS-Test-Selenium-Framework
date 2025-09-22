package com.comcast.hms.IntegrationTest_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.hms.basetest_TestNG.BaseClassHMS;
import com.comcast.hms.objectrepo_INTEGRATION.AboutUsPage;
import com.comcast.hms.objectrepo_INTEGRATION.IITAdminLoginPage;
import com.comcast.hms.objectrepo_INTEGRATION.HomePage;
import com.comcast.hms.objectrepo_INTEGRATION.IITAboutUsMessagePage;
import com.comcast.hms.objectrepo_INTEGRATION.IITAdminLogOutPage;

public class AdminToAboutUsIntTest extends BaseClassHMS {

	@Test
	public void InformationIntegration() throws Throwable {
		
		// HP, ADMINPAGE, PAGES, ABOUTUS
		HomePage hp = new HomePage(driver);
		String Parent = driver.getWindowHandle();
		hp.getLoginLinkEdt().click();
		hp.waitForPageToLoad(driver);
		Thread.sleep(3000);

		IITAdminLoginPage alp = new IITAdminLoginPage(driver);
		alp.getClickHereButton().click();
		Thread.sleep(3000);

		alp.switchToChildWindow();
		alp.AdminModule();
		Thread.sleep(3000);

		AboutUsPage aup = new AboutUsPage(driver);
		aup.getPageEdt().click();
		aup.getAboutUspageEdt().click();
		Thread.sleep(3000);

		IITAboutUsMessagePage aump = new IITAboutUsMessagePage(driver);
		String MessageInfo = aump.getMessageEdt().getText().toString();
		System.out.println(MessageInfo);
		boolean status = MessageInfo.contains(MessageInfo);
		Assert.assertEquals(status, true);
		System.out.println("assertion pass");

		IITAdminLogOutPage alpp = new IITAdminLogOutPage(driver);
		alpp.getAdminLogoutLink().click();
		alpp.getLogoutBtn().click();
		Thread.sleep(3000);
	}

}
