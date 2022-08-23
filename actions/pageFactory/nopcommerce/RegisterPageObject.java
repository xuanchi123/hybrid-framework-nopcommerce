package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePageFactory;


public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="register-button")
	private WebElement registerButton;
	
	@FindBy(id="FirstName-error")
	private WebElement firstNameErrorMessage;
	
	@FindBy(id="LastName-error")
	private WebElement lastNameErrorMessage;
	
	@FindBy(id="Email-error")
	private WebElement emailErrorMessage;
	
	@FindBy(id="Password-error")
	private WebElement passwordErrorMessage;
	
	@FindBy(id="ConfirmPassword-error")
	private WebElement confirmPasswordErrorMessage;
	
	@FindBy(id="FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(id="LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(id="Email")
	private WebElement emailTextbox;
	
	@FindBy(id="Password")
	private WebElement passwordTextbox;
	
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(css="div.message-error li")
	private WebElement registerDuplicatedErrorMessage;
	
	@FindBy(css="div.result")
	private WebElement registerCompleteMessage;
	
	@FindBy(css="a.ico-logout")
	private WebElement logoutLink;

	public void clickToRegisterButton() {
		clickToElement(driver, registerButton);		
	}
	
	public String getErrorMessageAtFirstNameTextbox() {
		return getElementText(driver, firstNameErrorMessage);
	}
	
	public String getErrorMesssageAtLastNameTextbox() {
		return getElementText(driver, lastNameErrorMessage);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		return getElementText(driver, emailErrorMessage);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public void inputToFirstNameTextbox(String firstName) {
		sendKeyToElement(driver, firstNameTextbox, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		sendKeyToElement(driver, lastNameTextbox, lastName);		
	}

	public void inputToEmailTextbox(String email) {
		sendKeyToElement(driver, emailTextbox, email);
	}

	public void inputToPasswordTextbox(String password) {
		sendKeyToElement(driver, passwordTextbox, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		sendKeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}
	
	public String getRegisterCompleteMessage() {
		return getElementText(driver, registerCompleteMessage);
	}

	public void clickToLogoutLink() {
		clickToElement(driver, logoutLink);		
	}

	public String getRegisterDuplicatedErrorMessage() {
		return getElementText(driver, registerDuplicatedErrorMessage);
	}
}
