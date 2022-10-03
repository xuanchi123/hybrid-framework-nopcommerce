package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a.ico-register")
	private WebElement registerLink;

	@FindBy(css="a.ico-login")
	private WebElement loginLink;
	
	@FindBy(css="a.ico-account")
	private WebElement myAccountLink;

	public void clickToRegisterLink() {
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		clickToElement(driver, loginLink);
	}

	public boolean isHomePageDisplays() {
		return isElementDisplay(driver, myAccountLink);
	}
}
