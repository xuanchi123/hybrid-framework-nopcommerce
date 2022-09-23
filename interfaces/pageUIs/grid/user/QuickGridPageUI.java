package pageUIs.grid.user;

public class QuickGridPageUI {
	public static final String PAGE_BY_PAGE_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGE_BY_PAGE_NUMBER_ACTIVED = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String TEXTBOX_BY_COLUMN_NAME = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String ALL_PAGE_NUMBERS = "xpath=//a[@class='qgrd-pagination-page-link']";
	public static final String ALL_DATA_ROW = "xpath=//tbody/tr";
}
