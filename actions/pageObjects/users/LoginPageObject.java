package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import jsonData.nopcommerce.UserInfoData;
import pageUIs.users.LoginPageUI;
import pojoData.UserInfo;

public class LoginPageObject extends BaseElement {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.LOGIN_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.LOGIN_TEXTBOX, emailAddress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new HomePageObject(driver);
	}

	public HomePageObject loginToApplication(UserInfo userInfo) {
		enterToEmailTextbox(userInfo.getEmailAddress());
		enterToPasswordTextbox(userInfo.getPassword());
		return clickToLoginButton();
	}

	public HomePageObject loginToSystem(UserInfoData userInfo) {
		enterToEmailTextbox(userInfo.getEmail());
		enterToPasswordTextbox(userInfo.getPassword());
		return clickToLoginButton();
	}

}
