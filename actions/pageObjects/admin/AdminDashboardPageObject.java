package pageObjects.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPageObject extends BasePage {
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

}
