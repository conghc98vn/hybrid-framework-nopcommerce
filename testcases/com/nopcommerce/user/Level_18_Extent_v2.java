//package com.nopcommerce.user;
//
//import java.lang.reflect.Method;
//import java.util.Random;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import pageObjects.users.CustomerPageObject;
//import pageObjects.users.HomePageObject;
//import pageObjects.users.LoginPageObject;
//import pageObjects.users.RegisterPageObject;
//import reportConfig.ExtentManager;
//
//public class Level_18_Extent_v2 extends BaseTest {
//
//	WebDriver driver;
//	String projectPath = System.getProperty("user.dir");
//	Random random = new Random();
//	String email = getEmailAddress();
//
//	HomePageObject homePage;
//	LoginPageObject loginPage;
//	CustomerPageObject customerPage;
//	RegisterPageObject registerPage;
//
//	String firstName = "John";
//	String lastName = "Wick";
//	String password = "123123";
//	String confirmPassword = "123123";
//
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		driver = getBrowserDriver(browserName);
//		homePage = PageGeneratorManager.getHomePage(driver);
//		homePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
//	}
//
//	@Test
//	public void TC_01_Register_Fail(Method method) {
//		ExtentManager.startTest(method.getName(), "TC_01_Register_Fail");
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Verify Register link is displayed");
//		verifyFalse(homePage.isRegisterLinkDisplayed());
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Click to Register link");
//		homePage.clickToRegisterLink();
//	}
//
//	@Test
//	public void TC_02_Register_Pass(Method method) {
//		ExtentManager.startTest(method.getName(), "TC_02_Register_Pass");
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Verify Register link is displayed");
//		verifyTrue(homePage.isRegisterLinkDisplayed());
//
//		registerPage = new RegisterPageObject(driver);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to FirstName textbox is " + firstName);
//		registerPage.enterToFirstNameTextox(firstName);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to LastName textbox is " + lastName);
//		registerPage.enterToLastNameTextbox(lastName);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Email textbox is " + email);
//		registerPage.enterToEmailTextbox(email);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Enter to Password textbox is " + password);
//		registerPage.enterToPasswordTextbox(password);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08: Enter to Confirm Password textbox is " + confirmPassword);
//		registerPage.enterToConfirmPasswordTextbox(confirmPassword);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 09: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 10: Verify Register Susscess Message is displayed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");
//	}
//
//	@AfterClass
//	public void afterClass() {
//		quitBrowserDriver();
//	}
//
//}
