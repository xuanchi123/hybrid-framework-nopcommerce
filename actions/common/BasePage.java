package common;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.liveGuru.HomePageObject;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.UserAddressesPageObject;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewsPageObject;
import pageObjects.nopcommerce.user.UserOrdersPageObject;
import pageObjects.nopcommerce.user.UserRewardPointsPageObject;
import pageUIs.nopcommerce.admin.AdminBasePageUI;
import pageUIs.nopcommerce.user.UserBasePageUI;
import pageUIs.nopcommerce.user.UserRegisterPageUI;


public class BasePage {
	private long longTimeout;
	private JavascriptExecutor jsExecutor;
	
	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageURL(WebDriver driver, String url) {
		driver.get(url);
	}

	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		alert.accept();
	}

	protected void cancelAlert(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		alert.dismiss();
	}

	protected String getTextAlert(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		return alert.getText();
	}

	protected void sendKeyToAlert(WebDriver driver, String textValue) {
		Alert alert = waitForAlertPresence(driver);
		alert.sendKeys(textValue);
	}

	protected void switchWindowByID(WebDriver driver, String parentWindowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentWindowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	protected void switchWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}

	protected void closeAllTabWithoutParent(WebDriver driver, String parentWindowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentWindowID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentWindowID);
		}
	}
	
