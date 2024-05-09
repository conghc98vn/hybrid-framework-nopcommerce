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
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

@Epic("Account")
@Feature("Create Account")
public class Level_19_Allure_Report extends BaseTest {

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
		deleteAllFileInFolder("allure-results");
	}

	@Description("Usser 01 - Validate register form")
	@Story("Register")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_Register_Fail() {

		Assert.assertTrue(homePage.isRegisterLinkDisplayed());

		homePage.clickToRegisterLink();
	}

	@Description("Usser 01 - Register Success")
	@Story("Register")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void TC_02_Register_Pass() {

		verifyTrue(homePage.isRegisterLinkDisplayed());

		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextox(firstName);

		registerPage.enterToLastNameTextbox(lastName);

		registerPage.enterToEmailTextbox(email);

		registerPage.enterToPasswordTextbox(password);

		registerPage.enterToConfirmPasswordTextbox(confirmPassword);

		registerPage.clickToRegisterButton();

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		
//		Assert.assertTrue(homePage.isRegisterLinkDisplayed());

//		Assert.assertFalse(registerPage.getRegisterSuccessMessage().contains("Your registration completed"));

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
