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

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class Level_07_Page_Generator_03 extends BaseTest {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Random random = new Random();
	String email = "JohnWick" + random.nextInt() + "@gmail.com";

	HomePageObject homePage;
	LoginPageObject loginPage;
	CustomerPageObject customerPage;
	RegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
	}

	@Test
	public void Register_01_Empty_Data() {

		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		registerPage.clickToHomePageLogo();

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextox("John");
		registerPage.enterToLastNameTextbox("Wick");
		registerPage.enterToEmailTextbox("john@wick@gmail.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Please enter a valid email address.");
	}

	@Test
	public void Register_03_Invalid_Password() {
		homePage = registerPage.clickToHomePageLogo();

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextox("John");
		registerPage.enterToLastNameTextbox("Wick");
		registerPage.enterToEmailTextbox("johnwick@gmail.com");
		registerPage.enterToPasswordTextbox("123");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "The password and confirmation password do not match.");
	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {

		homePage = registerPage.clickToHomePageLogo();

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextox("John");
		registerPage.enterToLastNameTextbox("Wick");
		registerPage.enterToEmailTextbox("johnwick@gmail.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Success() {
		homePage = registerPage.clickToHomePageLogo();

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextox("John");
		registerPage.enterToLastNameTextbox("Wick");
		registerPage.enterToEmailTextbox(email);
		registerPage.enterToPasswordTextbox("123123");
		registerPage.enterToConfirmPasswordTextbox("123123");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToHomePageLogo();

		homePage.userAbleToLogout(driver);

		loginPage = homePage.clickToLoginLink();

		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox("123123");
		homePage = loginPage.clickToLoginButton();

		customerPage = homePage.clickToMyAccountLink();

		assertEquals(customerPage.getFirstNameAttributeValue(), "John");
		assertEquals(customerPage.getLastNameAttributeValue(), "Wick");
		assertEquals(customerPage.getEmailAttributeValue(), email);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
