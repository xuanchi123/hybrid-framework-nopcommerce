package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage{
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to Register Button")
	public void clickToRegisterButton() {
		clickToElement(driver, UserRegisterPageUI.REGISTER_LINK);		
	}
	
	@Step("Get Error mesage at FirstName textbox")
	public String getErrorMessageAtFirstNameTextbox() {
		return getTextInElement(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	
	@Step("Get Error message at last name textbox")
	public String getErrorMesssageAtLastNameTextbox() {
		return getTextInElement(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}
	
	@Step("Get Error message at Email textbox")
	public String getErrorMessageAtEmailTextbox() {
		return getTextInElement(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	@Step("Get Error message at Password textbox")
	public String getErrorMessageAtPasswordTextbox() {
		return getTextInElement(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	@Step("Get Error message at Confirm Password textbox")
	public String getErrorMessageAtConfirmPasswordTextbox() {
		return getTextInElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	@Step("Input to FirstName textbox with value {0}")
	public void inputToFirstNameTextbox(String firstName) {
		sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXT_BOX, firstName);
	}

	@Step("Input to LastName textbox with value {0}")
	public void inputToLastNameTextbox(String lastName) {
		sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXT_BOX, lastName);		
	}

	@Step("Input to Email textbox with value {0}")
	public void inputToEmailTextbox(String email) {
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXT_BOX, email);
	}

	@Step("Input to Password textbox with value {0}")
	public void inputToPasswordTextbox(String password) {
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXT_BOX, password);
	}

	@Step("Input to Confirm Password textbox with value {0}")
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX, confirmPassword);
	}
	
	@Step("Get Register Complete Message")
	public String getRegisterCompleteMessage() {
		return getTextInElement(driver, UserRegisterPageUI.REGISTER_COMPLETE_MESSAGE);
	}

//	public UserHomePageObject clickToLogoutLink() {
//		clickToElement(driver, UserRegisterPageUI.LOG_OUT_LINK);
//		return PageGeneratorManager.getUserHomePage(driver);
//	}

	@Step("Get Register Duplicated Error Message")
	public String getRegisterDuplicatedErrorMessage() {
		return getTextInElement(driver, UserRegisterPageUI.REGISTER_DUPLICATED_ERROR_MESSAGE);
	}
}
