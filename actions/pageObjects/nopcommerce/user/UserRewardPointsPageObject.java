package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopcommerce.user.UserRewardPointsPageUI;

public class UserRewardPointsPageObject extends BasePage{
	WebDriver driver;

	public UserRewardPointsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isRewardPointsPageDisplayed() {
		return isElementDisplay(driver, UserRewardPointsPageUI.REWARD_POINTS_PAGE_TITLE);
	}
}
