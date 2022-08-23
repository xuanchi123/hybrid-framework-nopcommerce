package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopcommerce.MyProductReviewsPageUI;

public class MyProductReviewsPageObject extends BasePage{
	WebDriver driver;

	public MyProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isMyProductReviewsPageDisplayed() {
		return isElementDisplay(driver, MyProductReviewsPageUI.MY_PRODUCT_REVIEWS_PAGE_TITLE);
	}
}
