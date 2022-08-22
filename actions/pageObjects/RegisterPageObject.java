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
		clickToElement(driver, RegisterPageUI.REGISTER_LINK);		
	}
	
	public String getErrorMessageAtFirstNameTextbox() {
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	
	public String getErrorMesssageAtLastNameTextbox() {
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextbox(String firstName) {
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXT_BOX, lastName);		
	}

	public void inputToEmailTextbox(String email) {
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXT_BOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXT_BOX, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX, confirmPassword);
	}
	
	public String getRegisterCompleteMessage() {
		return getElementText(driver, RegisterPageUI.REGISTER_COMPLETE_MESSAGE);
	}

	public void clickToLogoutLink() {
		clickToElement(driver, RegisterPageUI.LOG_OUT_LINK);		
	}

	public String getRegisterDuplicatedErrorMessage() {
		return getElementText(driver, RegisterPageUI.REGISTER_DUPLICATED_ERROR_MESSAGE);
	}
}
