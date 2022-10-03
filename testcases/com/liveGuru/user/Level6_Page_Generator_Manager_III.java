
package com.liveGuru.user;

import org.testng.annotations.Test;

import commons.BaseTest;
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

public class Level6_Page_Generator_Manager_III extends BaseTest{

	@Parameters({"browser", "browserURL"})
	@BeforeClass
	public void beforeClass(String browserName, String browserURL) {
		System.out.println("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName, browserURL);
		
		firstName = "Automation";
		lastName = "FC";
		emailAddress = "automation" + getRandomNumber() + "@hotmail.com"; 
		password = "123456";
		System.out.println("--------------------------Email is: " + emailAddress);
		
		homePage = UserPageGeneratorManager.getHomePage(driver);
	}
	
	@Test
	public void User_01_Register_New_User() {
		loginPage = homePage.clickToMyAccountLink();
		
		registerPage = loginPage.clickToCreateAnAccountButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailAddressTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		myDashboardPage = registerPage.clickToRegisterButton();
		Assert.assertEquals(myDashboardPage.getHelloText(), "Hello, " + firstName + " " + lastName + "!");
		homePage = myDashboardPage.clickLogOutOfLiveGuru(driver);
	}
	
	@Test
	public void User_02_Login() {
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputToEmailAddressTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		myDashboardPage = loginPage.clickToLoginButton();		
		Assert.assertEquals(myDashboardPage.getHelloText(), "Hello, " + firstName + " " + lastName + "!"); 
	}
	
	WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserMyDashboardPageObject myDashboardPage;
	private String firstName, lastName, emailAddress, password;
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
