package com.nopcommerce.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_01_Register {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Random random = new Random();
	String email = "JohnWick" + random.nextInt() + "@gmail.com";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		driver = new ChromeDriver();

//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

//	@Test
	public void Register_01_Empty_Data() {

		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//button[@id='register-button']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='FirstName-error']")).getText(), "First name is required.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='LastName-error']")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(), "Password is required.");
	}

//	@Test
	public void Register_02_Invalid_Email() {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Wick");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("john@wick@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");

		driver.findElement(By.xpath("//button[@id='register-button']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Please enter a valid email address.");
	}

//	@Test
	public void Register_03_Invalid_Password() {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Wick");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("johnwick@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123123");

		driver.findElement(By.xpath("//button[@id='register-button']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(), "The password and confirmation password do not match.");
	}

//	@Test
	public void Register_04_Incorrect_Confirm_Password() {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Wick");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("johnwick@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123123");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123");

		driver.findElement(By.xpath("//button[@id='register-button']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(), "The password and confirmation password do not match.");

	}

	@Test
	public void Register_05_Success() {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Wick");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123123");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123123");

		driver.findElement(By.xpath("//button[@id='register-button']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
