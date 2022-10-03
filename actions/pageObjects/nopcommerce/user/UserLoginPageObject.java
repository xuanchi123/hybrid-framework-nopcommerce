package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getErrorMessageAtEmailTextbox() {
		return getTextInElement(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String email) {
		sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);		
	}
	
	public UserHomePageObject clickToLogInButton() {
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public UserHomePageObject loginAsUser(String email, String password) {
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		return clickToLogInButton();
	}

	public String getUnsuccessfulErrorMessage() {
		return getTextInElement(driver, UserLoginPageUI.UNSUCCESSFUL_MESSAGE);
	}
}
