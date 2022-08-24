package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.nopcommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage{

	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickToRegisterLink() {
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	
	public UserCustomerInfoPageObject clickToMyAccountLink() {
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInfoPage(driver);
	}

	public UserLoginPageObject clickToLoginLink() {
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isHomePageDisplays() {
		return isElementDisplay(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}
}