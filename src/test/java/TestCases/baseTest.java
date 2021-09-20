package TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.listeners.TestJiraListener;

import Functionality.PageUserManagement;
import Functionality.baseClass;
import junit.framework.Assert;

import java.util.logging.Level;

@Listeners(TestJiraListener.class)
public class baseTest extends baseClass {

	PageUserManagement obj_usr;
	
	protected static Properties config = new Properties();
	public static WebDriver driver;
//	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	public static String username, password, baseUrl, automaticIssueCreation, jiraUrl, jiraPassword, jiraUsername,
			Project,Language;

	int dd, mm, yyyy;
	String mnth;

	HashMap<Integer, String> hm = new HashMap<Integer, String>();
	protected String pdfFileName = getAlphaNumericString() + ".pdf";
	protected String filePath = System.getProperty("user.dir");

	By accept_cookie_btn = By.id("psGotItBtn");
	By cookie_btn_frame = By.id("ps-nvm-frame");
	By img_dd_ProfileMenu = By.className("up-down-arrow");
	By currentPsd = By.xpath("//input[@placeholder='Enter Current Password']");
	By newPsd = By.xpath("//input[@placeholder='Enter New Password']");
	By reenterNewPsd = By.xpath("//input[@placeholder='Re-enter New Password']");
	By saveBtn = By.xpath("//button[text()='Save and Proceed']");
	public By dashboard = By.id("ic_dashboard");
	public By sendmoney = By.id("ic_sendmoney");
	public By receivemoney = By.id("ic_receive_money");
	public By creditAndBalance = By.id("ic_credit_and_balance");
	public By txnmonitor = By.id("ic_transaction_monitor");
	public By needhelp = By.xpath("(//*[@id='ic_contact_us'])[1]");
	public By infodocs = By.xpath("(//*[@id='ic_contact_us'])[2]");
	public By Profile = By.xpath("//img[@alt='userprofile']");
	public By UserManagement = By.xpath("//img[@alt='usermgmt']");
	public By Settings = By.xpath("//img[@alt='settings']");
	public By Logout = By.xpath("//img[@alt='logout']");

