package pageUIs.nopcommerce;

public class RegisterPageUI {
	public static final String REGISTER_LINK = "//button[@id='register-button']";
	public static final String FIRST_NAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
	public static final String LAST_NAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MESSAGE = "//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
	
	public static final String FIRST_NAME_TEXT_BOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXT_BOX = "//input[@id='LastName']";
	public static final String EMAIL_TEXT_BOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXT_BOX = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXT_BOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_DUPLICATED_ERROR_MESSAGE = "//div[contains(@class,'message-error')]//li";
	public static final String REGISTER_COMPLETE_MESSAGE = "//div[@class='result']";
	public static final String LOG_OUT_LINK = "//a[@class='ico-logout']";	
}
