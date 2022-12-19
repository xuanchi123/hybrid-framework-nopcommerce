  
package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

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

public class Level16_Share_Data extends BaseTest{

	@Parameters({"browser", "browserURL"})
	@BeforeClass
	public void beforeClass(String browserName, String browserURL) {
		log.info("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName, browserURL);
 
		email = Common_01_Register.email;
		password = Common_01_Register.password;
		
		log.info("Login - Step 01: Click to 'Login' Link");
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
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
		driver.quit();
	}
}
