package pageUI.jquery;

public class UploadPageUI {
	public static final String FILE_LOADED_BY_NAME = "xpath=//p[@class='name' and text()='%s']";
	public static final String MULTIPLE_START_BUTTON = "xpath=//td/button[@class='btn btn-primary start']";
	public static final String FILE_UPLOADED_BY_NAME = "xpath=//p[@class='name']/a[text()='%s']";

	public static final String SPIN_BORDER_ICON_AT_MAIN_CONTENT = "xpath=//div[@class='spinner-border']";
	public static final String SPIN_BORDER_ICON_AT_MAIN_UPLOAD = "xpath=//div[@class='spinner-border']";
	public static final String MULTIPLE_PROGRESS_BAR_ICON = "xpath=//div[contains(@class, 'progress-bar')]";
	public static final String UPLOADED_SUCCESS_MESSAGE = "xpath=//div[@id='mainUpload']//div[contains(@class, 'border-success')]";
	public static final String UPLOADED_SUCCESS_LINK = "xpath=//div[contains(@class, 'mainUploadSuccessLink')]//a";
	public static final String CONTENT_TABLE = "xpath=//div[@id='filesContentTableContent']";
	public static final String DOWNLOAD_BUTTON_BY_FILE_NAME = "xpath=//span[text()='%s']//ancestor::div[contains(@class,'contentId')]//span[text()='Download']//ancestor::button";
	public static final String PLAY_BUTTON_BY_FILE_NAME = "xpath=//span[text()='%s']//ancestor::div[contains(@class,'contentId')]//span[text()='Play']//ancestor::button";
}
