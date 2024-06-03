package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import utilities.PropertiesConfig;

public class Level_31_Environtment_03_Java_Properties extends BaseTest {

	WebDriver driver;

	PropertiesConfig propertiesConfig;

	@Parameters({ "browser", "server" })
	@BeforeClass
	public void beforeClass(String browserName, String serverName) {
		propertiesConfig = PropertiesConfig.getProperties(serverName);
		driver = getBrowserDriver(browserName, propertiesConfig.getApplicationUrl());
	}

	@Test
	public void TC_01_Register_Fail(Method method) {
	}

	@Test
	public void TC_02_Register_Pass(Method method) {
	}

	@Test
	public void TC_03_Login(Method method) {
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}