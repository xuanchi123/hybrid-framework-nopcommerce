package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopcommerce.HomePageUI;

public class HomePageObject extends BasePage{

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	
	public CustomerInfoPageObject clickToMyAccountLink() {
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInfoPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isHomePageDisplays() {
		return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
	}
}
