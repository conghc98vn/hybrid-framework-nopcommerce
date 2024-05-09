package pageUIs.users;

public class BaseElementUI {
	public static final String USER_LOGOUT_LINK = "XPath=//a[@class='ico-logout']";
	public static final String ADMIN_LOGOUT_LINK = "XPath=//a[text()='Logout']/parent::li";

	public static final String UPLOAD_FILE_TYPE = "xpath=//input[@type='file']";
	public static final String HOMEPAGE_LOGO_IMAGE = "XPath=//div[@class='header-logo']//img";
	public static final String DYNAMIC_HEADER_LINK_BY_NAME = "xpath=//div[@class='header-links']//a[contains(., '%s')]";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_TEXT_ERROR_MSG_BY_ID = "xpath=//span[@id='%s-error']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "XPath=//input[@id='%s']";
}