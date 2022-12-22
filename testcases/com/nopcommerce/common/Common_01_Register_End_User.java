  
package com.nopcommerce.common;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

import pageObjects.nopcommerce.user.UserRegisterPageObject;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Common_01_Register_End_User extends BaseTest{

	@Parameters({"browser", "browserURL"})
	@BeforeTest (description = "Create new user for all Classes")
	public void beforeClass(String browserName, String browserURL) {
		log.info("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName, browserURL);
 
		firstName = "Automation";
		lastName = "FC";
		email = "Automation" + getRandomNumber() + "@hotmail.com";
		log.info("------------------ Email is: " + email);
		password = "123456";
		
		log.info("Precondition - Register - Step 01: Navigate to 'User Home' page");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Precondition - Register - Step 02: Click to 'Register' Link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Precondition - Register - Step 03: Input to 'First Name' textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("Precondition - Register - Step 04: Input to 'Last Name' textbox");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Precondition - Register - Step 05: Input to 'Email' textbox");
		registerPage.inputToEmailTextbox(email);
		
		log.info("Precondition - Register - Step 06: Input to 'Password' textbox");
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Precondition - Register - Step 07: Input to 'Confirm Password' textbox");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Precondition - Register - Step 08: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Precondition - Register - Step 09: Verify register completed message displays");
		Assert.assertEquals(registerPage.getRegisterCompleteMessage(), "Your registration completed");
		
		driver.quit();
	}
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	BasePage basePage;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	private String firstName, lastName;
	public static String email, password;
	private UserRegisterPageObject registerPage;
}
