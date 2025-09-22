package com.comcast.hms.IntegrationTest_TestNG;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.comcast.hms.basetest_TestNG.BaseClassHMS;
import com.comcast.hms.objectrepo_INTEGRATION.ContactUsPage;
import com.comcast.hms.objectrepo_INTEGRATION.HomePage;

public class ContactUsServicesIntegrationTest extends BaseClassHMS {

	@Test
	public void verifyContactUsAndServices() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getContactUsEdt().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(hp.getContactUsEdt())).click();

		int rowCount = eLib.getRowcount("Sheet1");
		for (int i = 1; i <= rowCount; i++) {
			String name = eLib.getDataFromExcel("Sheet1", i, 1);
			String email = eLib.getDataFromExcel("Sheet1", i, 2);
			String phone = eLib.getDataFromExcel("Sheet1", i, 3);
			String desc = eLib.getDataFromExcel("Sheet1", i, 4);
			System.out.println("Row " + i + ": " + name + " | " + email + " | " + phone + " | " + desc + " | ");

			// Fill Contact Us form
			ContactUsPage contact = new ContactUsPage(driver);

			contact.enterName(name);
			contact.enterEmail(email);
			contact.enterMobileNo(phone);

			contact.enterDescription(desc);
			contact.clickSendMessageBtn();
			Thread.sleep(2000);
			String successMsg = contact.handleSuccessAlert();
//			System.out.println("Success message fetched: " + successMsg);
//			Assert.assertTrue(successMsg.contains("successfully submitted"));
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			String msg = alert.getText();
			alert.accept();
//			Assert.assertTrue(msg.contains("successfully submitted"));

			contact.clickSubmit();
			wait.until(ExpectedConditions.elementToBeClickable(hp.getContactUsEdt())).click();
			contact.clickSendMessageBtn();

			// wait for alert

			// get text and accept

			// Verify success message (use contains instead of exact match) String
			successMsg = contact.getSuccessMessage();
			Assert.assertTrue(successMsg.contains("submitted successfully"),
					"Expected success message not found! Actual: " + successMsg);

		}

	}
}