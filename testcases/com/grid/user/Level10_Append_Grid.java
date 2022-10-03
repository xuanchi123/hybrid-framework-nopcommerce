
package com.grid.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManagerGrid;
import pageObjects.grid.user.AppendGridPageObject;
import pageObjects.grid.user.QuickGridPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level10_Append_Grid extends BaseTest{

	@Parameters({"browser", "browserURL"})
	@BeforeClass
	public void beforeClass(String browserName, String browserURL) {
		System.out.println("---------Browser: " + browserName + " -------------");
		driver = getBrowserDriver(browserName, browserURL);
	}
		
	@Test
	public void Grid_01_Add_Data_To_Any_Row() {
		appendGridPage = PageGeneratorManagerGrid.getAppendGridPage(driver);
		appendGridPage.clickToLoadDataButton();
		appendGridPage.clickToIconNameAtRow("2", "Insert Row Above");
		appendGridPage.clickToIconNameAtRow("3", "Move Up");
		appendGridPage.clickToIconNameAtRow("3", "Move Down");		
		appendGridPage.inputValueAtRowByColumn("4", "Album", "Lady");
		appendGridPage.inputValueAtRowByColumn("4", "Artist", "Modern Talking");
		appendGridPage.inputValueAtRowByColumn("4", "Year", "1960");
		appendGridPage.inputValueAtRowByColumn("4", "Price", "100");
		appendGridPage.selectValueInDropdownAtRowByColumn("4", "Origin", "Korea");
		appendGridPage.selectCheckboxAtRowByColumn("4", "With Poster?");
		appendGridPage.clickToIconNameAtRow("5", "Remove Current Row");
		appendGridPage.clickToIconNameAtRow("1", "Remove Current Row");
	}

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	BasePage basePage;
	AppendGridPageObject appendGridPage;
	

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
