package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopcommerce.user.UserAddressesPageUI;

public class UserAddressesPageObject extends BasePage{
	WebDriver driver;

	public UserAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isAddressesPageDisplayed() {
		return isElementDisplay(driver, UserAddressesPageUI.ADDRESSES_PAGE_TITLE);
	}
}
