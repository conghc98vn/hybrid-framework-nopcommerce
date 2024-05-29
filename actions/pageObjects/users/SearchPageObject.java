package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import pageUIs.users.SearchPageUI;

public class SearchPageObject extends BaseElement {
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToSearchTextbox(String value) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, value);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);

	}
}
