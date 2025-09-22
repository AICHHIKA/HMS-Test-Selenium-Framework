package com.comcast.hms.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.hms.basetest_TestNG.BaseClassHMS;
import com.comcast.hms.generic.webdriverutility.ThreadLocal_UtilityClassObject;


public class ListImPClassHMSP implements ITestListener, ISuiteListener {

		public ExtentReports report;
		public static ExtentTest test;


		@Override
		public void onStart(ISuite suite) {
			 ISuiteListener.super.onStart(suite);
			System.out.println("Report configuration");

			// spark report congigue
			ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
			spark.config().setDocumentTitle("HMS Test Suite Results");
			spark.config().setReportName("HMS Report");
			spark.config().setTheme(Theme.DARK);

			// step :2 add env info and create Test.
			report = new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("OS", "Windows-10");
			report.setSystemInfo("BROWSER", "CHROME-100");

		}

		@Override
		public void onFinish(ISuite suite) {
			 ISuiteListener.super.onFinish(suite);
			System.out.println("Report backUP");
			report.flush();
		}

		@Override
		public void onTestStart(ITestResult result) {
			 ITestListener.super.onTestStart(result);
			System.out.println("====>" + result.getMethod().getMethodName() + ">===START===");
			test = report.createTest(result.getMethod().getMethodName());
			 test.log(Status.INFO, result.getMethod().getMethodName()+"====>Started<====");
			ThreadLocal_UtilityClassObject.setTest(test);
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			 ITestListener.super.onTestSuccess(result);
			System.out.println("====>" + result.getMethod().getMethodName() + ">===END===");
			test.log(Status.PASS, result.getMethod().getMethodName() + "====>Completed<====");
		}

		@Override
		public void onTestFailure(ITestResult result) {
			 ITestListener.super.onTestFailure(result);
			String testName = result.getMethod().getMethodName();

			/*
			 * TakesScreenshot ts = (TakesScreenshot)
			 * ThreadLocal_UtilityClassObject.getDriver(); 
			 * String temp =
			 * ts.getScreenshotAs(OutputType.BASE64);
			 */
			TakesScreenshot edriver = (TakesScreenshot) (BaseClassHMS.sdriver);
			File srcFile = edriver.getScreenshotAs(OutputType.FILE);

			TakesScreenshot eDriver = (TakesScreenshot) BaseClassHMS.sdriver;
			String filePath= eDriver.getScreenshotAs(OutputType.BASE64);

//			 File temp = ts.getScreenshotAs(OutputType.FILE);
			String time = new Date().toString().replace(" ", "_").replace(":", "_");// Time based screenshot.

			try {

				FileUtils.copyFile(srcFile, new File("./screenshot/" + testName + "+" + time+".png"));

			} catch (IOException e) {
				e.printStackTrace();
			}

			// Try to attach the screenShot in extentReport
			test.addScreenCaptureFromBase64String(filePath, testName + "_" + time);
			test.log(Status.FAIL, result.getMethod().getMethodName() + "====>FAILED<====");
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			ITestListener.super.onTestSkipped(result);
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		}

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			ITestListener.super.onTestFailedWithTimeout(result);
		}



		@Override
		public int hashCode() {
			return super.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}

		@Override
		public String toString() {
			return super.toString();
		}

		@SuppressWarnings("removal")
		@Override
		protected void finalize() throws Throwable {
			super.finalize();
		}
	}

