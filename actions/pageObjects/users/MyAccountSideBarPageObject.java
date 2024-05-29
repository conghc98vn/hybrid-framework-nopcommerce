package pageObjects.users;

import commons.BaseElement;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.users.MyAccountSideBarPageUI;

public class MyAccountSideBarPageObject extends BaseElement {
	WebDriver driver;

	public MyAccountSideBarPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public AddressesPageObject openAddressPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.ADDRESSES_LINK_TEXT);
		clickToElement(driver, MyAccountSideBarPageUI.ADDRESSES_LINK_TEXT);
		return PageGeneratorManager.getAddressesPage(driver);
	}

	public RewardPointsPageObject openRewardPointPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.REWARD_POINTS_LINKTEXT);
		clickToElement(driver, MyAccountSideBarPageUI.REWARD_POINTS_LINKTEXT);
		return PageGeneratorManager.getRewardPointsPage(driver);
	}

	public CustomerPageObject openCustomerInfoPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_LINKTEXT);
		clickToElement(driver, MyAccountSideBarPageUI.CUSTOMER_INFO_LINKTEXT);
		return PageGeneratorManager.getCustomerPage(driver);
	}

	public DownloadableProductPageObject openDownloadableProductPage() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.DOWNLOADABLE_LINK_TEXT);
		clickToElement(driver, MyAccountSideBarPageUI.DOWNLOADABLE_LINK_TEXT);
		return PageGeneratorManager.getDownloadableProductPage(driver);
	}

	public MyAccountSideBarPageObject openDynamicSideBarPage(String pageName) {
		waitForElementClickable(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);

		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getCustomerPage(driver);
		case "Addresses":
			return PageGeneratorManager.getAddressesPage(driver);
		case "Orders":
			return PageGeneratorManager.getOrdersPage(driver);
		case "Reward points":
			return PageGeneratorManager.getRewardPointsPage(driver);
		default:
			new RuntimeException("Sidebar page name incorrect.");
			return null;
		}

	}

	public void openDynamicSideBarPageByName(String pageName) {
		waitForElementClickable(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
	}
}
