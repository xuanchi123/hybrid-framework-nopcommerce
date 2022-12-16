package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage{

	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to Register Link")
	public UserRegisterPageObject clickToRegisterLink() {
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
	
	@Step("Click to My Account Link")
	public UserCustomerInfoPageObject clickToMyAccountLink() {
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	@Step("Click to Login Link")
	public UserLoginPageObject clickToLoginLink() {
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	
	@Step("Verify Home Page Displays")
	public boolean isHomePageDisplays() {
		return isElementDisplay(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}
}
