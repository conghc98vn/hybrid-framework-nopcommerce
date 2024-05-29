package com.jquery.table;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.jquery.HomePageObject;
import pageObject.jquery.PageGeneratorManager;

public class Level_13_Handle_DataTable extends BaseTest {

	WebDriver driver;

	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {

		driver = getBrowserDriver(browserName, url);

		homePage = PageGeneratorManager.getHomePage(driver);

	}

//	@Test
	public void TC_01_Search() {
		homePage.inputToColumnTextboxByName("Females", "56746000");
		homePage.inputToColumnTextboxByName("Country", "World");
		homePage.inputToColumnTextboxByName("Males", "60681000");
		homePage.inputToColumnTextboxByName("Total", "117427000");
	}

//	@Test
	public void TC_02_Paging() {
		homePage.clickToPageNumber("12");
		Assert.assertTrue(homePage.isPageActiveByNumber("12"));
		homePage.sleepInSecond(1);

		homePage.clickToPageNumber("22");
		Assert.assertTrue(homePage.isPageActiveByNumber("22"));
		homePage.sleepInSecond(1);

	}

//	@Test
	public void TC_03_Displayed() {
		homePage.inputToColumnTextboxByName("Country", "Afghanistan");
		homePage.isRowValuesDisplayed("384187", "Afghanistan", "407124", "791312");
	}

//	@Test
	public void TC_04_Icon_Button() {
		homePage.clickToRowActionByCountryName("Afghanistan", "remove");
	}

//	@Test
	public void TC_05_Get_All_Column_Values() {

		homePage.getAllPageValuesByColumnName("Country");

	}

	@Test
	public void TC_06_Action_By_Index() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");

		homePage.enterToTextboxByColumnmeAndRowIndex("Company", "2", "Test");

		homePage.selectCountryByRowIndex("2", "Hong Kong");
	}

	@AfterClass
	public void afterClass() {
//		quitBrowserDriver();
	}

}
