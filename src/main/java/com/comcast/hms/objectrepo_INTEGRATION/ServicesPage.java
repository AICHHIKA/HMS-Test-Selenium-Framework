package com.comcast.hms.objectrepo_INTEGRATION;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.hms.generic.webdriverutility.WebDriverUtility;

	public class ServicesPage extends WebDriverUtility {
		
		    WebDriver driver;

		    @FindBy(xpath = "//section[@id='services']//h5")
		    private List<WebElement> serviceNames;

		    // Proper constructor
		    public ServicesPage(WebDriver driver) {
		        this.driver = driver;
		        PageFactory.initElements(driver, this);
		    }

		    public boolean isServiceDisplayed(String serviceName) {
		        for (WebElement service : serviceNames) {
		            if (service.getText().equalsIgnoreCase(serviceName)) {
		                return true;
		            }
		        }
		        return false;
		    }

		    public int getServicesCount() {
		        return serviceNames.size();
		    }
		}