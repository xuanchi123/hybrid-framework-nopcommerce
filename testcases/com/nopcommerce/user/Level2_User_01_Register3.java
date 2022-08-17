//package com.nopcommerce.user;
//
//import org.testng.annotations.Test;
//
//import common.BasePage;
//
//import org.testng.annotations.BeforeClass;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//
//public class Level2_User_01_Register3 {
//	WebDriver driver;
//	String projectPath = System.getProperty("user.dir");
//	String email;
//	BasePage basePage;
//
//	@BeforeClass
//	public void beforeClass() {
//		System.setProperty("webdriver.gecko.driver", projectPath + "//browserDriver//geckodriver.exe");
//		driver = new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().fullscreen();
//		
//		email = "Automation" + getRandomNumber() + "@hotmail.com";
//		
//		driver.get("https://demo.nopcommerce.com/");
//		basePage = BasePage.getBasePage();
//		
//	}
//
//	@Test
//	public void TC_01_Register_EmptyData() {
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
//	}
//	
//	@Test
//	public void TC_02_Register_Invalid_Email() {
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
//		basePage.sendKeyToElement(driver, "//input[@id='Email']", "Automation");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
//			
//	}
//	
//	@Test
//	public void TC_03_Register_Success() {
//		
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
//		basePage.sendKeyToElement(driver, "//input[@id='Email']", email);
//		basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
//		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		
//		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
//		
//		basePage.clickToElement(driver, "//a[@class='ico-logout']");
//	}
//	
//	@Test
//	public void TC_04_Register_Existing_Email() {
//		
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
//		basePage.sendKeyToElement(driver, "//input[@id='Email']", email);
//		basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
//		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		
//		Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
//	}
//	
//	@Test
//	public void TC_05_Register_Wrong_Password() {
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
//		basePage.sendKeyToElement(driver, "//input[@id='Email']", email);
//		basePage.sendKeyToElement(driver, "//input[@id='Password']", "123");
//		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
//	}
//	
//	@Test
//	public void TC_06_Register_Wrong_Confirmation_Password() {
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.sendKeyToElement(driver, "//input[@id='LastName']", "FC");
//		basePage.sendKeyToElement(driver, "//input[@id='Email']", email);
//		basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
//		basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "456");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
//	}
//
//	public int getRandomNumber() {
//		Random random = new Random();
//		return random.nextInt(99999);
//		
//	}
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//
//}
