package com.nopcommerce.share;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

public class Common_Register extends BaseTest {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	public static String pasword, firstName, lastName, email;

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

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextox(firstName);
		registerPage.enterToLastNameTextbox(lastName);
		registerPage.enterToEmailTextbox(email);
		registerPage.enterToPasswordTextbox(pasword);
		registerPage.enterToConfirmPasswordTextbox(pasword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		closeBrowserDriver();
	}

}
