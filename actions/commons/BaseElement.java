package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.users.HomePageObject;
import pageUIs.users.BaseElementUI;

public class BaseElement extends BasePage {
	WebDriver driver;

	public BaseElement(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public HomePageObject clickToHomePageLogo() {
		waitForElementClickable(driver, BaseElementUI.HOMEPAGE_LOGO_IMAGE);
		clickToElement(driver, BaseElementUI.HOMEPAGE_LOGO_IMAGE);
		return PageGeneratorManager.getHomePage(driver);
	}

	public void clickToHeaderLinkByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
		clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);

	}

	public void clickToButtonByText(String buttonText) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
	}

	public String getTextboxErrorMessageByID(String errorMessageID) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXT_ERROR_MSG_BY_ID, errorMessageID);
		return getElementText(driver, BaseElementUI.DYNAMIC_TEXT_ERROR_MSG_BY_ID, errorMessageID);
	}

	public void enterToTextboxByID(String textboxID, String valueToSend) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, valueToSend, textboxID);
	}

	public String getTextboxAttributeByID(String textboxID) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}
}
