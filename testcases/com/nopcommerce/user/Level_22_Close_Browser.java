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

public class Level_22_Close_Browser extends BaseTest {

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

		homePage.clickToHeaderLinkByName(driver, "Register");

		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals("a", "b");

	}

	@Test
	public void Register_01_Empty_Data() {

	}

	@Test
	public void Register_02_Invalid_Email() {

	}

	@Test
	public void Register_03_Invalid_Password() {
	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {
	}

	@Test
	public void Register_05_Success() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
