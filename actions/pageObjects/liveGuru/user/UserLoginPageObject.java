package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.user.LoginPageUI;

public class UserLoginPageObject extends BasePage{
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickToCreateAnAccountButton() {
		clickToElement(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		return UserPageGeneratorManager.getRegisterPage(driver);
	}

	public void inputToEmailAddressTextbox(String emailAddress) {
		sendKeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public UserMyDashboardPageObject clickToLoginButton() {
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return UserPageGeneratorManager.getMyDashboardPage(driver);
	}
}