	public void GoToMenu(By menuElement) throws InterruptedException {
		try {

			System.out.println("In Go to Menu");
			Thread.sleep(10000);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(menuElement)));
			driver.findElement(menuElement).click();
			Thread.sleep(5000);
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public baseTest() {
		try {
			config.load(new FileInputStream("src/test/resources/config.properties"));
			baseUrl = config.getProperty("baseUrl");
			password = config.getProperty("password");
			username = config.getProperty("username");
			automaticIssueCreation = config.getProperty("automaticIssueCreation");
			jiraUrl = config.getProperty("jiraUrl");
			jiraUsername = config.getProperty("jiraUsername");
			jiraPassword = config.getProperty("jiraPassword");
			Project = config.getProperty("Project");
			Language = config.getProperty("Language");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setNewPsd(String currentPassword, String newPassword, String reenterNewPassword) {
		try {
			explicitWait(driver, currentPsd);
			driver.findElement(currentPsd).sendKeys(currentPassword);
			driver.findElement(newPsd).sendKeys(newPassword);
			driver.findElement(reenterNewPsd).sendKeys(reenterNewPassword);
			driver.findElement(saveBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@BeforeTest(alwaysRun = true)
	public void initTestSuite() throws IOException {
		Properties config = new Properties();
		DesiredCapabilities dr = null;

		System.out.println("i am in before test");

		String path = System.getProperty("user.dir");
		System.out.println("Chromedriver path = " + path);
		System.setProperty("webdriver.chrome.driver", path + "//lib//chromedriver.exe");

		ChromeOptions optionsChrome = new ChromeOptions();
		optionsChrome.addArguments("start-maximized");
		optionsChrome.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		optionsChrome.setExperimentalOption("prefs", prefs);
		optionsChrome.addArguments("disable-infobars"); // disabling infobars
		optionsChrome.addArguments("--disable-extensions"); // disabling extensions
		optionsChrome.addArguments("--disable-gpu"); // applicable to windows os only
		optionsChrome.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		optionsChrome.addArguments("--no-sandbox"); // Bypass OS security model
		optionsChrome.addArguments("--allow-file-access-from-files", "--allow-file-access",
				"--use-fake-ui-for-media-stream",
				"--use-file-for-fake-audio-capture=" + System.getProperty("user.dir") + "/Images/Example.wav",
				"--use-fake-device-for-media-stream", "--ignore-certificate-errors");
		// optionsChrome.addArguments("--headless");
		// optionsChrome.addArguments("--disable-setuid-sandbox");
		// optionsChrome.addArguments("--remote-debugging-port=9222");

		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		optionsChrome.setCapability("goog:loggingPrefs", logPrefs);

		dr = new DesiredCapabilities();

		System.out.println("Chrome browser capabilities initialise");

		dr.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		dr.setCapability(ChromeOptions.CAPABILITY, optionsChrome);

		System.out.println("Chrome browser options set");

		driver = new ChromeDriver(dr);
		driver.get(baseUrl);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void acceptCookies() {
		try {
			driver.switchTo().frame(driver.findElement(cookie_btn_frame));
			if (driver.findElement(accept_cookie_btn).isDisplayed()) {
				System.out.println("Accept cookie bar is display.");
				driver.findElement(accept_cookie_btn).click();
			}
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToUserProfileMenu(By Menu) {
		try {
			Thread.sleep(5000);
			explicitWait(driver, img_dd_ProfileMenu);
			driver.findElement(img_dd_ProfileMenu).click();
			driver.findElement(Menu).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String generateRandom(int length) {
		int min = (int) Math.pow(10, length - 1);
		int max = (int) Math.pow(10, length); // bound is exclusive

		Random random = new Random();

		return Integer.toString(random.nextInt(max - min) + min);
	}

	public String generateRandomString(int length) {

		boolean useLetters = true;
		boolean useNumbers = false;

		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return generatedString;
	}

	// function to generate a random string of length n
	public String getAlphaNumericString() {
		int n = 6;
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	public static int createRandomIntBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public static LocalDate createRandomDate(int startYear, int endYear) {
		int day = createRandomIntBetween(1, 28);
		int month = createRandomIntBetween(1, 12);
		int year = createRandomIntBetween(startYear, endYear);
		return LocalDate.of(year, month, day);
	}

	public String getMonthYear() throws InterruptedException {

		Thread.sleep(1000);
		WebElement link_mn_yr = driver.findElement(By.xpath("//th[@class='rdtSwitch']"));
		String mn_yr = link_mn_yr.getText();

		System.out.println("Month and Year on calender : " + mn_yr);
		return mn_yr;
	}

	public void explicitWait(WebDriver driver, By xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(xpath));
	}

	public void SplitDate(String dob) {

		String dd_mm_yy = dob;

		String date[] = dd_mm_yy.split("-");

		dd = Integer.valueOf(date[2]);
		mm = Integer.valueOf(date[1]);
		yyyy = Integer.valueOf(date[0]);

		hm.put(1, "January");
		hm.put(2, "February");
		hm.put(3, "March");
		hm.put(4, "April");
		hm.put(5, "May");
		hm.put(6, "June");
		hm.put(7, "July");
		hm.put(8, "August");
		hm.put(9, "September");
		hm.put(10, "October");
		hm.put(11, "November");
		hm.put(12, "December");

		for (Entry<Integer, String> entry : hm.entrySet()) {
			if (entry.getKey().equals(mm)) {
				System.out.println("Month in string : " + entry.getValue());
				mnth = entry.getValue();
			}
		}

	}

	public void clickOnDate(String dob) throws InterruptedException {
		boolean flag = false;

		SplitDate(dob);
		String mn_yr = getMonthYear();
		int year = Integer.valueOf(mn_yr.split(" ")[1]);
		int year_diff = yyyy - year;

		if (year_diff == 0) {

			String month = mn_yr.split(" ")[0];

			if (mnth.equalsIgnoreCase(month)) {
				WebElement link_date = driver.findElement(By.xpath("//td[text()='" + dd + "']"));
				link_date.click();
			} else {
				WebElement link_mm_yy = driver.findElement(By.xpath("//th[@class='rdtSwitch']"));
				link_mm_yy.click();

				Thread.sleep(2000);
				mnth = mnth.substring(0, 3);
				WebElement link_month = driver.findElement(By.xpath("//td[text()='" + mnth + "']"));
				link_month.click();

				Thread.sleep(2000);
				WebElement link_date = driver.findElement(By.xpath("//tdtext()='" + dd + "']"));
				link_date.click();

			}

		}

		if (year_diff != 0) {

			if (year_diff > 0) {
				WebElement link_mm_yy = driver.findElement(By.xpath("//th[@class='rdtSwitch']"));
				link_mm_yy.click();
				Thread.sleep(2000);
				WebElement link_mm_yy1 = driver.findElement(By.xpath("//th[@class='rdtSwitch']"));
				link_mm_yy1.click();

				do {
					WebElement link_mm_yy2 = driver.findElement(By.xpath("//th[@class='rdtSwitch']"));
					int end_year = Integer.valueOf(link_mm_yy2.getText().split("-")[1]);

					if (end_year > yyyy) {

						driver.findElement(By.xpath("//div[@class='rdtYears']//td[text()='" + yyyy + "']")).click();
						flag = true;
					}

					else {
						driver.findElement(By.className("rdtNext")).click();
					}
				} while (!flag);
			}

			if (year_diff < 0) {
				WebElement link_mm_yy = driver.findElement(By.xpath("//th[@class='rdtSwitch']"));
				link_mm_yy.click();
				Thread.sleep(2000);

				WebElement link_mm_yy1 = driver.findElement(By.xpath("//th[@class='rdtSwitch']"));
				link_mm_yy1.click();
				do {

					WebElement link_mm_yy2 = driver.findElement(By.xpath("//th[@class='rdtSwitch']"));
					int start_year = Integer.valueOf(link_mm_yy2.getText().split("-")[0]);
					if (start_year < yyyy) {

						driver.findElement(By.xpath("//div[@class='rdtYears']//td[text()='" + yyyy + "']")).click();
						flag = true;
					}

					else {
						driver.findElement(By.className("rdtPrev")).click();
					}
				} while (!flag);

			} else {
				String month = mn_yr.split(" ")[0];

				if (mnth.equalsIgnoreCase(month)) {
					WebElement link_date = driver.findElement(By.xpath("//td[text()='" + dd + "']"));
					link_date.click();
				} else {
					WebElement link_mm_yy = driver.findElement(By.className("rdtSwitch"));
					link_mm_yy.click();
				}
			}

			Thread.sleep(2000);
			mnth = mnth.substring(0, 3);
			WebElement link_month = driver.findElement(By.xpath("//td[text()='" + mnth + "']"));
			link_month.click();

			Thread.sleep(2000);
			WebElement link_date = driver.findElement(By.xpath("//td[text()='" + dd + "']"));
			link_date.click();

		}
	}

	@AfterSuite(alwaysRun = true)
	public void clearSession() throws InterruptedException {
		System.out.println("Ending the session");
		if(Language.equalsIgnoreCase("Spanish")) {
			obj_usr = new PageUserManagement(driver);
			obj_usr.goToUserProfileMenu(Profile);
			obj_usr.changeLanguage("Inglés");
			Thread.sleep(5000);
			// driver.quit();
		}
	}

}
