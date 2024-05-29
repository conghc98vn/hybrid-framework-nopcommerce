package com.jquery.upload;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.jquery.HomePageObject;
import pageObject.jquery.PageGeneratorManager;
import pageObject.jquery.UploadPageObject;

public class Level_14_Upload_File extends BaseTest {

	WebDriver driver;

	HomePageObject homePage;
	UploadPageObject uploadPage;

	String hueCity = "hue.jpg";
	String nhatrangCity = "nhatrang.jpg";
	String quynhonCity = "quynhon.jpg";

	String[] fileNames = { hueCity, nhatrangCity, quynhonCity };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {

		driver = getBrowserDriver(browserName, url);

		uploadPage = PageGeneratorManager.getUploadPage(driver);

	}

//	@Test
	public void TC_01_Upload_Single_File() {
		uploadPage.uploadMultipleFiles(driver, hueCity);
		uploadPage.sleepInSecond(2);

		uploadPage.uploadMultipleFiles(driver, nhatrangCity);
		uploadPage.sleepInSecond(2);

		uploadPage.uploadMultipleFiles(driver, quynhonCity);
		uploadPage.sleepInSecond(2);

		Assert.assertTrue(uploadPage.isFileLoadedSuccess(hueCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(nhatrangCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(quynhonCity));

		uploadPage.clickStartButtonOnEachFile();

		Assert.assertTrue(uploadPage.isFileUploadedSuccess(hueCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(nhatrangCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(quynhonCity));
	}

//	@Test
	public void TC_02_Upload_Multile_File() {
		uploadPage.refreshCurrentPage(driver);
		uploadPage.uploadMultipleFiles(driver, fileNames);
	}

	@Test
	public void TC_03_Go_File_IO() {
		uploadPage.openPageUrl(driver, "https://gofile.io/uploadFiles");

		Assert.assertTrue(uploadPage.isLoadingIconAtMainContentDisapear());

		uploadPage.uploadMultipleFiles(driver, fileNames);

		Assert.assertTrue(uploadPage.isLoadingIconAtMainUploadDisapear());

		Assert.assertTrue(uploadPage.isMultipleProgressBarDisapear());

		Assert.assertTrue(uploadPage.isSuccessMessageDisplayed("Your files have been successfully uploaded"));

		uploadPage.clickToSuccessLink();

		Assert.assertTrue(uploadPage.isContentTableDisplayed());

		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(hueCity));
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(nhatrangCity));
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(quynhonCity));

		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(hueCity));
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(nhatrangCity));
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(quynhonCity));

	}

	@AfterClass
	public void afterClass() {
//		quitBrowserDriver();
	}

}
