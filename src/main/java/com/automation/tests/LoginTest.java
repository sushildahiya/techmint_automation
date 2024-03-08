package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.LoginPage;

public class LoginTest {
	LoginPage loginPage= new LoginPage();
	/**
	 * Script to Login with email
	 */
	@Test(priority = 0)
	public void loginWithEmail() {
		loginPage.openURL();
		loginPage.checkLoader();
		Assert.assertEquals(loginPage.checkSubmitButton(), false);	
		loginPage.sendEmailToInput();
		Assert.assertEquals(loginPage.checkSubmitButton(), true);
		loginPage.clickSubmitButton();
	}

}
