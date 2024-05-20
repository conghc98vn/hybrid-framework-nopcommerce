package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.AddressesPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadableProductPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.RewardPointsPageObject;

public class Level_10_Switch_Site_Url extends BaseTest {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Random random = new Random();
	String email = "JohnWick" + random.nextInt() + "@gmail.com";

	HomePageObject homePage;
	LoginPageObject loginPage;
	CustomerPageObject customerPage;
	RegisterPageObject registerPage;
	DownloadableProductPageObject downloadProductPage;
	RewardPointsPageObject rewardPointPage;
	AddressesPageObject addressesPage;

	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;

	private String userUrl, adminUrl;

	@Parameters({ "browser", "userUrl", "adminUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl) {

		this.userUrl = userUrl;
		this.adminUrl = adminUrl;

		driver = getBrowserDriver(browserName, userUrl);

		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01() {

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

	@Test
	public void User_02_Switch_Page() {
		homePage = customerPage.userAbleToLogout(driver);

		homePage.openPageUrl(driver, adminUrl);

		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		adminDashboardPage = adminLoginPage.loginAsAdmin("admin@yourstore.com", "admin");

		Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));

		adminLoginPage = adminDashboardPage.adminAbleToLogout(driver);

		adminLoginPage.openPageUrl(driver, userUrl);

		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
