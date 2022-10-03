package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.grid.user.AppendGridPageObject;
import pageObjects.grid.user.QuickGridPageObject;

public class PageGeneratorManagerGrid {
	public static QuickGridPageObject getQuickGridPage(WebDriver driver) {
		return new QuickGridPageObject(driver);
	}
	public static AppendGridPageObject getAppendGridPage(WebDriver driver) {
		return new AppendGridPageObject(driver);	
	}
}
