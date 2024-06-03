package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Level_31_Environtment_01_Parameter_Name extends BaseTest {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Random random = new Random();

	@Parameters({ "browser", "server" })
	@BeforeClass
	public void beforeClass(String browserName, String serverName) {
		driver = getBrowserDriverEnvironment(browserName, serverName);
		System.out.println(serverName);
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
