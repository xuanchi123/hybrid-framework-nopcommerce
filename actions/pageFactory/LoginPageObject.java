package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	private WebElement emailTextBox;
	
	@FindBy(id="Password")
	private WebElement passwordTextBox;
	
	@FindBy(css="button.login-button")
	private WebElement loginButton;
	
	@FindBy(id="Email-error")
	private WebElement emailErrorMessage;

	@FindBy(css="div.validation-summary-errors")
	private WebElement unsuccessfulMessage;
	
	public void clickToLogInButton() {
		clickToElement(driver, loginButton);
	}

	public String getErrorMessageAtEmailTextbox() {
		return getElementText(driver, emailErrorMessage);
	}

	public void inputToEmailTextbox(String email) {
		sendKeyToElement(driver, emailTextBox, email);
	}

	public void inputToPasswordTextbox(String password) {
		sendKeyToElement(driver, passwordTextBox, password);		
	}

	public String getUnsuccessfulErrorMessage() {
		return getElementText(driver, unsuccessfulMessage);
	}
}
