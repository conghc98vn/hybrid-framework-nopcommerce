package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.users.*;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class Level_09_Page_Navigation extends BaseTest {

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

	@Parameters({ "browser", "userUrl", "adminUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl) {

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
		downloadProductPage = customerPage.openDownloadableProductPage();

		addressesPage = downloadProductPage.openAddressPage();

		rewardPointPage = addressesPage.openRewardPointPage();

		customerPage = rewardPointPage.openCustomerInfoPage();
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
