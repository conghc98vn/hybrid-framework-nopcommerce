package commons;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

		switch (browserList) {
		case CHROME:
			driver = new ChromeDriver();
			break;

		case FIREFOX:
			driver = new FirefoxDriver();
			break;

		case EDGE:
			driver = new EdgeDriver();

		default:
			throw new RuntimeException("Browser name is not valid");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalContants.LONG_TIMEOUT));
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String urlValue) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

		switch (browserList) {
		case CHROME:
			driver = new ChromeDriver();
			break;

		case FIREFOX:
			driver = new FirefoxDriver();
			break;

		case EDGE:
			driver = new EdgeDriver();

		default:
			throw new RuntimeException("Browser name is not valid");
		}

		driver.get(urlValue);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalContants.LONG_TIMEOUT));
		return driver;
	}

	protected String getEmailAddress() {
		Random rand = new Random();
		return "john" + rand.nextInt(9999) + "@gmail.com";
	}

	protected void quitBrowserDriver() {
		if (driver == null) {
			System.out.println("Browser is closed.");
		} else {
			driver.quit();
		}
	}
}
