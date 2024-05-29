package pageObjects.facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.facebook.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;

	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isFirstNameTextboxDisplayed() {
//		waitForElementVisible(driver, HomePageUI.FIRSTNAME_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.FIRSTNAME_TEXTBOX);
	}

	public boolean isSurNameTextboxDisplayed() {
//		waitForElementVisible(driver, HomePageUI.SURNAME_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.SURNAME_TEXTBOX);
	}

	public boolean isEmailTextboxDisplayed() {
//		waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.EMAIL_TEXTBOX);
	}

	public boolean isPasswordTextboxDisplayed() {
//		waitForElementVisible(driver, HomePageUI.PASSWORD_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.PASSWORD_TEXTBOX);
	}

	public void enterToEmailTextbox(String valueToSend) {
		waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, HomePageUI.EMAIL_TEXTBOX, valueToSend);

	}

	public boolean isConfirmEmailTextboxDisplayed() {
		return isElementDisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void clickToCloseSignUpPopup() {
		waitForElementClickable(driver, HomePageUI.CLOSE_SIGNUP_POPUP);
		clickToElement(driver, HomePageUI.CLOSE_SIGNUP_POPUP);
		sleepInSecond(2);
	}

	public void enterToFirstNameTextbox(String valueToSend) {
		waitForElementVisible(driver, HomePageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, HomePageUI.FIRSTNAME_TEXTBOX, valueToSend);
	}

	public void enterToSurNameTextbox(String valueToSend) {
		waitForElementVisible(driver, HomePageUI.SURNAME_TEXTBOX);
		sendkeyToElement(driver, HomePageUI.SURNAME_TEXTBOX, valueToSend);
	}

	public boolean isFirstNameTextboxUndisplayed() {
		return isElementUndisplayed(driver, HomePageUI.FIRSTNAME_TEXTBOX);

	}

	public boolean isSurNameTextboxUndisplayed() {
		return isElementUndisplayed(driver, HomePageUI.SURNAME_TEXTBOX);
	}

	public boolean isEmailTextboxUndisplayed() {
		return isElementUndisplayed(driver, HomePageUI.EMAIL_TEXTBOX);
	}

	public boolean isPasswordTextboxUndisplayed() {
		return isElementUndisplayed(driver, HomePageUI.PASSWORD_TEXTBOX);
	}
}
