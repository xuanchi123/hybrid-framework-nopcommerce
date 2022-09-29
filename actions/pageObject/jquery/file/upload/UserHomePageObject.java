package pageObject.jquery.file.upload;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUI.jquery.file.upload.HomePageUI;
import common.BasePage;
import common.GlobalConstants;

public class UserHomePageObject extends BasePage{
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileAdded(String fileName) {
		return isElementDisplay(driver, HomePageUI.FILE_ADDED_BY_NAME, fileName);
	}

	public void clickStartButtons() {
		List<WebElement> startButtons = getListWebElements(driver, HomePageUI.START_BUTTONS);
		for (WebElement button : startButtons) {
			button.click();
			sleepInSecond(2);			
		}
	}

	public boolean isFileUploaded(String fileName) {
		return isElementDisplay(driver, HomePageUI.FILE_UPLOADED_LINK_BY_NAME, fileName);
	}

	public boolean isImageLoaded(String fileName) {
		return isImageLoaded(driver, HomePageUI.FILE_UPLOADED_IMAGE_BY_NAME, fileName);
	}
}
