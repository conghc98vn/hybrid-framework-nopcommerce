package commons;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.HomePageObject;
import pageUIs.users.BaseElementUI;

public class BasePage {

	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void fowardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void acceptToAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelToAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String valueToSendkey) {
		waitForAlertPresence(driver).sendKeys(valueToSendkey);
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());
	}

	public void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				sleepInSecond(2);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			driver.switchTo().window(id);
			if (driver.getTitle().equals(expectedTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutExpectedID(WebDriver driver, String expectedID) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			if (!id.equals(expectedID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(expectedID);
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public By getByLocator(String locatorValue) {

		By by = null;

		if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("Xpath=") || locatorValue.startsWith("XPATH=") || locatorValue.startsWith("XPath=")) {
			by = By.xpath(locatorValue.substring(6));
		} else if (locatorValue.startsWith("css=") || locatorValue.startsWith("Css=") || locatorValue.startsWith("CSS=")) {
			by = By.cssSelector(locatorValue.substring(4));
		} else if (locatorValue.startsWith("id=") || locatorValue.startsWith("Id=") || locatorValue.startsWith("ID=")) {
			by = By.cssSelector(locatorValue.substring(4));
		} else if (locatorValue.startsWith("name=") || locatorValue.startsWith("Name=") || locatorValue.startsWith("NAME=")) {
			by = By.cssSelector(locatorValue.substring(4));
		} else if (locatorValue.startsWith("class=") || locatorValue.startsWith("Class=") || locatorValue.startsWith("CLASS=")) {
			by = By.cssSelector(locatorValue.substring(4));
		} else if (locatorValue.startsWith("tagname=") || locatorValue.startsWith("Tagname=") || locatorValue.startsWith("TAGNAME=")) {
			by = By.cssSelector(locatorValue.substring(4));
		} else {
			throw new RuntimeException("Locator type is not valid ! Recheck Locator");
		}

		return by;
	}

	public By getByXpath(String locatorValue) {
		return By.xpath(locatorValue);
	}

	public String getDynamicLocator(String locator, String... restParams) {
		return String.format(locator, (Object[]) restParams);
	}

	public WebElement getWebElement(WebDriver driver, String locatorValue) {
		return driver.findElement(getByLocator(locatorValue));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locatorValue) {
		return driver.findElements(getByLocator(locatorValue));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locatorValue, String... restParams) {
		return driver.findElements(getByLocator(getDynamicLocator(locatorValue, restParams)));
	}

	public void clickToElement(WebDriver driver, String locatorValue) {
		getWebElement(driver, locatorValue).click();
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public void clickToElement(WebDriver driver, String locatorValue, String... restParams) {
		getWebElement(driver, getDynamicLocator(locatorValue, restParams)).click();
	}

	public void sendkeyToElement(WebDriver driver, String locatorValue, String valueToSend) {
		getWebElement(driver, locatorValue).clear();
		getWebElement(driver, locatorValue).sendKeys(valueToSend);
	}

	public void sendkeyToElement(WebDriver driver, String locatorValue, String valueToSend, String... restParams) {
		getWebElement(driver, getDynamicLocator(locatorValue, restParams)).clear();
		getWebElement(driver, getDynamicLocator(locatorValue, restParams)).sendKeys(valueToSend);
	}

	public void selectDropdown(WebDriver driver, String locatorValue, String itemText) {
		new Select(getWebElement(driver, locatorValue)).selectByVisibleText(itemText);
	}

	public void selectDropdown(WebDriver driver, String locatorValue, String itemText, String... restParams) {
		new Select(getWebElement(driver, getDynamicLocator(locatorValue, restParams))).selectByVisibleText(itemText);
	}

	public String getFirstSelectedOptionText(WebDriver driver, String locatorValue) {
		return new Select(getWebElement(driver, locatorValue)).getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorValue) {
		return new Select(getWebElement(driver, locatorValue)).isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String xpathParent, String xpathChild, String expectedText) {
		clickToElement(driver, xpathParent);
		sleepInSecond(1);

		List<WebElement> allItems;

		allItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(xpathChild)));

		for (WebElement tempElement : allItems) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tempElement);
			sleepInSecond(2);

			if (tempElement.getText().equals(expectedText)) {
				tempElement.click();
				sleepInSecond(2);
				break;
			}
		}
	}

	public String getElementText(WebDriver driver, String locatorValue) {
		return getWebElement(driver, locatorValue).getText();
	}

	public String getElementText(WebDriver driver, String locatorValue, String... restParams) {
		return getWebElement(driver, getDynamicLocator(locatorValue, restParams)).getText();
	}

	public String getElementAttribute(WebDriver driver, String locatorValue, String attributeName) {
		return getWebElement(driver, locatorValue).getAttribute(attributeName);
	}

	public String getElementAttribute(WebDriver driver, String locatorValue, String attributeName, String... restParams) {
		return getWebElement(driver, getDynamicLocator(locatorValue, restParams)).getAttribute(attributeName);
	}

	public String getElementCSSValue(WebDriver driver, String locatorValue, String propertyName) {
		return getWebElement(driver, locatorValue).getCssValue(propertyName);
	}

	public String getHexaColorByRGBA(String rgbColor) {
		return Color.fromString(rgbColor).asHex().toUpperCase();
	}

	public int getListElementSize(WebDriver driver, String locatorValue) {
		return getListWebElement(driver, locatorValue).size();
	}

	public int getListElementSize(WebDriver driver, String locatorValue, String... restParams) {
		return getListWebElement(driver, getDynamicLocator(locatorValue, restParams)).size();
	}

	public void checkToCheckboxRadio(WebDriver driver, String locatorValue) {
		if (!getWebElement(driver, locatorValue).isSelected()) {
			getWebElement(driver, locatorValue).click();
		}
	}

	public void unCheckToCheckboxRadio(WebDriver driver, String locatorValue) {
		if (getWebElement(driver, locatorValue).isSelected()) {
			getWebElement(driver, locatorValue).click();
		}
	}

	public void setImplicitWait(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}

	public boolean isElementUndisplayed(WebDriver driver, String locatorValue) {
		setImplicitWait(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, locatorValue);
		setImplicitWait(driver, longTimeout);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementUndisplayed(WebDriver driver, String locatorValue, String... restStrings) {
		System.out.println("Start time = " + new Date().toString());
		List<WebElement> elements = getListWebElement(driver, getDynamicLocator(locatorValue, restStrings));

		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			System.out.println("Eng time = " + new Date().toString());
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/ displayed");
			System.out.println("Eng time = " + new Date().toString());
			return true;
		} else {
			System.out.println("Element in DOM and visible");
			return false;
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorValue) {
		return getWebElement(driver, locatorValue).isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorValue, String... restStrings) {
		return getWebElement(driver, getDynamicLocator(locatorValue, restStrings)).isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String locatorValue) {
		return getWebElement(driver, locatorValue).isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String locatorValue) {
		return getWebElement(driver, locatorValue).isEnabled();
	}

	public void switchToFrame(WebDriver driver, String locatorValue) {
		driver.switchTo().frame(getWebElement(driver, locatorValue));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locatorValue) {
		new Actions(driver).moveToElement(getWebElement(driver, locatorValue)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locatorValue) {
		new Actions(driver).doubleClick(getWebElement(driver, locatorValue)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locatorValue) {
		new Actions(driver).contextClick(getWebElement(driver, locatorValue)).perform();
	}

	public void dragAndDropToElement(WebDriver driver, String sourceXpath, String targetXpath) {
		new Actions(driver).dragAndDrop(getWebElement(driver, sourceXpath), getWebElement(driver, targetXpath)).perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String locatorValue, Keys key) {
		new Actions(driver).sendKeys(getWebElement(driver, locatorValue), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
		sleepInSecond(3);
	}

	public void hightlightElement(WebDriver driver, String locatorValue) {
		WebElement element = getWebElement(driver, locatorValue);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorValue) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locatorValue));
		sleepInSecond(3);
	}

	public void scrollToElementOnTop(WebDriver driver, String locatorValue) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorValue));
	}

	public void scrollToElementOnDown(WebDriver driver, String locatorValue) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locatorValue));
	}

	public void setAttributeInDOM(WebDriver driver, String locatorValue, String attributeName, String attributeValue) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getWebElement(driver, locatorValue));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorValue, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorValue));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locatorValue, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locatorValue));
	}

	public String getAttributeInDOM(WebDriver driver, String locatorValue, String attributeName) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver, locatorValue));
	}

	public String getElementValidationMessage(WebDriver driver, String locatorValue) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorValue));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorValue) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver, locatorValue));
		return status;
	}

	public boolean isPageLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_PATH;

		String fullFileName = "";

		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, BaseElementUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
	}

	public void waitForElementVisible(WebDriver driver, String locatorValue) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorValue)));
	}

	public void waitForElementVisible(WebDriver driver, String locatorValue, String... restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locatorValue, restParams))));
	}

	public void waitForListElementVisible(WebDriver driver, String locatorValue) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorValue)));
	}

	public void waitForListElementVisible(WebDriver driver, String locatorValue, String... restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicLocator(locatorValue, restParams))));
	}

	public void waitForElementClickable(WebDriver driver, String locatorValue) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(locatorValue)));
	}

	public void waitForElementClickable(WebDriver driver, String locatorValue, String... restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locatorValue, restParams))));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(element));
	}

	public boolean waitForElementInvisible(WebDriver driver, String locatorValue) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorValue)));
	}

	public boolean waitForElementInvisible(WebDriver driver, String locatorValue, String... restParams) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicLocator(locatorValue, restParams))));
	}

	public HomePageObject userAbleToLogout(WebDriver driver) {
		waitForElementClickable(driver, BaseElementUI.USER_LOGOUT_LINK);
		clickToElement(driver, BaseElementUI.USER_LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public AdminLoginPageObject adminAbleToLogout(WebDriver driver) {
		waitForElementClickable(driver, BaseElementUI.ADMIN_LOGOUT_LINK);
		clickToElement(driver, BaseElementUI.ADMIN_LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;

}
