package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import utilities.EnvironmentConfig;

public class Level_31_Environtment_04_Owner extends BaseTest {

	WebDriver driver;

	private EnvironmentConfig environmentConfig;

	@Parameters({ "browser", "server" })
	@BeforeClass
	public void beforeClass(String browserName, String serverName) {
		ConfigFactory.setProperty("server", serverName);
		environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

		driver = getBrowserDriver(browserName, environmentConfig.appUrl());
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
