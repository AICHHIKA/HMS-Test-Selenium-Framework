package com.comcast.hms.SmokeTest_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.hms.basetest_TestNG.BaseClassHMS;
import com.comcast.hms.objectrepo_SMOKE.DepartmentGalleryPage;
import com.comcast.hms.objectrepo_SMOKE.HomePage;

public class ListOfDepartmentSmokeTest extends BaseClassHMS{

	@Test
	public void ListOfDepartmentSmoke() throws Throwable {
		
		HomePage hp = new HomePage(driver);
		hp.getGalleryEdt().click();
		
		DepartmentGalleryPage dgp = new DepartmentGalleryPage(driver);
		dgp.getDentalImg().click();
		Thread.sleep(3000);
		dgp.getCardiologyImg().click();
		Thread.sleep(3000);
		dgp.getNeurologyImg().click();
		Thread.sleep(3000);
		dgp.getLaboratryImg().click();
		Thread.sleep(3000);
		String GalleryInfo = dgp.getGalleryPageInfo().getText().toString();
		System.out.println(GalleryInfo);
		boolean status = GalleryInfo.contains(GalleryInfo);
		Assert.assertEquals(status, true);
		System.out.println("assertion pass");
	}
}
