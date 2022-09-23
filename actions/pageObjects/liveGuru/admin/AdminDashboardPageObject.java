package pageObjects.liveGuru.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.liveGuru.admin.DashboardPageUI;
import pageUIs.liveGuru.admin.LoginPageUI;

public class AdminDashboardPageObject extends BasePage{
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void closeIncomingMessagePopup() {
		clickToElement(driver, DashboardPageUI.CLOSE_POPUP_ICON);
	}
	
	public void searchCustomerByName(String userName) {
		sendKeyToElement(driver, DashboardPageUI.TEXT_BOX_NAME, userName);
		clickToElement(driver, DashboardPageUI.BUTTON_SEARCH);
		waitForElementInvisible(driver, DashboardPageUI.LOADING_ICON);
	}
	
	public void searchCustomerByNameAndEmail(String userName, String email) {
		sendKeyToElement(driver, DashboardPageUI.TEXT_BOX_NAME, userName);
		sendKeyToElement(driver, DashboardPageUI.TEXT_BOX_EMAIL, email);
		clickToElement(driver, DashboardPageUI.BUTTON_SEARCH);
		waitForElementInvisible(driver, DashboardPageUI.LOADING_ICON);
	}

	public boolean isCustomerRowPresentWithNameAndEmail(String row, String customerName, String emailAddress) {
		return isElementDisplay(driver, DashboardPageUI.CUSTOMER_DATA_BY_ROW_ID_AND_NAME_AND_EMAIL, row, customerName, emailAddress);
	}	

	public boolean isAllCustomerRowsPresentWithNameAndEmail(String customerName, String emailAddress) {
		int numberOfCustomerRows = getElementsSize(driver, DashboardPageUI.NUMBER_OF_CUSTOMER_ROWS);
		for (int i = 1; i <= numberOfCustomerRows; i++) {
			if(!isCustomerRowPresentWithNameAndEmail(String.valueOf(i), customerName, emailAddress)) {
				return false;
			}
		}
		return true;
	}	
	
}
