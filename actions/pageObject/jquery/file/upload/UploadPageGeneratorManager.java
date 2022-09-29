package pageObject.jquery.file.upload;

import org.openqa.selenium.WebDriver;

public class UploadPageGeneratorManager {
	public static UserHomePageObject getHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);		
	}
}
