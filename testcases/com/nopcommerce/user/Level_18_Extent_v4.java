package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

import java.lang.reflect.Method;
import java.util.Random;

public class Level_18_Extent_v4 extends BaseTest {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Random random = new Random();
	String email = getEmailAddress();

	HomePageObject homePage;
	LoginPageObject loginPage;
	CustomerPageObject customerPage;
	RegisterPageObject registerPage;

	String firstName = "John";
	String lastName = "Wick";
	String password = "123123";
	String confirmPassword = "123123";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_Fail(Method method) {
		verifyFalse(homePage.isRegisterLinkDisplayed());

		homePage.clickToRegisterLink();
	}

	@Test
	public void TC_02_Register_Pass(Method method) {

		verifyTrue(homePage.isRegisterLinkDisplayed());

		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextox(firstName);

		registerPage.enterToLastNameTextbox(lastName);

		registerPage.enterToEmailTextbox(email);

		registerPage.enterToPasswordTextbox(password);

		registerPage.enterToConfirmPasswordTextbox(confirmPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
