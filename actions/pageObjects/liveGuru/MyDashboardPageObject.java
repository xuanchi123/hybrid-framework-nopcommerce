package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;
import common.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage{
	WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getHelloText() {
		return getElementText(driver, MyDashboardPageUI.HELLO_TEXT);
	}	
}
