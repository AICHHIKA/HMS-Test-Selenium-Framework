package com.comcast.hms.basetest_TestNG;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.hms.generic.fileutility.ExcelUtility;
import com.comcast.hms.generic.fileutility.FileUtility;
import com.comcast.hms.generic.fileutility.JavaUtility;
import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

public class BaseClassHMS {
	public WebDriver driver;
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public static WebDriver sdriver = null;
	
	@BeforeSuite
	public void BFMethod() {
	System.out.println("Before Class");
	}

	@BeforeClass
	public void launchBrowser() throws Throwable {
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		final Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
	 	chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(chromeOptions);
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
	
			driver = new ChromeDriver(chromeOptions); 
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String URL = fLib.getDataFromPropertiesFile("url");
		driver.get(URL);
		sdriver= driver;
		}
	
	@BeforeMethod
	public void BMMethod() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void AMMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
	@AfterMethod 
	public void ASMethod() {
	System.out.println("Method Class");
	}
}
