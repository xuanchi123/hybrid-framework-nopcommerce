
package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.BasePage;
import common.BaseTest;
import pageObjects.nopcommerce.AddressesPageObject;
import pageObjects.nopcommerce.CustomerInfoPageObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.MyProductReviewsPageObject;
import pageObjects.nopcommerce.OrdersPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;
import pageObjects.nopcommerce.RewardPointsPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level7_Switch_Page extends BaseTest{

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName);

		firstName = "Automation";
		lastName = "FC";
		email = "Automation" + getRandomNumber() + "@hotmail.com";
		System.out.println("------------------ Email is: " + email);
		password = "123456";
	}
	
	@Test
	public void User_01_Register() {
		homePage = PageGeneratorManager.getHomePage(driver);
		
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
		homePage = registerPage.clickToLogoutLink();
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
	HomePageObject homePage;
	LoginPageObject loginPage;
	private String firstName, lastName, email, password;
	private RegisterPageObject registerPage;
	private CustomerInfoPageObject customerInfoPage;
	private AddressesPageObject addressesPage;
	private OrdersPageObject ordersPage;
	private RewardPointsPageObject rewardPointsPage;
	private MyProductReviewsPageObject myProductReviewPage;

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
