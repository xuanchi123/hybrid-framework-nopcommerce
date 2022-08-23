package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopcommerce.RewardPointsPageUI;

public class RewardPointsPageObject extends BasePage{
	WebDriver driver;

	public RewardPointsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isRewardPointsPageDisplayed() {
		return isElementDisplay(driver, RewardPointsPageUI.REWARD_POINTS_PAGE_TITLE);
	}
}
