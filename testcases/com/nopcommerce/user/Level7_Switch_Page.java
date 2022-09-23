
package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.BasePage;
import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserAddressesPageObject;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewsPageObject;
import pageObjects.nopcommerce.user.UserOrdersPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserRewardPointsPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level7_Switch_Page extends BaseTest{

	@Parameters({"browser", "browserURL"})
	@BeforeClass
	public void beforeClass(String browserName, String browserURL) {
		System.out.println("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName, browserURL);

		firstName = "Automation";
		lastName = "FC";
		email = "Automation" + getRandomNumber() + "@hotmail.com";
		System.out.println("------------------ Email is: " + email);
		password = "123456";
	}
	
	@Test
	public void User_01_Register() {
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		System.out.println("User_01_Register - Step1: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();

		System.out.println("User_01_Register - Step2: Input to First Name textbox");
		registerPage.inputToFirstNameTextbox(firstName);
		System.out.println("User_01_Register - Step3: Input to Last Name textbox");
		registerPage.inputToLastNameTextbox(lastName);
		System.out.println("User_01_Register - Step4: Input to Email textbox");
		registerPage.inputToEmailTextbox(email);
		System.out.println("User_01_Register - Step5: Input to Password textbox");
		registerPage.inputToPasswordTextbox(password);
		System.out.println("User_01_Register - Step6: Input to Confirm Password textbox");
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		System.out.println("User_01_Register - Step7: Verify that register is completed successfully");
		Assert.assertEquals(registerPage.getRegisterCompleteMessage(), "Your registration completed");
		System.out.println("User_01_Register - Step8: Click to Logout Link");
		homePage = registerPage.logoutAsUser(driver);
	}
	
	@Test
	public void User_02_Login() {
		System.out.println("User_02_Login - Step1: Click to Login Link");
		loginPage = homePage.clickToLoginLink();
		System.out.println("User_02_Login - Step2: Input existing email to Email Textbox");
		loginPage.inputToEmailTextbox(email);
		System.out.println("User_02_Login - Step3: Input invalue to Password Textbox");
		loginPage.inputToPasswordTextbox(password);
		System.out.println("User_02_Login - Step4: Click to Login Button");
		homePage = loginPage.clickToLogInButton();
		System.out.println("User_02_Login - Step5: Verify Home Page displays");
		Assert.assertTrue(homePage.isHomePageDisplays());
	}
	
	@Test
	public void User_03_Customer_Info() {
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_04_Switch_Page() {
		addressesPage = customerInfoPage.openAddressesPage(driver);
		Assert.assertTrue(addressesPage.isAddressesPageDisplayed());
		ordersPage = addressesPage.openOrdersPage(driver);
		Assert.assertTrue(ordersPage.isOrdersPageDisplayed());
		
		rewardPointsPage = ordersPage.openRewardPointsPage(driver);
		Assert.assertTrue(rewardPointsPage.isRewardPointsPageDisplayed());
		
		myProductReviewPage = rewardPointsPage.openMyProductReviewsPage(driver);
		Assert.assertTrue(myProductReviewPage.isMyProductReviewsPageDisplayed());
		
		customerInfoPage = myProductReviewPage.openCustomerInfoPage(driver);
		Assert.assertTrue(customerInfoPage.isCustomerInforPageDisplayed());
	}
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	BasePage basePage;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	private String firstName, lastName, email, password;
	private UserRegisterPageObject registerPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressesPageObject addressesPage;
	private UserOrdersPageObject ordersPage;
	private UserRewardPointsPageObject rewardPointsPage;
	private UserMyProductReviewsPageObject myProductReviewPage;

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