//	protected By getByLocator(String locatorType) {
//		System.out.println("-----------locator: " + locatorType);
//		By by = null;
//		String locatorTypeLowercase = locatorType.toLowerCase();
//		
//		if (locatorTypeLowercase.startsWith("xpath=")) {
//			 by = By.xpath(locatorType.substring(6));			
//		} else if (locatorTypeLowercase.startsWith("id=")) {
//			by = By.id(locatorType.substring(3));
//		} else if (locatorTypeLowercase.startsWith("class=")) {
//			by = By.className(locatorType.substring(6));
//		} else if (locatorTypeLowercase.startsWith("name=")) {
//			by = By.name(locatorType.substring(5));
//		} else if (locatorTypeLowercase.startsWith("css=")) {
//			by = By.cssSelector(locatorType.substring(4));
//		} else {
//			throw new RuntimeException("Locator type is not supported!");
//		}
//		return by;
//	}

	protected By getByLocator(String locatorType) {
		System.out.println("-----------locator: " + locatorType);
		By by = null;
		String locatorTypeLowercase = locatorType.toLowerCase();
		
		if (locatorTypeLowercase.startsWith("xpath=")) {
			 by = By.xpath(locatorType.substring(6));			
		} else if (locatorTypeLowercase.startsWith("id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorTypeLowercase.startsWith("class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorTypeLowercase.startsWith("name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorTypeLowercase.startsWith("css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else {
			throw new RuntimeException("Locator type is not supported!");
		}
		return by;
	}

	protected WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	protected List<WebElement> getListWebElements(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	protected void clickToElement(WebDriver driver, String locatorType) {
		waitForElementClickable(driver, locatorType);
		getWebElement(driver, locatorType).click();
	}

	protected void sendKeyToElement(WebDriver driver, String locatorType, String textValue) {
		waitForElementVisible(driver, locatorType);
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	protected void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textValue) {
		waitForElementVisible(driver, locatorType);
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByValue(textValue);
	}

	protected String getSelectedItemInDefaultDropdown(WebDriver driver, String locatorType) {
		waitForElementVisible(driver, locatorType);
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	protected boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	protected void selectItemInCustomDropdown(WebDriver driver, String parentLocatorType, String childItemLocatorType,
			String expectedItem) {
		getWebElement(driver, parentLocatorType).click();
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocatorType)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}

	protected String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}

	protected String getElementText(WebDriver driver, String locatorType) {
		waitForElementVisible(driver, locatorType);
		return getWebElement(driver, locatorType).getText();
	}

	protected String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	protected String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	protected int getElementsSize(WebDriver driver, String locatorType) {
		return getListWebElements(driver, locatorType).size();
	}

	protected void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		waitForElementClickable(driver, locatorType);
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void uncheckToDefaultCheckbox(WebDriver driver, String locatorType) {
		waitForElementClickable(driver, locatorType);
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	protected boolean isElementDisplay(WebDriver driver, String locatorType) {
		waitForElementVisible(driver, locatorType);
		return getWebElement(driver, locatorType).isDisplayed();
	}

	protected boolean isElementSelected(WebDriver driver, String locatorType) {
		waitForElementVisible(driver, locatorType);
		return getWebElement(driver, locatorType).isSelected();
	}

	protected boolean isElementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	protected void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	protected void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	/*
	 * 	public void doubleClickElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, locatorType)).perform();
	}
	 * public void DragDropElement(WebDriver driver, String xpathLocatorSource,
	 * String xpathLocatorTarget) { Actions action = new Actions(driver);
	 * action.dragAndDrop(getWebElement(driver, xpathLocatorSource),
	 * getWebElement(driver, xpathLocatorTarget)) .perform(); }
	 * 
	 * public void sendKeyboardToElement(WebDriver driver, String xpathLocator,
	 * String value) { Actions action = new Actions(driver);
	 * action.sendKeys(getWebElement(driver, xpathLocator), value).perform(); }
	 * 
	 * public void rightClickElement(WebDriver driver, String xpathLocator) {
	 * Actions action = new Actions(driver); action.contextClick().perform(); }
	 */

	protected void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void highlightElement(WebDriver driver, String locatorType) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver, String locatorType) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	protected void scrollToElement(WebDriver driver, String locatorType) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	protected void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}

	protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	protected String getElementValidationMessage(WebDriver driver, String locatorType) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	protected boolean isImageLoaded(WebDriver driver, String locatorType) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	protected WebElement waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	protected List<WebElement> waitForAllElementsVisible(WebDriver driver, String locatorType) {
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	protected WebElement waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		return wait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	
	protected boolean waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	protected boolean waitForAllElementsInvisible(WebDriver driver, String locatorType) {
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		return wait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, locatorType)));
	}

	protected void sleepInSecond(long second) {
		try {
			Thread.sleep(second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public HomePageObject clickLogOutOfLiveGuru(WebDriver driver) {
		clickToElement(driver, pageUIs.liveGuru.BasePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, pageUIs.liveGuru.BasePageUI.LOG_OUT_LINK);
		return pageObjects.liveGuru.PageGeneratorManager.getHomePage(driver);
	}
	
	public UserCustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
		clickToElement(driver, pageUIs.nopcommerce.user.UserBasePageUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}
	
	public UserAddressesPageObject openAddressesPage(WebDriver driver) {
		clickToElement(driver, pageUIs.nopcommerce.user.UserBasePageUI.ADDRESSES_LINK);
		return PageGeneratorManager.getUserAddressesPage(driver);
	}
	
	public UserOrdersPageObject openOrdersPage(WebDriver driver) {
		clickToElement(driver, pageUIs.nopcommerce.user.UserBasePageUI.ORDER_LINK);
		return PageGeneratorManager.getUserOrderPage(driver);
	}
	
	public UserRewardPointsPageObject openRewardPointsPage(WebDriver driver) {
		clickToElement(driver, pageUIs.nopcommerce.user.UserBasePageUI.REWARD_POINTS_LINK);
		return PageGeneratorManager.getUserRewardPointsPage(driver);
	}
	
	public UserMyProductReviewsPageObject openMyProductReviewsPage(WebDriver driver) {
		clickToElement(driver, pageUIs.nopcommerce.user.UserBasePageUI.MY_PRODUCT_REVIEWS_LINK);
		return PageGeneratorManager.getUserMyProductReviewsPage(driver);
	}
	
	public String getPageHeaderTitle(WebDriver driver) {
		return getElementText(driver, UserBasePageUI.PAGE_TITLE);
	}
	
	public AdminLoginPageObject logOutAsAdmin(WebDriver driver) {
		clickToElementByJS(driver, AdminBasePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	public UserHomePageObject logoutAsUser(WebDriver driver) {
		clickToElement(driver, UserRegisterPageUI.LOG_OUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}
}
