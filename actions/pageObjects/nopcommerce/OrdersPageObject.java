package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopcommerce.OrderPageUI;

public class OrdersPageObject extends BasePage{
	WebDriver driver;

	public OrdersPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isOrdersPageDisplayed() {
		return isElementDisplay(driver, OrderPageUI.ORDERS_PAGE_TITLE);
	}
}
