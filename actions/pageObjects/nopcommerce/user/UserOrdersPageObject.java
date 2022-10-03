package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.UserOrderPageUI;

public class UserOrdersPageObject extends BasePage{
	WebDriver driver;

	public UserOrdersPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isOrdersPageDisplayed() {
		return isElementDisplay(driver, UserOrderPageUI.ORDERS_PAGE_TITLE);
	}
}
