
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

import org.testng.annotations.AfterClass;

//@Listeners(commons.MethodListener.class)
public class Level12_Assert_Verify extends BaseTest{

	@Parameters({"browser", "browserURL"})
	@BeforeClass
	public void beforeClass(String browserName, String browserURL) {
		System.out.println("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName, browserURL);

		firstName = "Automation";
		lastName = "FC";
		email = "Automation" + getRandomNumber() + "@hotmail.com";
		System.out.println("------------------ Email is: " + email);
		password = "123456";
	}
	
	@Test
	public void User_01_Register() {
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		System.out.println("User_01_Register - Step1: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();

		System.out.println("User_01_Register - Step2: Input to First Name textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		System.out.println("User_01_Register - Step3: Input to Last Name textbox");
		registerPage.inputToLastNameTextbox(lastName);
		System.out.println("User_01_Register - Step4: Input to Email textbox");
		registerPage.inputToEmailTextbox(email);
		System.out.println("User_01_Register - Step5: Input to Password textbox");
		registerPage.inputToPasswordTextbox(password);
		System.out.println("User_01_Register - Step6: Input to Confirm Password textbox");
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		System.out.println("User_01_Register - Step7: Verify that register is completed successfully");
		
		verifyEquals(registerPage.getRegisterCompleteMessage(), "Your registration completed - wrong message");
		System.out.println("User_01_Register - Step8: Click to Logout Link");
		homePage = registerPage.logoutAsUser(driver);

		System.out.println("User_01_Login - Step1: Click to Login Link");
		loginPage = homePage.clickToLoginLink();
		System.out.println("User_01_Login - Step2: Input existing email to Email Textbox");
		loginPage.inputToEmailTextbox(email);
		System.out.println("User_01_Login - Step3: Input invalue to Password Textbox");
		loginPage.inputToPasswordTextbox(password);
		System.out.println("User_01_Login - Step4: Click to Login Button");
		homePage = loginPage.clickToLogInButton();
		System.out.println("User_01_Login - Step5: Verify Home Page displays");
		
		verifyTrue(homePage.isHomePageDisplays());
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
