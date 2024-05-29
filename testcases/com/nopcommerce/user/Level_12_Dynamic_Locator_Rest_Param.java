package com.nopcommerce.user;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.*;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class Level_12_Dynamic_Locator_Rest_Param extends BaseTest {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Random random = new Random();
	String email = getEmailAddress();

	HomePageObject homePage;
	LoginPageObject loginPage;
	CustomerPageObject customerPage;
	RegisterPageObject registerPage;
	DownloadableProductPageObject downloadProductPage;
	RewardPointsPageObject rewardPointPage;
	AddressesPageObject addressesPage;
	OrdersPageObject ordersPage;

	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;

	private String userUrl = GlobalConstants.DEV_USER_URL;
	private String adminUrl = GlobalConstants.DEV_ADMIN_URL;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

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

//	@Test
	public void User_02_Switch_Page() {
		homePage = customerPage.userAbleToLogout(driver);

		homePage.openPageUrl(driver, adminUrl);

		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		adminDashboardPage = adminLoginPage.loginAsAdmin(GlobalConstants.DEV_ADMIN_USERNAME, GlobalConstants.DEV_ADMIN_PASSWORD);

		Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));

		adminLoginPage = adminDashboardPage.adminAbleToLogout(driver);

		adminLoginPage.openPageUrl(driver, userUrl);

		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void User_03_Page_Navigation() {

		addressesPage = (AddressesPageObject) customerPage.openDynamicSideBarPage("Addresses");

		ordersPage = (OrdersPageObject) customerPage.openDynamicSideBarPage("Orders");

		customerPage = (CustomerPageObject) ordersPage.openDynamicSideBarPage("Customer info");
	}

	@Test
	public void User_04_Page_Navigation() {

		customerPage.openDynamicSideBarPageByName("Addresses");
		addressesPage = PageGeneratorManager.getAddressesPage(driver);

		customerPage.openDynamicSideBarPageByName("Orders");
		ordersPage = PageGeneratorManager.getOrdersPage(driver);

		ordersPage.openDynamicSideBarPageByName("Customer info");
		customerPage = PageGeneratorManager.getCustomerPage(driver);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
