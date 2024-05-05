package pageUI.jquery;

public class HomePageUI {
	public static final String COLUMN_TEXTBOX_BY_NAME = "XPath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String PAGE_LINK_BY_NUMBER = "XPath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGE_LINK_ACTIVE_BY_NUMBER = "XPath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String DYNAMIC_ROW_VALUES = "Xpath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String ROW_ACTION_BY_COUNTRY_NAME = "Xpath=//td[text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class, '%s')]";
}
