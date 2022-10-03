
package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level4_Page_Object_Browser extends BaseTest{
	WebDriver driver;
	String email;
	BasePage basePage;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	private String firstName;
	private String lastName;

	@Parameters({"browser", "browserURL"})
	@BeforeClass
	public void beforeClass(String browserName, String browserURL) {
		System.out.println("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName, browserURL);
		email = "Automation" + getRandomNumber() + "@hotmail.com";
		System.out.println(email);		
		homePage = new UserHomePageObject(driver);
		loginPage = new UserLoginPageObject(driver);
		registerPage = new UserRegisterPageObject(driver);
		firstName = "Automation";
		lastName = "FC";
	}

	@Test
	public void Register_01_EmptyData() {
		System.out.println("REGISTER_01 - Step1: Click to Register Link");
		homePage.clickToRegisterLink();
		System.out.println("REGISTER_01 - Step2: Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("REGISTER_01 - Step3: Verify Firstname error message");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");
		System.out.println("REGISTER_01 - Step4: Verify FirstnLast nameame error message");
		Assert.assertEquals(registerPage.getErrorMesssageAtLastNameTextbox(), "Last name is required.");
		System.out.println("REGISTER_01 - Step5: Verify FirEmailstname error message");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		System.out.println("REGISTER_01 - Step6: Verify Password error message");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		System.out.println("REGISTER_01 - Step7: Verify Confirmation Password error message");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}
	
	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("REGISTER_02 - Step1: Click to Register Link");
		homePage.clickToRegisterLink();
		System.out.println("REGISTER_02 - Step2: Input to First Name textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		System.out.println("REGISTER_02 - Step3: Input to Last Name textbox");
		registerPage.inputToLastNameTextbox(lastName);
		System.out.println("REGISTER_02 - Step4: Input to Email textbox");
		registerPage.inputToEmailTextbox(lastName);
		System.out.println("REGISTER_02 - Step5: Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("REGISTER_02 - Step6: Verify wrong Email error message");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");			
	}

	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
