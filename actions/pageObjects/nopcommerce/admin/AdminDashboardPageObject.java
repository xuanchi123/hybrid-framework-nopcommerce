package pageObjects.nopcommerce.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.liveGuru.user.MyDashboardPageUI;
import pageUIs.nopcommerce.admin.AdminDashboardPageUI;
import pageUIs.nopcommerce.user.UserLoginPageUI;

public class AdminDashboardPageObject extends BasePage {
	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isDashboardPageDisplays() {
		return isElementDisplay(driver, AdminDashboardPageUI.DASH_BOARD_HEADER);
	}
}
