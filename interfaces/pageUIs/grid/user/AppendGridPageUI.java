package pageUIs.grid.user;

public class AppendGridPageUI {
	public static final String COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//td[@class='ui-widget-header' and text()='%s']/preceding-sibling::td";
	public static final String TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]/select";
	public static final String CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String BUTTON_LOAD_DATA = "css=button#btnLoad";
	public static final String ICON_NAME_BY_ROW_INDEX = "xpath=//tbody/tr[%s]/td[8]//button[@title='%s']";
}
