package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminDashboardPageObject extends BasePage {
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

}
