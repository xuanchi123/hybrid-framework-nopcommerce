
package com.grid.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.liveGuru.admin.AdminDashboardPageObject;
import pageObjects.liveGuru.admin.AdminLoginPageObject;
import pageObjects.liveGuru.admin.AdminPageGeneratorManager;
import pageObjects.liveGuru.user.UserHomePageObject;
import pageObjects.liveGuru.user.UserLoginPageObject;
import pageObjects.liveGuru.user.UserMyDashboardPageObject;
import pageObjects.liveGuru.user.UserPageGeneratorManager;
import pageObjects.liveGuru.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level10_LiveGuru_Admin_Grid extends BaseTest{

	@Parameters({"browser", "browserURL"})
	@BeforeClass
	public void beforeClass(String browserName, String browserURL) {
		System.out.println("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName, browserURL);
		firstName = "John";
		lastName = "Smith";
		emailAddress = "johnsmith" + getRandomNumber() + "@hotmail.com";
		password = "12345678";
		adminEmailAddress = "user01";
		adminPassword = "guru99com";
	}
	
	@Test
	public void Grid_01_New_Created_Account_Can_Be_Found_In_Admin_Site() {
		homePage = UserPageGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.clickToMyAccountLink();
		registerPage = loginPage.clickToCreateAnAccountButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailAddressTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		myDashboardPage = registerPage.clickToRegisterButton();
		homePage = myDashboardPage.clickLogOutOfLiveGuru(driver);
		
		homePage.openPageURL(driver, GlobalConstants.LIVE_GURU_ADMIN_URL);
		adminLoginPage = AdminPageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.loginToAdminPage(adminEmailAddress, adminPassword);
		adminDashboardPage.closeIncomingMessagePopup();
		adminDashboardPage.searchCustomerByNameAndEmail(firstName + " " + lastName, emailAddress);
		Assert.assertTrue(adminDashboardPage.isAllCustomerRowsPresentWithNameAndEmail(firstName + " " + lastName, emailAddress));
	}
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserMyDashboardPageObject myDashboardPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
	String firstName, lastName, emailAddress, password, adminEmailAddress, adminPassword;
	

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
