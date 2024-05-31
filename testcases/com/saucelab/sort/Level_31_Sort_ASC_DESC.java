package com.saucelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.saucelab.LoginPageObject;
import pageObject.saucelab.PageGeneratorManager;
import pageObject.saucelab.ProductPageObject;

public class Level_31_Sort_ASC_DESC extends BaseTest {

	WebDriver driver;

	private LoginPageObject loginPage;
	private ProductPageObject productPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.enterToUserName("standard_user");
		loginPage.enterToPassword("secret_sauce");
		productPage = loginPage.clickToLoginButton();

	}

	@Test
	public void Sort_01_Name() {
		productPage.selectItemInSortDropdown("Name (A to Z)");

		Assert.assertTrue(productPage.isProductNameSortByAscending());

		productPage.selectItemInSortDropdown("Name (Z to A)");

		Assert.assertTrue(productPage.isProductNameSortByDescending());
	}

	@Test
	public void Sort_02_Price() {
		productPage.selectItemInSortDropdown("Price (low to high)");

		Assert.assertTrue(productPage.isProductPriceSortByAscending());

		productPage.selectItemInSortDropdown("Price (high to low)");

		Assert.assertTrue(productPage.isProductPriceSortByDescending());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
