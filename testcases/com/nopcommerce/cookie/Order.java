package com.nopcommerce.cookie;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.WebDriver;
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

public class Order extends BaseTest {

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

		homePage = registerPage.clickToHomePageLogo();

		homePage.userAbleToLogout(driver);

		loginPage = homePage.clickToLoginLink();

		loginPage.enterToEmailTextbox(Common_Register.email);
		loginPage.enterToPasswordTextbox(Common_Register.pasword);
		homePage = loginPage.clickToLoginButton();

		customerPage = homePage.clickToMyAccountLink();

		assertEquals(customerPage.getFirstNameAttributeValue(), Common_Register.firstName);
		assertEquals(customerPage.getLastNameAttributeValue(), Common_Register.lastName);
		assertEquals(customerPage.getEmailAttributeValue(), Common_Register.email);
	}

	@Test
	public void Order_01_Create() {

	}

	@Test
	public void Order_02_Search() {

	}

	@Test
	public void Order_03_Update() {

	}

	@Test
	public void Order_04_Delete() {

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
