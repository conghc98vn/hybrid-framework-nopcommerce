package com.facebook.home;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_20_Element_Undisplayed extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Home_01_Element_Displayed() {
		homePage.clickToCreateNewAccountButton();

		verifyTrue(homePage.isFirstNameTextboxDisplayed());
		verifyTrue(homePage.isSurNameTextboxDisplayed());
		verifyTrue(homePage.isEmailTextboxDisplayed());
		verifyTrue(homePage.isPasswordTextboxDisplayed());

		homePage.enterToFirstNameTextbox("John");
		homePage.enterToSurNameTextbox("Wick");
		homePage.enterToEmailTextbox("johnwick1998vn@gmail.com");
		homePage.sleepInSecond(2);

		// Recheck-manual on Facebook
//		log.info("Verify Confirm Email textbox is displayed");
//		verifyTrue(homePage.isConfirmEmailTextboxDisplayed());
	}

	@Test
	public void Home_02_Element_Undisplayed_HTML() {
		homePage.enterToEmailTextbox("");
		homePage.sleepInSecond(2);

		log.info("Verify Confirm Email textbox is not displayed");
		verifyFalse(homePage.isConfirmEmailTextboxDisplayed());
	}

//	@Test
	public void Home_03_Element_Unuisplayed_Not_In_HTML_01() {
		homePage.clickToCloseSignUpPopup();

		log.info("Verify FirstName textbox is not displayed");
		verifyFalse(homePage.isFirstNameTextboxDisplayed());

		log.info("Verify SurName textbox is not displayed");
		verifyFalse(homePage.isSurNameTextboxDisplayed());

		log.info("Verify Email textbox is not displayed");
		verifyFalse(homePage.isEmailTextboxDisplayed());

		log.info("Verify Password textbox is not displayed");
		verifyFalse(homePage.isPasswordTextboxDisplayed());
	}

	@Test
	public void Home_03_Element_Unuisplayed_Not_In_HTML_02() {
		homePage.clickToCloseSignUpPopup();

		log.info("Verify FirstName textbox is not displayed");
		verifyTrue(homePage.isFirstNameTextboxUndisplayed());

		log.info("Verify SurName textbox is not displayed");
		verifyTrue(homePage.isSurNameTextboxUndisplayed());

		log.info("Verify Email textbox is not displayed");
		verifyTrue(homePage.isEmailTextboxUndisplayed());

		log.info("Verify Password textbox is not displayed");
		verifyTrue(homePage.isPasswordTextboxUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
