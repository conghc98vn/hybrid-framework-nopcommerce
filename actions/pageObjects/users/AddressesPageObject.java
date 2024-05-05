package pageObjects.users;

import org.openqa.selenium.WebDriver;

public class AddressesPageObject extends MyAccountSideBarPageObject {

	WebDriver driver;

	public AddressesPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
