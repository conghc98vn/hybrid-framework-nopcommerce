package pageObject.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.jquery.UploadPageUI;

public class UploadPageObject extends BasePage {
	WebDriver driver;

	public UploadPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedSuccess(String valueToSend) {
		waitForElementVisible(driver, UploadPageUI.FILE_LOADED_BY_NAME, valueToSend);
		return isElementDisplayed(driver, UploadPageUI.FILE_LOADED_BY_NAME, valueToSend);
	}

	public void clickStartButtonOnEachFile() {

		List<WebElement> startButtons = getListWebElement(driver, UploadPageUI.MULTIPLE_START_BUTTON);

		for (WebElement startButton : startButtons) {
			waitForElementClickable(driver, startButton);
			clickToElement(driver, startButton);
		}
	}

	public boolean isFileUploadedSuccess(String valueToSend) {
		waitForElementVisible(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, valueToSend);
		return isElementDisplayed(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, valueToSend);
	}
}
