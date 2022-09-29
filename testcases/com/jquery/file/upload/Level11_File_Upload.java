
package com.jquery.file.upload;

import org.testng.annotations.Test;

import common.BasePage;
import common.BaseTest;
import common.PageGeneratorManagerGrid;
import pageObject.jquery.file.upload.UploadPageGeneratorManager;
import pageObject.jquery.file.upload.UserHomePageObject;
import pageObjects.grid.user.QuickGridPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level11_File_Upload extends BaseTest{

	@Parameters({"browser", "browserURL"})
	@BeforeClass
	public void beforeClass(String browserName, String browserURL) {
		System.out.println("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName, browserURL);
	}
	
	@Test
	public void Upload_01_Multiple_Files() {
		homePage = UploadPageGeneratorManager.getHomePage(driver);
		homePage.uploadMultipleFilesByFilenames(driver, "IMG_0140.JPEG", "IMG_0141.JPEG", "IMG_1548.JPEG");
		
		Assert.assertTrue(homePage.isFileAdded("IMG_0140.JPEG"));
		Assert.assertTrue(homePage.isFileAdded("IMG_0141.JPEG"));
		Assert.assertTrue(homePage.isFileAdded("IMG_1548.JPEG"));
		
		homePage.clickStartButtons();
		
		Assert.assertTrue(homePage.isFileUploaded("IMG_0140.JPEG"));
		Assert.assertTrue(homePage.isImageLoaded("IMG_0140.JPEG"));
		
		Assert.assertTrue(homePage.isFileUploaded("IMG_0141.JPEG"));
		Assert.assertTrue(homePage.isImageLoaded("IMG_0141.JPEG"));
		
		Assert.assertTrue(homePage.isFileUploaded("IMG_1548.JPEG"));
		Assert.assertTrue(homePage.isImageLoaded("IMG_1548.JPEG"));
	}

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	BasePage basePage;
	UserHomePageObject homePage;
	
	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
