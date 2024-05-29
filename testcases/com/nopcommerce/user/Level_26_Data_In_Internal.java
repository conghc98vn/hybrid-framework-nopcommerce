package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;
import reportConfig.ExtentTestManager;
import staticVariable.UserObject;

public class Level_26_Data_In_Internal extends BaseTest {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Random random = new Random();

	HomePageObject homePage;
	LoginPageObject loginPage;
	CustomerPageObject customerPage;
	RegisterPageObject registerPage;

	String firstName, lastName, password, email;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.openPageUrl(driver, "https://demo.nopcommerce.com/");

		firstName = UserObject.FIRST_NAME;
		lastName = UserObject.LAST_NAME;
		password = UserObject.PASSWORD;
		email = getEmailAddress(UserObject.EMAIL_ADDRESS);
	}

	@Test
	public void TC_01_Register_Fail(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Register_Fail");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Verify Register link is displayed");
		verifyTrue(homePage.isRegisterLinkDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Click to Register link");
		homePage.clickToRegisterLink();
	}

	@Test
	public void TC_02_Register_Pass(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Register_Pass");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify Register link is displayed");
		verifyTrue(homePage.isRegisterLinkDisplayed());

		registerPage = new RegisterPageObject(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to FirstName textbox is " + firstName);
		registerPage.enterToFirstNameTextox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to LastName textbox is " + lastName);
		registerPage.enterToLastNameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to Email textbox is " + email);
		registerPage.enterToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Enter to Password textbox is " + password);
		registerPage.enterToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register - Step 08: Enter to Confirm Password textbox is " + password);
		registerPage.enterToConfirmPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 09: Click to Register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO,
				"Register - Step 10: Verify Register Susscess Message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void TC_03_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_03_Login");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click to HomePage Logo");
		homePage = registerPage.clickToHomePageLogo();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Logout");
		homePage.userAbleToLogout(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Click to Login Link");
		loginPage = homePage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email textbox");
		loginPage.enterToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password textbox");
		loginPage.enterToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to My Account Link");
		customerPage = homePage.clickToMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify info is displayed");
		assertEquals(customerPage.getFirstNameAttributeValue(), firstName);
		assertEquals(customerPage.getLastNameAttributeValue(), lastName);
		assertEquals(customerPage.getEmailAttributeValue(), email);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
