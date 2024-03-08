package com.automation.pages;
import com.automation.BaseTest;
import com.automation.resources.Constants;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * Defines the web element or mobile element and also defines the action that can be performed on the elements
 */
public class LoginPage {
	
	    AppiumDriver driver = new BaseTest().getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    @AndroidFindBy(className="loader")
	    @iOSXCUITFindBy(className="loader")
	    WebElement loader;
	    @AndroidFindBy(id="user-input")
	    @iOSXCUITFindBy(id="user-input")
	    WebElement mobileNoEmailField;
	    @AndroidFindBy(xpath="//input[@type='submit']")
	    @AndroidFindBy(xpath="//input[@type='submit']")
	    WebElement submitButton;
	    @AndroidFindBy(xpath="//div[@role='button']")
	    @iOSXCUITFindBy(xpath="//div[@role='button']")
	    WebElement continueGoogleBtn;
	    
	    /**
	     * Open url
	     */
	    public void openURL() {
	    	driver.get(Constants.URL);
	    }
	    
	    /**
	     * Check the presenece of the loader on the screen
	     */
	    public void checkLoader() {
	        wait.until(ExpectedConditions.visibilityOf(loader));
	    }
	    
	    /**
	     * Check the presence of input box
	     */
	    public void checkInputBox() {
	    	wait.until(ExpectedConditions.visibilityOf(mobileNoEmailField));
	    }
	
	    /**
	     * Provide the email address to input box
	     */
	    public void sendEmailToInput() {
	    	checkInputBox();
	    	mobileNoEmailField.click();
	    	mobileNoEmailField.sendKeys(Constants.LOGIN_EMAIL);
	    }
	    
	    public boolean checkSubmitButton() {
	    	return submitButton.isEnabled();
	    }
	    
	    public void clickSubmitButton() {
	    	submitButton.click();
	    }

	


}
