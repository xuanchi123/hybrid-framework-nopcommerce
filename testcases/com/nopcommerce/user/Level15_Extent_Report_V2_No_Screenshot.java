
package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

import pageObjects.nopcommerce.user.UserRegisterPageObject;


import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level15_Extent_Report_V2_No_Screenshot extends BaseTest{

	@Parameters({"browser", "browserURL"})
	@BeforeClass
	public void beforeClass(String browserName, String browserURL) {
		log.info("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName, browserURL);

		firstName = "Automation";
		lastName = "FC";
		email = "Automation" + getRandomNumber() + "@hotmail.com";
		log.info("------------------ Email is: " + email);
		password = "123456";
	}
	
	@Test
	public void User_01_Register() {
		
		log.info("Register - Step 01: Navigate to 'User Home' page");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Register - Step 02: Click to 'Register' Link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 03: Input to 'First Name' textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("Register - Step 04: Input to 'Last Name' textbox");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Register - Step 05: Input to 'Email' textbox");
		registerPage.inputToEmailTextbox(email);
		
		log.info("Register - Step 06: Input to 'Password' textbox");
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Register - Step 07: Input to 'Confirm Password' textbox");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register - Step 08: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 09: Verify register completed message displays");
		Assert.assertEquals(registerPage.getRegisterCompleteMessage(), "Your registration completed - wrong message");
		
		log.info("Register - Step 10: Click to 'Logout' Link");
		homePage = registerPage.logoutAsUser(driver);
	}
	
	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Click to 'Login' Link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Input existing email to 'Email' Textbox");
		loginPage.inputToEmailTextbox(email);
		
		log.info("Login - Step 03: Input value to 'Password' Textbox");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 04: Click to 'Login' Button");
		homePage = loginPage.clickToLogInButton();
		
		log.info("Login - Step 05: Verify 'Home Page' displays");		
		Assert.assertTrue(homePage.isHomePageDisplays());
	}
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	BasePage basePage;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	private String firstName, lastName, email, password;
	private UserRegisterPageObject registerPage;

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
