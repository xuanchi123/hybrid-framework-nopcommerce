package commons;

import java.io.File;

public class GlobalConstants {
	public static final String NOPCOMMERCE_PORTAL_DEV_URL = "https:/demo.nopcommerce.com/";
	public static final String NOPCOMMERCE_ADMIN_DEV_URL = "https:/admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
	public static final String NOPCOMMERCE_PORTAL_TESING_URL = "https:/demo.nopcommerce.com/";
	public static final String NOPCOMMERCE_ADMIN_TESTING_URL = "https:/admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator ;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLog";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGScreenShots" + File.separator;
	public static final String ALLURE_JSON = PROJECT_PATH + File.separator + "allure-json" + File.separator;
	public static final String EXTENT_PATH = PROJECT_PATH + File.separator + "ExtentReportV2" + File.separator;
	public static final String EXTENT_V5_PATH = PROJECT_PATH + File.separator + "ExtentReportV5" + File.separator;
	public static final String DB_DEV_URL = "32.18.252.185:9860";
	public static final String DB_DEV_USER = "automationfc";
	public static final String DB_DEV_PASS = "P@ssw0rk1!";
	public static final int SHORT_TIMEOUT = 5;
	public static final int LONG_TIMEOUT = 30;
	public static final int RETRY_TEST_FAIL = 3;
	public static final String LIVE_GURU_PORTAL_URL = "http://live.techpanda.org/";
	public static final String LIVE_GURU_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin/customer/";
	public static final String JAVA_VERSION = System.getProperty("java.version");
}
