package com.nopcommerce.user;

import commons.BaseTest;

public class Level_06_Page_Factory_Todo extends BaseTest {

	// to do at Topic 60 K28

//	WebDriver driver;
//	String projectPath = System.getProperty("user.dir");
//	Random random = new Random();
//	String email = "JohnWick" + random.nextInt() + "@gmail.com";
//
//	HomePageObject homePage;
//	LoginPageObject loginPage;
//	CustomerPageObject customerPage;
//	RegisterPageObject registerPage;
//
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		driver = getBrowserDriver(browserName);
//	}
//
//	@Test
//	public void Register_01_Empty_Data() {
//
//		homePage = new HomePageObject(driver);
//
//		homePage.clickToRegisterLink();
//
//		registerPage = new RegisterPageObject(driver);
//
//		registerPage.clickToRegisterButton();
//
//		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
//		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
//		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
//		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
//
//	}
//
//	@Test
//	public void Register_02_Invalid_Email() {
//		registerPage.clickToHomePageLogo();
//
//		homePage = new HomePageObject(driver);
//
//		homePage.clickToRegisterLink();
//
//		registerPage = new RegisterPageObject(driver);
//
//		registerPage.enterToFirstNameTextox("John");
//		registerPage.enterToLastNameTextbox("Wick");
//		registerPage.enterToEmailTextbox("john@wick@gmail.com");
//		registerPage.enterToPasswordTextbox("123456");
//		registerPage.enterToConfirmPasswordTextbox("123456");
//
//		registerPage.clickToRegisterButton();
//
//		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Please enter a valid email address.");
//	}
//
//	@Test
//	public void Register_03_Invalid_Password() {
//		registerPage.clickToHomePageLogo();
//
//		homePage = new HomePageObject(driver);
//
//		homePage.clickToRegisterLink();
//
//		registerPage = new RegisterPageObject(driver);
//
//		registerPage.enterToFirstNameTextox("John");
//		registerPage.enterToLastNameTextbox("Wick");
//		registerPage.enterToEmailTextbox("johnwick@gmail.com");
//		registerPage.enterToPasswordTextbox("123");
//		registerPage.enterToConfirmPasswordTextbox("123456");
//
//		registerPage.clickToRegisterButton();
//
//		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "The password and confirmation password do not match.");
//	}
//
//	@Test
//	public void Register_04_Incorrect_Confirm_Password() {
//
//		registerPage.clickToHomePageLogo();
//
//		homePage = new HomePageObject(driver);
//
//		homePage.clickToRegisterLink();
//
//		registerPage = new RegisterPageObject(driver);
//
//		registerPage.enterToFirstNameTextox("John");
//		registerPage.enterToLastNameTextbox("Wick");
//		registerPage.enterToEmailTextbox("johnwick@gmail.com");
//		registerPage.enterToPasswordTextbox("123456");
//		registerPage.enterToConfirmPasswordTextbox("123");
//
//		registerPage.clickToRegisterButton();
//
//		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "The password and confirmation password do not match.");
//	}
//
//	@Test
//	public void Register_05_Success() {
//		registerPage.clickToHomePageLogo();
//
//		homePage = new HomePageObject(driver);
//
//		homePage.clickToRegisterLink();
//
//		registerPage = new RegisterPageObject(driver);
//
//		registerPage.enterToFirstNameTextox("John");
//		registerPage.enterToLastNameTextbox("Wick");
//		registerPage.enterToEmailTextbox(email);
//		registerPage.enterToPasswordTextbox("123123");
//		registerPage.enterToConfirmPasswordTextbox("123123");
//
//		registerPage.clickToRegisterButton();
//
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
//
//		registerPage.clickToHomePageLogo();
//
//		homePage = new HomePageObject(driver);
//
//		homePage.clickToLogoutLink();
//
//		homePage.clickToLoginLink();
//
//		loginPage = new LoginPageObject(driver);
//
//		loginPage.enterToEmailTextbox(email);
//		loginPage.enterToPasswordTextbox("123123");
//		loginPage.clickToLoginButton();
//
//		homePage = new HomePageObject(driver);
//
//		homePage.clickToMyAccountLink();
//		customerPage = new CustomerPageObject(driver);
//
//		assertEquals(customerPage.getFirstNameAttributeValue(), "John");
//		assertEquals(customerPage.getLastNameAttributeValue(), "Wick");
//		assertEquals(customerPage.getEmailAttributeValue(), email);
//	}
//
//	@AfterClass
//	public void afterClass() {
//		quitBrowserDriver();
//	}

}
