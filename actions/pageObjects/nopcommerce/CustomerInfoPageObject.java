package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopcommerce.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage{
	WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInforPageDisplayed() {
		return isElementDisplay(driver, CustomerInfoPageUI.CUSTOMER_INFO_PAGE_TITLE);
	}
}
