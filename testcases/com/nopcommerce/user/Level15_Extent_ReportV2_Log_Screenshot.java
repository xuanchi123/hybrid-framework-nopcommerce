
package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

import pageObjects.nopcommerce.user.UserRegisterPageObject;
import reportConfig.ExtentManager;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level15_Extent_ReportV2_Log_Screenshot extends BaseTest{

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
		ExtentManager.startTest(method.getName(), "TC_01_NewCustomer");
		
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to 'User Home' page");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Click to 'Register' Link");
		registerPage = homePage.clickToRegisterLink();

		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Input to 'First Name' textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Input to 'Last Name' textbox");
		registerPage.inputToLastNameTextbox(lastName);
		
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Input to 'Email' textbox");
		registerPage.inputToEmailTextbox(email);
		
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Input to 'Password' textbox");
		registerPage.inputToPasswordTextbox(password);
		
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Input to 'Confirm Password' textbox");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 09: Verify register completed message displays");
		Assert.assertEquals(registerPage.getRegisterCompleteMessage(), "Your registration completed - wrong message");
		
		ExtentManager.endTest();
	}
	
	@Test
	public void User_02_Login(Method method) {
		ExtentManager.startTest(method.getName(), "TC_01_NewCustomer");
		
		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 01: Click to 'Logout' Link");
		homePage = registerPage.logoutAsUser(driver);
		
		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Click to 'Login' Link");
		loginPage = homePage.clickToLoginLink();
		
		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 03: Input existing email to 'Email' Textbox");
		loginPage.inputToEmailTextbox(email);
		
		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 04: Input value to 'Password' Textbox");
		loginPage.inputToPasswordTextbox(password);
		
		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: Click to 'Login' Button");
		homePage = loginPage.clickToLogInButton();
		
		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 06: Verify 'Home Page' displays");		
		Assert.assertTrue(homePage.isHomePageDisplays());
		
		ExtentManager.endTest();
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
