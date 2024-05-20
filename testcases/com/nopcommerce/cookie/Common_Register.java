package com.nopcommerce.cookie;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

public class Common_Register extends BaseTest {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	public static String pasword, firstName, lastName, email;
	public static Set<Cookie> cookies;

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

	@Parameters("browser")

	@BeforeTest
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		firstName = "John";
		lastName = "Wick";
		pasword = "123123";
		email = getEmailAddress();

		homePage = PageGeneratorManager.getHomePage(driver);

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextox(firstName);
		registerPage.enterToLastNameTextbox(lastName);
		registerPage.enterToEmailTextbox(email);
		registerPage.enterToPasswordTextbox(pasword);
		registerPage.enterToConfirmPasswordTextbox(pasword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		registerPage.userAbleToLogout(driver);

		homePage = registerPage.clickToHomePageLogo();

		loginPage = homePage.clickToLoginLink();

		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox(pasword);

		homePage = loginPage.clickToLoginButton();

		loginPage.sleepInSecond(2);

		cookies = registerPage.getBrowserCookies(driver);

		closeBrowserDriver();

	}

}