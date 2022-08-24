
package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.BasePage;
import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level6_Page_Generator_Manager_III extends BaseTest{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	BasePage basePage;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	private String firstName, lastName, notExistEmail, invalidEmail, existEmail, invalidPassword, validPassword;
	private UserRegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName);
		
		firstName = "Automation";
		lastName = "FC";
		existEmail = "Automation" + getRandomNumber() + "@hotmail.com";
		notExistEmail = "Automation" + getRandomNumber() + "@hotmail.vn";
		invalidEmail = "Automation@aaa@aaa";
		validPassword = "123456";
		invalidPassword = "654321";
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		System.out.println("Precondition_01 - Step1: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();

		System.out.println("Precondition_01 - Step2: Input to First Name textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		System.out.println("Precondition_01 - Step3: Input to Last Name textbox");
		registerPage.inputToLastNameTextbox(lastName);
		System.out.println("Precondition_01 - Step4: Input to Email textbox");
		registerPage.inputToEmailTextbox(existEmail);
		System.out.println("Precondition_01 - Step5: Input to Password textbox");
		registerPage.inputToPasswordTextbox(validPassword);
		System.out.println("Precondition_01 - Step6: Input to Confirm Password textbox");
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		System.out.println("Precondition_01 - Step7: Verify that register is completed successfully");
		Assert.assertEquals(registerPage.getRegisterCompleteMessage(), "Your registration completed");
		System.out.println("Precondition_01 - Step8: Click to Logout Link");
		homePage = registerPage.logoutAsUser(driver);
	}
	
	@Test
	public void Login_01_EmptyData() {
		System.out.println("Login_01 - Step1: Click to Login Link");
		loginPage = homePage.clickToLoginLink();
		System.out.println("Login_01 - Step2: Click to Login Button");
		loginPage.clickToLogInButton();
		System.out.println("Login_01 - Step3: Verify Error message displays");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login_02 - Step1: Click to Login Link");
		loginPage = homePage.clickToLoginLink();
		System.out.println("Login_02 - Step2: Input invalid value to Email Textbox");
		loginPage.inputToEmailTextbox(invalidEmail);
		System.out.println("Login_02 - Step3: Input value to Password Textbox");
		loginPage.inputToPasswordTextbox(validPassword);
		System.out.println("Login_02 - Step4: Click to Login Button");
		loginPage.clickToLogInButton();
		System.out.println("Login_02 - Step5: Verify Error message displays");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}
	
	@Test
	public void Login_03_Not_Registered_Email() {
		System.out.println("Login_03 - Step1: Click to Login Link");
		loginPage = homePage.clickToLoginLink();
		System.out.println("Login_03 - Step2: Input not existing email to Email Textbox");
		loginPage.inputToEmailTextbox(notExistEmail);
		System.out.println("Login_03 - Step3: Input value to Password Textbox");
		loginPage.inputToPasswordTextbox(validPassword);
		System.out.println("Login_03 - Step4: Click to Login Button");
		loginPage.clickToLogInButton();
		System.out.println("Login_03 - Step5: Verify Error message displays");
		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Test
	public void Login_04_Registered_Email_No_Password() {
		System.out.println("Login_04 - Step1: Click to Login Link");
		loginPage = homePage.clickToLoginLink();
		System.out.println("Login_04 - Step2: Input existing email to Email Textbox");
		loginPage.inputToEmailTextbox(existEmail);
		System.out.println("Login_04 - Step3: Click to Login Button");
		loginPage.clickToLogInButton();
		System.out.println("Login_04 - Step4: Verify Error message displays");
		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_05_Registered_Email_Incorrect_Password() {
		System.out.println("Login_05 - Step1: Click to Login Link");
		loginPage = homePage.clickToLoginLink();
		System.out.println("Login_05 - Step2: Input existing email to Email Textbox");
		loginPage.inputToEmailTextbox(existEmail);
		System.out.println("Login_05 - Step3: Input invalue to Password Textbox");
		loginPage.inputToPasswordTextbox(invalidPassword);
		System.out.println("Login_05 - Step4: Click to Login Button");
		loginPage.clickToLogInButton();
		System.out.println("Login_05 - Step5: Verify Error message displays");
		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Login_Success() {
		System.out.println("Login_06 - Step1: Click to Login Link");
		loginPage = homePage.clickToLoginLink();
		System.out.println("Login_06 - Step2: Input existing email to Email Textbox");
		loginPage.inputToEmailTextbox(existEmail);
		System.out.println("Login_06 - Step3: Input invalue to Password Textbox");
		loginPage.inputToPasswordTextbox(validPassword);
		System.out.println("Login_06 - Step4: Click to Login Button");
		homePage = loginPage.clickToLogInButton();
		System.out.println("Login_06 - Step5: Verify Home Page displays");
		Assert.assertTrue(homePage.isHomePageDisplays());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
