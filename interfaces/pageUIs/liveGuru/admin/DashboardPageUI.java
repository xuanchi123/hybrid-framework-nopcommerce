package pageUIs.liveGuru.admin;

public class DashboardPageUI {
	public static final String CLOSE_POPUP_ICON = "xpath=//div[@id='message-popup-window']//span[text()='close']";
	public static final String TEXT_BOX_NAME = "css=input[name='name']";
	public static final String TEXT_BOX_EMAIL = "css=input[name='email']";
	public static final String BUTTON_SEARCH = "css=button[title='Search']";
	public static final String LOADING_ICON = "css=p#loading_mask_loader";
	public static final String NUMBER_OF_CUSTOMER_ROWS = "xpath=//table[@id='customerGrid_table']/tbody/tr";
	public static final String CUSTOMER_DATA_BY_ROW_ID_AND_NAME_AND_EMAIL = "xpath=//tbody/tr[%s]/td[contains(text(),'%s')]/following-sibling::td[contains(text(),'%s')]";
}
