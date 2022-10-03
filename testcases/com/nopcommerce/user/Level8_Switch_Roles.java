
package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.UserAddressesPageObject;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level8_Switch_Roles extends BaseTest{

	@Parameters({"browser", "browserURL"})
	@BeforeClass
	public void beforeClass(String browserName, String browserURL) {
		System.out.println("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName, browserURL);

		userFirstName = "Automation";
		userLastName = "FC";
		userEmail = "Automation" + getRandomNumber() + "@hotmail.com";
		System.out.println("------------------ Email is: " + userEmail);
		userPassword = "123456";
		
		adminEmail = "admin@yourstore.com";
		adminPassword = "admin";
		
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		System.out.println("User_01_Register - Step1: Click to Register Link");
		userRegisterPage = userHomePage.clickToRegisterLink();

		System.out.println("Precondition_01_Register - Step2: Input to First Name textbox");
		userRegisterPage.inputToFirstNameTextbox(userFirstName);
		System.out.println("Precondition_01_Register - Step3: Input to Last Name textbox");
		userRegisterPage.inputToLastNameTextbox(userLastName);
		System.out.println("Precondition_01_Register - Step4: Input to Email textbox");
		userRegisterPage.inputToEmailTextbox(userEmail);
		System.out.println("Precondition_01_Register - Step5: Input to Password textbox");
		userRegisterPage.inputToPasswordTextbox(userPassword);
		System.out.println("Precondition_01_Register - Step6: Input to Confirm Password textbox");
		userRegisterPage.inputToConfirmPasswordTextbox(userPassword);
		userRegisterPage.clickToRegisterButton();
		System.out.println("Precondition_01_Register - Step7: Verify that register is completed successfully");
		Assert.assertEquals(userRegisterPage.getRegisterCompleteMessage(), "Your registration completed");
		System.out.println("Precondition_01_Register - Step8: Click to Logout Link");
		userHomePage = userRegisterPage.logoutAsUser(driver);	
	}
	
	@Test
	public void Role_01_Portal_To_Admin_Page() {		
		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);
		userCustomerInfoPage = userHomePage.clickToMyAccountLink();
		userAddressesPage = userCustomerInfoPage.openAddressesPage(driver);
		Assert.assertTrue(userAddressesPage.isAddressesPageDisplayed());
		
		userHomePage = userRegisterPage.logoutAsUser(driver);
		
		userHomePage.openPageURL(driver, GlobalConstants.NOPCOMMERCE_ADMIN_DEV_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardPageDisplays());
		adminLoginPage = adminDashboardPage.logOutAsAdmin(driver);
	}
	
	@Test
	public void Role_02_Admin_To_Portal_Page() {
		adminLoginPage.openPageURL(driver, GlobalConstants.NOPCOMMERCE_PORTAL_DEV_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);
		userHomePage.logoutAsUser(driver);
	}
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	BasePage basePage;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	private String userFirstName, userLastName, userEmail, userPassword, adminEmail, adminPassword;
	private UserRegisterPageObject userRegisterPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private UserAddressesPageObject userAddressesPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
