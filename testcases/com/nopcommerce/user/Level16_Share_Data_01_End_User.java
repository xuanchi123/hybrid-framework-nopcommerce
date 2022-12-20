  
package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level16_Share_Data_01_End_User extends BaseTest{

	@Parameters({"browser", "browserURL"})
	@BeforeClass
	public void beforeClass(String browserName, String browserURL) {
		log.info("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName, browserURL);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		email = Common_01_Register_End_User.email;
		password = Common_01_Register_End_User.password;
		
		log.info("Login - Step 01: Click to 'Login' Link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Input existing email to 'Email' Textbox");
		loginPage.inputToEmailTextbox(email);
		
		log.info("Login - Step 03: Input value to 'Password' Textbox");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 04: Click to 'Login' Button");
		homePage = loginPage.clickToLogInButton();
	}
	
	@Test
	public void Search_01_InvalidItem() {

	}
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	BasePage basePage;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	private String email, password;

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
