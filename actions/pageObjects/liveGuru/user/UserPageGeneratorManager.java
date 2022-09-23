package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;

public class UserPageGeneratorManager {
	public static UserHomePageObject getHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);		
	}
	
	public static UserLoginPageObject getLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);		
	}
	
	public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);		
	}
	
	public static UserMyDashboardPageObject getMyDashboardPage(WebDriver driver) {
		return new UserMyDashboardPageObject(driver);		
	}
}
