package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.HomePageObject;
import pageObjects.users.SearchPageObject;

public class Level_30_Test_Not_Dependencies extends BaseTest {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	HomePageObject homePage;
	SearchPageObject searchPage;

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.openPageUrl(driver, "https://demo.nopcommerce.com/");

		searchPage = homePage.clickToSearchLink();

	}

	@Test
	public void TC_01_Search_By_EmtyData() {
		searchPage.enterToSearchTextbox("");
		searchPage.clickToSearchButton();
	}

	@Test
	public void TC_02_Search_By_Product_Name_Not_Exist() {
		searchPage.enterToSearchTextbox("Macbook Pro 2050");
		searchPage.clickToSearchButton();
	}

	@Test
	public void TC_03_Search_By_Contains_Product_Name() {
		searchPage.enterToSearchTextbox("Lenovo");
		searchPage.clickToSearchButton();
	}

	@Test
	public void TC_04_Search_By_Product_Name() {
		searchPage.enterToSearchTextbox("ThinkPad X1 Carbon");
		searchPage.clickToSearchButton();
	}

	@AfterMethod
	public void afterMethod() {
		closeBrowserDriver();
	}

}
