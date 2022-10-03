package pageObjects.grid.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.grid.user.AppendGridPageUI;
import pageUIs.grid.user.QuickGridPageUI;

public class AppendGridPageObject extends BasePage{
	WebDriver driver;

	public AppendGridPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputValueAtRowByColumn(String row, String columnName, String value) {
		int columnIndex = getElementsSize(driver, AppendGridPageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		sendKeyToElement(driver, AppendGridPageUI.TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, value, row, String.valueOf(columnIndex));
	}

	public void selectValueInDropdownAtRowByColumn(String row, String columnName, String value) {
		int columnIndex = getElementsSize(driver, AppendGridPageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		selectItemInDefaultDropdown(driver, AppendGridPageUI.DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, value, row, String.valueOf(columnIndex));
	}

	public void selectCheckboxAtRowByColumn(String row, String columnName) {
		int columnIndex = getElementsSize(driver, AppendGridPageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		checkToDefaultCheckboxRadio(driver, AppendGridPageUI.CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, row, String.valueOf(columnIndex));
	}

	public void clickToLoadDataButton() {
		clickToElement(driver, AppendGridPageUI.BUTTON_LOAD_DATA);
	}

	public void clickToIconNameAtRow(String row, String columnName) {
		clickToElement(driver, AppendGridPageUI.ICON_NAME_BY_ROW_INDEX, row, columnName);	
	}
}
