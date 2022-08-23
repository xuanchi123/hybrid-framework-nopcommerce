package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToCreateAnAccountButton() {
		clickToElement(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public void inputToEmailAddressTextbox(String emailAddress) {
		sendKeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public MyDashboardPageObject clickToLoginButton() {
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMyDashboardPage(driver);
	}
}
