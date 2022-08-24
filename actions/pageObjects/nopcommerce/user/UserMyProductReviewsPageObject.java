package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopcommerce.user.UserMyProductReviewsPageUI;

public class UserMyProductReviewsPageObject extends BasePage{
	WebDriver driver;

	public UserMyProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isMyProductReviewsPageDisplayed() {
		return isElementDisplay(driver, UserMyProductReviewsPageUI.MY_PRODUCT_REVIEWS_PAGE_TITLE);
	}
}
