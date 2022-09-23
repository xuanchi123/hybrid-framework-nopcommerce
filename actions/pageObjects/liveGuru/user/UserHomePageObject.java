package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.liveGuru.user.HomePageUI;

public class UserHomePageObject extends BasePage{
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserLoginPageObject clickToMyAccountLink() {
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return UserPageGeneratorManager.getLoginPage(driver);
	}
}
