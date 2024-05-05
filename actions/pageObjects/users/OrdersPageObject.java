package pageObjects.users;

import org.openqa.selenium.WebDriver;

public class OrdersPageObject extends MyAccountSideBarPageObject {

	WebDriver driver;

	public OrdersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
