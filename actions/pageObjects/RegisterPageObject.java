package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.HomePageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_LINK);
		clickToElement(driver, RegisterPageUI.REGISTER_LINK);		
	}
	
	public String getFirstNameErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	
	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}
	
	public String getEmailErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX, firstName);
		
	}

	public void inputLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXT_BOX);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXT_BOX, lastName);
		
	}

	public void inputEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXT_BOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXT_BOX, email);
		
	}

	public void inputPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT_BOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXT_BOX, password);
		
	}

	public void inputConfirmPasswordTextbox(String confirmPassword) {
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
