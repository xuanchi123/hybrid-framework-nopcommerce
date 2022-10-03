package pageObjects.liveGuru.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.admin.LoginPageUI;

public class AdminLoginPageObject extends BasePage{
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public AdminDashboardPageObject loginToAdminPage(String userName, String password) {
		sendKeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, userName);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new AdminDashboardPageObject(driver);
	}
}
