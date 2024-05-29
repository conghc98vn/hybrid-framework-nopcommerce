package pageObject.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUI.jquery.UploadPageUI;

import java.util.List;

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

	public boolean isFileUploadedSuccess(String valueName) {
		waitForElementVisible(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, valueName);
		return isElementDisplayed(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, valueName);
	}

	public boolean isLoadingIconAtMainContentDisapear() {
		return waitForElementInvisible(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_CONTENT);
	}

	public boolean isLoadingIconAtMainUploadDisapear() {
		return waitForElementInvisible(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_UPLOAD);

	}

	public boolean isMultipleProgressBarDisapear() {
		return waitForElementInvisible(driver, UploadPageUI.MULTIPLE_PROGRESS_BAR_ICON);

	}

	public boolean isSuccessMessageDisplayed(String value) {
		waitForElementVisible(driver, UploadPageUI.UPLOADED_SUCCESS_MESSAGE);
		return getElementText(driver, UploadPageUI.UPLOADED_SUCCESS_MESSAGE).contains(value);
	}

	public void clickToSuccessLink() {
		waitForElementClickable(driver, UploadPageUI.UPLOADED_SUCCESS_LINK);
		clickToElement(driver, UploadPageUI.UPLOADED_SUCCESS_LINK);
	}

	public boolean isContentTableDisplayed() {
		waitForElementVisible(driver, UploadPageUI.CONTENT_TABLE);
		return isElementDisplayed(driver, UploadPageUI.CONTENT_TABLE);
	}

	public boolean isDownloadButtonDisplayed(String cityValue) {
		waitForElementVisible(driver, UploadPageUI.DOWNLOAD_BUTTON_BY_FILE_NAME, cityValue);
		return isElementDisplayed(driver, UploadPageUI.DOWNLOAD_BUTTON_BY_FILE_NAME, cityValue);
	}

	public boolean isPlayButtonDisplayed(String cityValue) {
		waitForElementVisible(driver, UploadPageUI.PLAY_BUTTON_BY_FILE_NAME, cityValue);
		return isElementDisplayed(driver, UploadPageUI.PLAY_BUTTON_BY_FILE_NAME, cityValue);
	}
}
