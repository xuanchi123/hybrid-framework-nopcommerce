package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage{
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		clickToElement(driver, UserRegisterPageUI.REGISTER_LINK);		
	}
	
	public String getErrorMessageAtFirstNameTextbox() {
		return getTextInElement(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	
	public String getErrorMesssageAtLastNameTextbox() {
		return getTextInElement(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		return getTextInElement(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		return getTextInElement(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		return getTextInElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextbox(String firstName) {
		sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXT_BOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXT_BOX, lastName);		
	}

	public void inputToEmailTextbox(String email) {
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXT_BOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXT_BOX, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX, confirmPassword);
	}
	
	public String getRegisterCompleteMessage() {
		return getTextInElement(driver, UserRegisterPageUI.REGISTER_COMPLETE_MESSAGE);
	}

//	public UserHomePageObject clickToLogoutLink() {
//		clickToElement(driver, UserRegisterPageUI.LOG_OUT_LINK);
//		return PageGeneratorManager.getUserHomePage(driver);
//	}

	public String getRegisterDuplicatedErrorMessage() {
		return getTextInElement(driver, UserRegisterPageUI.REGISTER_DUPLICATED_ERROR_MESSAGE);
	}
}
