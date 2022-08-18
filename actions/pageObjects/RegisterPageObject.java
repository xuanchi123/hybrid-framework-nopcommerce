package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_LINK);
		clickToElement(driver, RegisterPageUI.REGISTER_LINK);		
	}
	
	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	
	public String getErrorMesssageAtLastNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXT_BOX);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXT_BOX, lastName);		
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXT_BOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXT_BOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT_BOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXT_BOX, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX, confirmPassword);
	}
	
	public String getRegisterCompleteMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_COMPLETE_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_COMPLETE_MESSAGE);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOG_OUT_LINK);
		clickToElement(driver, RegisterPageUI.LOG_OUT_LINK);		
	}

	public String getRegisterDuplicatedErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_DUPLICATED_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_DUPLICATED_ERROR_MESSAGE);
	}
}
