
package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

import pageObjects.nopcommerce.user.UserRegisterPageObject;

import reportConfig.ExtentTestManagerV5;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level15_Extent_ReportV5 extends BaseTest{

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
	public void User_01_Register(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "TC_01_Register");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'User Home' page");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 02: Click to 'Register' Link");
		registerPage = homePage.clickToRegisterLink();

		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 03: Input to 'First Name' textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 04: Input to 'Last Name' textbox");
		registerPage.inputToLastNameTextbox(lastName);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 05: Input to 'Email' textbox");
		registerPage.inputToEmailTextbox(email);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 06: Input to 'Password' textbox");
		registerPage.inputToPasswordTextbox(password);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 07: Input to 'Confirm Password' textbox");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 08: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 09: Verify register completed message displays");
		Assert.assertEquals(registerPage.getRegisterCompleteMessage(), "Your registration completed - wrong message");
	}
	
	@Test
	public void User_02_Login(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "TC_02_Login");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 01: Click to 'Logout' Link");
		homePage = registerPage.logoutAsUser(driver);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 02: Click to 'Login' Link");
		loginPage = homePage.clickToLoginLink();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 03: Input existing email to 'Email' Textbox");
		loginPage.inputToEmailTextbox(email);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 04: Input value to 'Password' Textbox");
		loginPage.inputToPasswordTextbox(password);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 05: Click to 'Login' Button");
		homePage = loginPage.clickToLogInButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 06: Verify 'Home Page' displays");		
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
