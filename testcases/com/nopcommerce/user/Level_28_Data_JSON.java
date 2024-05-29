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
import jsonData.nopcommerce.UserInfoData;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_28_Data_JSON extends BaseTest {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Random random = new Random();

	HomePageObject homePage;
	LoginPageObject loginPage;
	CustomerPageObject customerPage;
	RegisterPageObject registerPage;
	UserInfoData userInfoData;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.openPageUrl(driver, "https://demo.nopcommerce.com/");

		userInfoData = UserInfoData.getUser("userData.json");

		firstName = userInfoData.getFirstname();
		lastName = userInfoData.getLastname();
		password = userInfoData.getPassword();

		userInfoData.setEmail(getEmailAddress(userInfoData.getEmail()));
		email = userInfoData.getEmail();

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

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Verify Register link is displayed");
		verifyTrue(homePage.isRegisterLinkDisplayed());

		registerPage = new RegisterPageObject(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to Register form");
		registerPage.enterToRegisterForm(userInfoData);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO,
				"Register - Step 04: Verify Register Susscess Message is displayed");
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

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email / Password");
		homePage = loginPage.loginToSystem(userInfoData);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Click to My Account Link");
		customerPage = homePage.clickToMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Verify info is displayed");
		assertEquals(customerPage.getFirstNameAttributeValue(), userInfoData.getFirstname());
		assertEquals(customerPage.getLastNameAttributeValue(), userInfoData.getLastname());
		assertEquals(customerPage.getEmailAttributeValue(), userInfoData.getEmail());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	private String firstName, lastName, email, password;
}
