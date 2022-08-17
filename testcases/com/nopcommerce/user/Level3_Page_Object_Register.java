
package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.BasePage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level3_Page_Object_Register {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String email;
	BasePage basePage;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	private String firstName;
	private String lastName;
	private String password;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "//browserDriver//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
		email = "Automation" + getRandomNumber() + "@hotmail.com";
		
		driver.get("https://demo.nopcommerce.com/");
		
		homePage = new HomePageObject(driver);
		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);
		
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
	}

	@Test
	public void Register_01_EmptyData() {
		System.out.println("REGISTER_01 - Step1: Click to Register Link");
		homePage.clickToRegisterLink();
		System.out.println("REGISTER_01 - Step2: Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("REGISTER_01 - Step3: Verify Firstname error message");
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		System.out.println("REGISTER_01 - Step4: Verify FirstnLast nameame error message");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		System.out.println("REGISTER_01 - Step5: Verify FirEmailstname error message");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		System.out.println("REGISTER_01 - Step6: Verify Password error message");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		System.out.println("REGISTER_01 - Step7: Verify Confirmation Password error message");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}
	
	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("REGISTER_02 - Step1: Click to Register Link");
		homePage.clickToRegisterLink();
		System.out.println("REGISTER_02 - Step2: Input to First Name textbox");
		registerPage.inputFirstNameTextbox(firstName);
		System.out.println("REGISTER_02 - Step3: Input to Last Name textbox");
		registerPage.inputLastNameTextbox(lastName);
		System.out.println("REGISTER_02 - Step4: Input to Email textbox");
		registerPage.inputEmailTextbox(lastName);
		System.out.println("REGISTER_02 - Step5: Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("REGISTER_02 - Step6: Verify wrong Email error message");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");			
	}
	
	@Test
	public void Register_03_Success() {
		System.out.println("REGISTER_03 - Step1: Click to Register Link");
		homePage.clickToRegisterLink();
		System.out.println("REGISTER_03 - Step2: Input to First Name textbox");
		registerPage.inputFirstNameTextbox(firstName);
		System.out.println("REGISTER_03 - Step3: Input to Last Name textbox");
		registerPage.inputLastNameTextbox(lastName);
		System.out.println("REGISTER_03 - Step4: Input to Email textbox");
		registerPage.inputEmailTextbox(email);
		System.out.println("REGISTER_03 - Step5: Input to Password textbox");
		registerPage.inputPasswordTextbox(password);
		System.out.println("REGISTER_03 - Step6: Input to Password textbox");
		registerPage.inputConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		System.out.println("REGISTER_03 - Step7: Verify that register is completed successfully");
		Assert.assertEquals(registerPage.getRegisterCompleteMessage(), "Your registration completed");
		System.out.println("REGISTER_03 - Step8: Click to Logout Link");
		registerPage.clickToLogoutLink();
	}
	
	@Test
	public void Register_04_Existing_Email() {
		System.out.println("REGISTER_04 - Step1: Click to Register Link");
		homePage.clickToRegisterLink();
		System.out.println("REGISTER_04 - Step2: Input to First Name textbox");
		registerPage.inputFirstNameTextbox(firstName);
		System.out.println("REGISTER_04 - Step3: Input to Last Name textbox");
		registerPage.inputLastNameTextbox(lastName);
		System.out.println("REGISTER_04 - Step4: Input to Email textbox");
		registerPage.inputEmailTextbox(email);
		System.out.println("REGISTER_04 - Step5: Input to Password textbox");
		registerPage.inputPasswordTextbox(password);
		System.out.println("REGISTER_04 - Step6: Input to Confirm Password textbox");
		registerPage.inputConfirmPasswordTextbox(password);
		System.out.println("REGISTER_04 - Step7: Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("REGISTER_04 - Step8: Verify email existing error message");
		Assert.assertEquals(registerPage.getRegisterDuplicatedErrorMessage(), "The specified email already exists");
	}
	
	@Test
	public void Register_05_Wrong_Password() {
		System.out.println("REGISTER_05 - Step1: Click to Register Link");
		homePage.clickToRegisterLink();
		System.out.println("REGISTER_05 - Step2: Input to First Name textbox");
		registerPage.inputFirstNameTextbox(firstName);
		System.out.println("REGISTER_05 - Step3: Input to Last Name textbox");
		registerPage.inputLastNameTextbox(lastName);
		System.out.println("REGISTER_05 - Step4: Input to Email textbox");
		registerPage.inputEmailTextbox(email);
		System.out.println("REGISTER_05 - Step6: Input to Password textbox");
		registerPage.inputPasswordTextbox("123");
		System.out.println("REGISTER_05 - Step7: Input to Confirm Password textbox");
		registerPage.inputConfirmPasswordTextbox(password);
		System.out.println("REGISTER_05 - Step8: Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("REGISTER_05 - Step9: Verify Password error message");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");
	}
	
	@Test
	public void Register_06_Wrong_Confirmation_Password() {
		System.out.println("REGISTER_06 - Step1: Click to Register Link");
		homePage.clickToRegisterLink();
		System.out.println("REGISTER_06 - Step2: Input to First Name textbox");
		registerPage.inputFirstNameTextbox(firstName);
		System.out.println("REGISTER_06 - Step3: Input to Last Name textbox");
		registerPage.inputLastNameTextbox(lastName);
		System.out.println("REGISTER_06 - Step4: Input to Email textbox");
		registerPage.inputEmailTextbox(email);
		System.out.println("REGISTER_06 - Step5: Input to Password textbox");
		registerPage.inputPasswordTextbox(password);
		System.out.println("REGISTER_06 - Step6: Input to Confirm Password textbox");
		registerPage.inputConfirmPasswordTextbox(lastName);
		System.out.println("REGISTER_06 - Step7: Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("REGISTER_06 - Step8: Verify Confirmation Password error message");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	}

	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(99999);
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
