package common;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected WebDriver getBrowserDriver(String browserName) {
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
		driver.get("https://demo.nopcommerce.com/");
//		driver.get("http://live.techpanda.org/");
		driver.manage().window().fullscreen();	
		return driver;
	}

	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(99999);		
	}	
}
