package com.nopcommerce.user;

import org.testng.annotations.Test;

import common.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level2_User_01_Register2 extends BasePage{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String email;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "//browserDriver//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
		email = "John" + getRandomNumber() + "@hotmail.com";
		System.out.println("Email is: " + email);
		
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_EmptyData() {
		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
	}
	
	@Test
	public void TC_02_Register_Invalid_Email() {
		clickToElement(driver, "//a[@class='ico-register']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		sendKeyToElement(driver, "//input[@id='Email']", "Automation");
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
			
	}
	
	@Test
	public void TC_03_Register_Success() {
		
		clickToElement(driver, "//a[@class='ico-register']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Password']", "123456");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
		clickToElement(driver, "//a[@class='ico-logout']");
	}
	
	@Test
	public void TC_04_Register_Existing_Email() {
		
		clickToElement(driver, "//a[@class='ico-register']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Password']", "123456");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
	}
	
	@Test
	public void TC_05_Register_Wrong_Password() {
		clickToElement(driver, "//a[@class='ico-register']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Password']", "123");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
	}
	
	@Test
	public void TC_06_Register_Wrong_Confirmation_Password() {
		clickToElement(driver, "//a[@class='ico-register']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Password']", "123456");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "456");
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
	}

	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(99999);
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
