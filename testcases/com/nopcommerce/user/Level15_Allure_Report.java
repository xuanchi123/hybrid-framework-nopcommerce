
package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

import pageObjects.nopcommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level15_Allure_Report extends BaseTest{

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
	
	@Description("User 01 - Register to System")
	@Epic("User")
	@Story("Register")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register(Method method) {
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		
		registerPage.inputToLastNameTextbox(lastName);
		
		registerPage.inputToEmailTextbox(email);
		
		registerPage.inputToPasswordTextbox(password);
		
		registerPage.inputToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterCompleteMessage(), "Your registration completed - wrong message");
	}
	
	@Description("User 01 - Login to System")
	@Epic("User")
	@Story("Login")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_02_Login(Method method) {
		
		homePage = registerPage.logoutAsUser(driver);
		
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(email);
		
		loginPage.inputToPasswordTextbox(password);
		
		homePage = loginPage.clickToLogInButton();
		
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
