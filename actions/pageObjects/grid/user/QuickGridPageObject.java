package pageObjects.grid.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIs.grid.user.QuickGridPageUI;

public class QuickGridPageObject extends BasePage{
	WebDriver driver;

	public QuickGridPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByPageNumber(String string) {
		clickToElement(driver, QuickGridPageUI.PAGE_BY_PAGE_NUMBER, string);
	}

	public boolean isPageSelected(String string) {
		return isElementDisplay(driver, QuickGridPageUI.PAGE_BY_PAGE_NUMBER_ACTIVED, string);
	}

	public void enterToHeaderTextBoxByLabel(String headerLabel, String value) {
		sendKeyToElement(driver, QuickGridPageUI.TEXTBOX_BY_COLUMN_NAME, value, headerLabel);
		sendKeyboardToElement(driver, QuickGridPageUI.TEXTBOX_BY_COLUMN_NAME, Keys.ENTER, headerLabel);
	}

	public List<String> getValueEachRowAtAllPage() {
		List<String> valueAtAllPage = new ArrayList<String>();
		
		int allPageNumber = getElementsSize(driver, QuickGridPageUI.ALL_PAGE_NUMBERS);
		for (int i = 1; i <= allPageNumber+1; i++) {
			if (i!=1) {
				clickToElement(driver, QuickGridPageUI.PAGE_BY_PAGE_NUMBER, String.valueOf(i));
			}		
			
			System.out.println("==========\n Data in page " + i);
			
			List<WebElement> allRowEachPage = getListWebElements(driver, QuickGridPageUI.ALL_DATA_ROW);
			
			for (WebElement eachRow : allRowEachPage) {
				valueAtAllPage.add(eachRow.getText());
				System.out.println("\n++++" + eachRow.getText());
			}
			
		}
		return valueAtAllPage;
	}

}
