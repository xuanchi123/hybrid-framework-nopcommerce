package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLogInButton() {
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String getErrorMessageAtEmailTextbox() {
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String email) {
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);		
	}

	public String getUnsuccessfulErrorMessage() {
		return getElementText(driver, LoginPageUI.UNSUCCESSFUL_MESSAGE);
	}
}
