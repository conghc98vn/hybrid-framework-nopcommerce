package pageObject.saucelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saucelab.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String sortItem) {
		waitForElementClickable(driver, ProductPageUI.SORT_DROPDOWN);
		selectDropdown(driver, ProductPageUI.SORT_DROPDOWN, sortItem);
	}

	public boolean isProductNameSortByAscending() {
		// Bước 1:Lấy hết Product Name lưu lại
		List<WebElement> allProductNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

		List<String> actualProductName = new ArrayList<String>();

		for (WebElement productName : allProductNameText) {
			actualProductName.add(productName.getText());
		}

		// Bước 2: Clone data từ bước 1 ra thành 1 dữ liệu mới
		List<String> expectedProductName = new ArrayList<String>();
		for (String productName : actualProductName) {
			expectedProductName.add(productName);
		}

		// Bước 3: Cho sort dữ liệu ở bước 2
		Collections.sort(expectedProductName);
		// Default: Ascending

		// Bước 4: Verify dữ liệu trước và sau khi sort
		return actualProductName.equals(expectedProductName);
	}

	public boolean isProductNameSortByDescending() {
		// Bước 1:Lấy hết Product Name lưu lại
		List<WebElement> allProductNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

		List<String> actualProductName = new ArrayList<String>();

		for (WebElement productName : allProductNameText) {
			actualProductName.add(productName.getText());
		}

		// Bước 2: Clone data từ bước 1 ra thành 1 dữ liệu mới
		List<String> expectedProductName = new ArrayList<String>();
		for (String productName : actualProductName) {
			expectedProductName.add(productName);
		}

		// Bước 3: Cho sort dữ liệu ở bước 2
		Collections.sort(expectedProductName);
		Collections.reverse(expectedProductName);
		// Default: Ascending

		// Bước 4: Verify dữ liệu trước và sau khi sort
		return actualProductName.equals(expectedProductName);
	}

	public boolean isProductPriceSortByAscending() {
		// Bước 1:Lấy hết Product Name lưu lại
		List<WebElement> allProductPriceText = getListWebElement(driver, ProductPageUI.PRICE_TEXT);

		List<Float> actualPriceText = new ArrayList<Float>();

		for (WebElement productPrice : allProductPriceText) {
			actualPriceText.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		// Bước 2: Clone data từ bước 1 ra thành 1 dữ liệu mới
		List<Float> expectedPriceText = new ArrayList<Float>();
		for (Float productPrice : actualPriceText) {
			expectedPriceText.add(productPrice);
		}

		// Bước 3: Cho sort dữ liệu ở bước 2
		Collections.sort(expectedPriceText);
		// Default: Ascending

		// Bước 4: Verify dữ liệu trước và sau khi sort
		return actualPriceText.equals(expectedPriceText);
	}

	public boolean isProductPriceSortByDescending() {
		// Bước 1:Lấy hết Product Name lưu lại
		List<WebElement> allProductPriceText = getListWebElement(driver, ProductPageUI.PRICE_TEXT);

		List<Float> actualPriceText = new ArrayList<Float>();

		for (WebElement productPrice : allProductPriceText) {
			actualPriceText.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		// Bước 2: Clone data từ bước 1 ra thành 1 dữ liệu mới
		List<Float> expectedPriceText = new ArrayList<Float>();
		for (Float productPrice : actualPriceText) {
			expectedPriceText.add(productPrice);
		}

		// Bước 3: Cho sort dữ liệu ở bước 2
		Collections.sort(expectedPriceText);
		Collections.reverse(expectedPriceText);
		// Default: Ascending

		// Bước 4: Verify dữ liệu trước và sau khi sort
		return actualPriceText.equals(expectedPriceText);
	}
}
