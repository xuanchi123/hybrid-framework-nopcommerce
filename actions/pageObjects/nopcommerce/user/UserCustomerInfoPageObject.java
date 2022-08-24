package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopcommerce.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage{
	WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInforPageDisplayed() {
		return isElementDisplay(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_PAGE_TITLE);
	}
}
