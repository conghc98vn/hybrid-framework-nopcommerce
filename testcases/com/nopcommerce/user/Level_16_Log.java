package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

public class Level_16_Log extends BaseTest {

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
	}

	@Test
	public void TC_01_Register_Fail() {

		homePage.openPageUrl(driver, "https://demo.nopcommerce.com/");

		log.info("Register_01 - Step 01: Verify Register link is displayed");
		verifyFalse(homePage.isRegisterLinkDisplayed());

		log.info("Register_01 - Step 02: Click to Register link");
		homePage.clickToRegisterLink();
	}

	@Test
	public void TC_02_Register_Pass() {
		log.info("Register_01 - Step 03: Verify Register link is displayed");
		verifyTrue(homePage.isRegisterLinkDisplayed());

		registerPage = new RegisterPageObject(driver);

		log.info("Register_01 - Step 04: Enter to FirstName textbox is " + firstName);
		registerPage.enterToFirstNameTextox(firstName);

		log.info("Register_01 - Step 05: Enter to LastName textbox is " + lastName);
		registerPage.enterToLastNameTextbox(lastName);

		log.info("Register_01 - Step 06: Enter to Email textbox is " + email);
		registerPage.enterToEmailTextbox(email);

		log.info("Register_01 - Step 07: Enter to Password textbox is " + password);
		registerPage.enterToPasswordTextbox(password);

		log.info("Register_01 - Step 08: Enter to Confirm Password textbox is " + confirmPassword);
		registerPage.enterToConfirmPasswordTextbox(confirmPassword);

		log.info("Register_01 - Step 09: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register_01 - Step 10: Verify Register Susscess Message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
