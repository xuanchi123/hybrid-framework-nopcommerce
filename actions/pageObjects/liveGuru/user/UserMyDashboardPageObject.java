package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;
import common.BasePage;
import pageUIs.liveGuru.user.MyDashboardPageUI;

public class UserMyDashboardPageObject extends BasePage{
	WebDriver driver;

	public UserMyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getHelloText() {
		return getTextInElement(driver, MyDashboardPageUI.HELLO_TEXT);
	}	
}
