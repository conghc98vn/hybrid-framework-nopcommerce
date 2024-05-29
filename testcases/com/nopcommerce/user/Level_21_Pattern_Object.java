package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class Level_21_Pattern_Object extends BaseTest {

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

		homePage.clickToHeaderLinkByName(driver, "Register");

		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.clickToButtonByText("Register");

		// Error locator this section Element of web diffferent from run test 2
//		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("FirstName"), "First name is required.");
//		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("LastName"), "Last name is required.");
//		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Email"), "Email is required.");
//		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("ConfirmPassword"), "Password is required.");
	}

//	@Test
	public void Register_02_Invalid_Email() {

		registerPage.clickToHomePageLogo();

		homePage.clickToHeaderLinkByName(driver, "Register");

		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.enterToTextboxByID("FirstName", "John");
		registerPage.enterToTextboxByID("LastName", "Wick");
		registerPage.enterToTextboxByID("Email", "john@wick@gmail.com");
		registerPage.enterToTextboxByID("Password", "123456");
		registerPage.enterToTextboxByID("ConfirmPassword", "123456");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Email"), "Please enter a valid email address.");
	}

//	@Test
	public void Register_03_Invalid_Password() {
		homePage = registerPage.clickToHomePageLogo();

		homePage.clickToHeaderLinkByName(driver, "Register");

		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.enterToTextboxByID("FirstName", "John");
		registerPage.enterToTextboxByID("LastName", "Wick");
		registerPage.enterToTextboxByID("Email", "johnwick@gmail.com");
		registerPage.enterToTextboxByID("Password", "123");
		registerPage.enterToTextboxByID("ConfirmPassword", "123");

		registerPage.clickToButtonByText("Register");

//		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Password"), "<p>Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
	}

//	@Test
	public void Register_04_Incorrect_Confirm_Password() {

		homePage = registerPage.clickToHomePageLogo();

		homePage.clickToHeaderLinkByName(driver, "Register");

		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.enterToTextboxByID("FirstName", "John");
		registerPage.enterToTextboxByID("LastName", "Wick");
		registerPage.enterToTextboxByID("Email", "johnwick@gmail.com");
		registerPage.enterToTextboxByID("Password", "123456");
		registerPage.enterToTextboxByID("ConfirmPassword", "123");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("ConfirmPassword"), "The password and confirmation password do not match.");
	}

//	@Test
	public void Register_05_Success() {
		homePage = registerPage.clickToHomePageLogo();

		homePage.clickToHeaderLinkByName(driver, "Register");

		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.enterToTextboxByID("FirstName", "John");
		registerPage.enterToTextboxByID("LastName", "Wick");
		registerPage.enterToTextboxByID("Email", email);
		registerPage.enterToTextboxByID("Password", "123456");
		registerPage.enterToTextboxByID("ConfirmPassword", "123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToHomePageLogo();

		homePage.userAbleToLogout(driver);

		homePage.clickToHeaderLinkByName(driver, "Log in");

		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox("123456");

		loginPage.clickToButtonByText("Log in");

		homePage = PageGeneratorManager.getHomePage(driver);

		homePage.clickToHeaderLinkByName(driver, "My account");

		customerPage = PageGeneratorManager.getCustomerPage(driver);

		assertEquals(customerPage.getTextboxAttributeByID("FirstName"), "John");
		assertEquals(customerPage.getTextboxAttributeByID("LastName"), "Wick");
		assertEquals(customerPage.getTextboxAttributeByID("Email"), email);

	}

//	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
