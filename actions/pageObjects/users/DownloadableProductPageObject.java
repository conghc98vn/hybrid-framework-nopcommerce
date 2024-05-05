package pageObjects.users;

import org.openqa.selenium.WebDriver;

public class DownloadableProductPageObject extends MyAccountSideBarPageObject {

	WebDriver driver;

	public DownloadableProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
