
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

public class Level9_Dynamic_Locator extends BaseTest{

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
	public void User_04_Dynamic_Locator() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLogInButton();
		
		homePage.OpenPagesAtHeaderArea(driver, "My account");
		customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		Assert.assertTrue(customerInfoPage.isCustomerInforPageDisplayed());
		
		customerInfoPage.OpenPagesAtMyAccountArea(driver, "Addresses");
		addressesPage = PageGeneratorManager.getUserAddressesPage(driver);
		Assert.assertTrue(addressesPage.isAddressesPageDisplayed());
		
		addressesPage.OpenPagesAtMyAccountArea(driver,"Orders");
		ordersPage = PageGeneratorManager.getUserOrderPage(driver);
		Assert.assertTrue(ordersPage.isOrdersPageDisplayed());
		
		ordersPage.OpenPagesAtMyAccountArea(driver, "Reward points");
		rewardPointsPage = PageGeneratorManager.getUserRewardPointsPage(driver);
		Assert.assertTrue(rewardPointsPage.isRewardPointsPageDisplayed());
		
		rewardPointsPage.OpenPagesAtMyAccountArea(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewsPage(driver);
		Assert.assertTrue(myProductReviewPage.isMyProductReviewsPageDisplayed());
		
		myProductReviewPage.OpenPagesAtMyAccountArea(driver, "Customer info");
		customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
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
