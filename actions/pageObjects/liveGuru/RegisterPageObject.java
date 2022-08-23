package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.liveGuru.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstNameTextbox(String firstName) {
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailAddressTextbox(String emailAddress) {
		sendKeyToElement(driver, RegisterPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void inputToConfirmPasswordTextbox(String password) {
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
		
	}

	public MyDashboardPageObject clickToRegisterButton() {
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getMyDashboardPage(driver);
	}

}
