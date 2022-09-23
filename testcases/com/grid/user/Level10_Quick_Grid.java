
package com.grid.user;

import org.testng.annotations.Test;

import common.BasePage;
import common.BaseTest;
import common.PageGeneratorManagerGrid;
import pageObjects.grid.user.QuickGridPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level10_Quick_Grid extends BaseTest{

	@Parameters({"browser", "browserURL"})
	@BeforeClass
	public void beforeClass(String browserName, String browserURL) {
		System.out.println("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName, browserURL);
	}
	
//	@Test
	public void Grid_01_Paging() {
		homePage = PageGeneratorManagerGrid.getQuickGridPage(driver);
		
		homePage.openPageByPageNumber("3");
		Assert.assertTrue(homePage.isPageSelected("3"));

		homePage.openPageByPageNumber("7");
		Assert.assertTrue(homePage.isPageSelected("7"));
		
		homePage.openPageByPageNumber("9");
		Assert.assertTrue(homePage.isPageSelected("9"));
	}
	
//	@Test
	public void Grid_02_Enter_To_Header() {
		homePage = PageGeneratorManagerGrid.getQuickGridPage(driver);
		homePage.enterToHeaderTextBoxByLabel("Females", "15999");
		homePage.enterToHeaderTextBoxByLabel("Country", "Armenia");
		homePage.enterToHeaderTextBoxByLabel("Males", "16456");
		homePage.enterToHeaderTextBoxByLabel("Total", "32487");
	}
	
	@Test
	public void Grid_02_Get_All_Value_Each_Page() {
		List<String> expectedResult = new ArrayList<String>();
		homePage = PageGeneratorManagerGrid.getQuickGridPage(driver);		
		expectedResult = homePage.getValueEachRowAtAllPage();
	}

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	BasePage basePage;
	QuickGridPageObject homePage;
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
