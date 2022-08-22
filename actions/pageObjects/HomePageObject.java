package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterLink() {
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}

	public boolean isHomePageDisplays() {
		return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
	}
}
