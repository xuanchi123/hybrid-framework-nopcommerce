package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	
	protected final Log log;	

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String browserURL) {
		switch (browserName) {
		case "firefox":
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case "firefoxheadless":
			FirefoxOptions ffOption = new FirefoxOptions();
			ffOption.addArguments("headless");
			ffOption.addArguments("window-size=1920x1080");
			driver = WebDriverManager.firefoxdriver().capabilities(ffOption).create();
			break;
		case "chrome":
			driver = WebDriverManager.chromedriver().create();
			break;
		case "chromeheadless":
			ChromeOptions chromeOption = new ChromeOptions();
			chromeOption.addArguments("headless");
			chromeOption.addArguments("window-size=1920x1080");
			driver = WebDriverManager.chromedriver().capabilities(chromeOption).create();
			break;
		case "edge":
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new RuntimeException("Invalid driver");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.get(browserURL);
		driver.manage().window().fullscreen();	
		return driver;
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info(" -------------------------- PASSED -------------------------- ");	
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {		
			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");	
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(99999);		
	}	
}
