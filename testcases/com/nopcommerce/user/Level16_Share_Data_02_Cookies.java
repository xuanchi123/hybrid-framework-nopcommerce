
package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookies;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level16_Share_Data_02_Cookies extends BaseTest {

	@Parameters({ "browser", "browserURL" })
	@BeforeClass
	public void beforeClass(String browserName, String browserURL) {
		log.info("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName, browserURL);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - Step 01: Click to 'Login' Link");
		loginPage = homePage.clickToLoginLink();

		Set<Cookie> loginCookies = Common_01_Register_Cookies.loginCookies;

		homePage.setAllCookies(driver, loginCookies);
		homePage.sleepInSecond(3);

		homePage.refreshCurrentPage(driver);
	}

	@Test
	public void Search_01_NoMatchedItem() {
		homePage.sleepInSecond(1);
	}

	@Test
	public void Search_02_MatchItem() {
		homePage.sleepInSecond(1);
	}

	@Test
	public void Search_03_AdvanceSearch() {
		homePage.sleepInSecond(1);
	}

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	BasePage basePage;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;

	@AfterClass 
	public void afterClass() { 
//		 driver.quit(); 
	}
}
