
package com.facebook.register;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

import pageObjects.nopcommerce.user.UserRegisterPageObject;


import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;

//@Listeners(commons.MethodListener.class)
public class Level13_Element_Undisplayed extends BaseTest{

	@Parameters({"browser", "browserURL"})
	@BeforeClass
	public void beforeClass(String browserName, String browserURL) {
		System.out.println("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName, browserURL);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		email = "automation@gmail.com";
	}
	
	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
	}
	
	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		verifyTrue(loginPage.isEmailConfirmationTextboxUndisplayed());
		loginPage.enterToEmailTextbox(email);
		loginPage.sleepInSecond(3);
		verifyFalse(loginPage.isEmailConfirmationTextboxUndisplayed());
	}
	
	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.closeSignupPopup();
		loginPage.sleepInSecond(1);
		verifyTrue(loginPage.isEmailConfirmationTextboxUndisplayed());
	}
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	LoginPageObject loginPage;
	String email;

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
