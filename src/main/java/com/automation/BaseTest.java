package com.automation;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class BaseTest 
{
	protected AppiumDriver driver;
	/**
	 * Method to be invoked to initialize the appium driver before any classes
	 * @throws MalformedURLException
	 */
    @SuppressWarnings("deprecation")
	@BeforeMethod
    public void setUp() throws MalformedURLException {
    	// Capabilties defined for the system on which scripts to be run
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "12.0.0");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    /**
     * Method to be invoke to destroy the android driver instance
     */
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    /**
     * Getter method to return the driver which has protected access modifier
     * @return
     */
    public AppiumDriver getDriver() {
    	return this.driver;
    }
}
