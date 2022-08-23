package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopcommerce.AddressesPageUI;

public class AddressesPageObject extends BasePage{
	WebDriver driver;

	public AddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isAddressesPageDisplayed() {
		return isElementDisplay(driver, AddressesPageUI.ADDRESSES_PAGE_TITLE);
	}
}
