package Functionality;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.util.XLS_Reader;
import TestCases.baseTest;
import groovyjarjarantlr4.v4.parse.ANTLRParser.exceptionGroup_return;

public class PageUserManagement extends baseTest {

	WebDriver driver;
	pageLogin obj_log;

	By table_UserList = By.className("react-bs-table-container");
	By btn_AddUser = By.xpath("//span[text()='Add User']/ancestor::button[1]");
	By txt_FirstName = By.xpath("//input[@placeholder='Enter User First Name']");
	By txt_MiddleName = By.id("middlenameInput");
	By txt_LastName = By.xpath("//input[@placeholder='Enter User Last Name']");
	By txt_SecLastName = By.id("secondlastnameInput");
	By txt_Email = By.id("emailInput");
	By txt_TeleNum = By.id("phoneNumberInput");
	By txt_UserName = By.id("usernameInput");
	By dd_Language = By
			.xpath("//input[@id='selectLanguage']/ancestor::div[1]//button[contains(@class,'dropdown-toggle')]");
	By txt_Password = By.id("password");
	By txt_ConfirmPassword = By.id("confirmPassword");
	By btn_CreateUser = By.xpath("//span[text()='Create User']/ancestor::button[1]");
	By link_ResetPassword = By.xpath("//span[text()='Reset Password']");
	By txt_CurrentPassword = By.id("currentpassword");
	By txt_NewPassword = By.id("newPassword");
	By txt_YourPassword = By.id("yourPassword");
	By btn_Reset = By.xpath("//span[text()='Reset']/ancestor::button[1]");
	By icon_ChangeStatus = By.className("react-switch-bg");
	By btn_ChangeStatus = By.xpath(
			"//div[contains(text(),'Are you sure you want to')]/ancestor::div[1]//button[contains(@class,'colored-btn')]");
	By link_EditProfile = By.xpath("//span[text()='Edit Profile']");
	By btn_Save = By.xpath("//span[text()='Save']/ancestor::button[1]");
	By link_DeleteProfile = By.xpath("//span[text()='Delete']");
	By btn_Delete = By.xpath(
			"//div[contains(text(),'Are you sure you want to delete this')]/ancestor::div[1]//button[contains(@class,'colored-btn')]");
	By img_Sort = By.xpath("//th[text()='Name']//span");
	By txt_ShortName = By.xpath("//table//tr[1]//td[2]//span[1]//span");
	By txt_ErrorMsg = By.xpath("//div[@class='error-container']//span[contains(@class,'error-message')]");
	By img_lock = By.xpath("//img[@alt='lock']");
	By link_ChangePassword = By.xpath("//span[text()='Change Password']");
	By img_changeLangDD = By.xpath("//div[contains(@class,'language-selector')]//img[@alt='down_arrow']");
	By txt_ActUsername = By.xpath("//div[text()='Username']/ancestor::div[1]//div[2]");
	By txt_DOActivate = By.xpath("//div[text()='Date Of Activation']/ancestor::div[1]//div[2]");
	By btn_ConfigurePrinter = By.xpath("//button[text()='Configure New Printer']");
	By dd_PrinterName = By
			.xpath("//div[text()='Select printer name']/ancestor::div[1]//div[contains(@class,'custom-dropdown')]");
	By dd_PrinterType = By
			.xpath("//div[text()='Select printer type']/ancestor::div[1]//div[contains(@class,'custom-dropdown')]");
	By ch_DocReceipts = By.xpath("//div[text()='Receipts']");
	By link_EditPrinter = By.xpath("//span[text()='Edit']/ancestor::div[1]");
	By ch_DocPDS = By.xpath("//div[text()='PDS']");
	By btn_Configure = By.xpath("//span[text()='Configure']/ancestor::button[1]");
	By link_DeletePrinter = By.xpath("//span[text()='Delete']/ancestor::div[1]");
	By sideBar = By.xpath("//div[@class='sidebar-panel']/ul");
	By menu_CredAndColl = By.xpath("//*[@class='sidebar sidebar-menu-expanded']//div[text()='Credit and Collections']");
	By img_dd_ProfileMenu = By.className("up-down-arrow");
	By menu_UserManagement = By.xpath("//span[text()='User Management']/ancestor::a[1]");
	By menu_Settings = By.xpath("//span[text()='Settings']/ancestor::a[1]");
	By div_AccountDetails = By.xpath("//div[contains(@class,'account-details')]");
	By link_ViewDetails = By.xpath("//span[text()='View Details']");
	By img_Edit = By.id("edit-button");
	By txt_ThemeNote = By.className("footer-wrapper");

	public PageUserManagement(WebDriver driver) {
		this.driver = driver;
	}

	public void checkUserListDisplay() {

		explicitWait(driver, table_UserList);
	}

	public String addUser(String Role, String Language) {
		String returnUsername = null;
		try {
			int rowNum = 0;
			switch (Role) {
			case "Cashier":
				rowNum = 2;
				break;
			case "Manager":
				rowNum = 3;
				break;
			default:
				rowNum = 2;
			}

			explicitWait(driver, btn_AddUser);
			driver.findElement(btn_AddUser).click();
			XLS_Reader obj_xls = new XLS_Reader(filePath + "\\src\\test\\resources\\TestData.xlsx");

			driver.findElement(By.xpath("//div[text()='" + Role + "']")).click();

			String FirstName = obj_xls.getCellData("AddUser", "FirstName", rowNum);
			String fName = FirstName.concat(getAlphaNumericString());
			driver.findElement(txt_FirstName).sendKeys(fName);

			String MiddleName = obj_xls.getCellData("AddUser", "MiddleName", rowNum);
			driver.findElement(txt_MiddleName).sendKeys(MiddleName);

			String LastName = obj_xls.getCellData("AddUser", "LastName", rowNum);
			String lName = LastName.concat(getAlphaNumericString());
			driver.findElement(txt_LastName).sendKeys(lName);

			String SecLastName = obj_xls.getCellData("AddUser", "SecLastName", rowNum);
			driver.findElement(txt_SecLastName).sendKeys(SecLastName);

			String EmailID = obj_xls.getCellData("AddUser", "Email", rowNum);
			driver.findElement(txt_Email).sendKeys(EmailID);

			String TelephoneNumber = generateRandom(10);
			driver.findElement(txt_TeleNum).sendKeys(TelephoneNumber);

			String uno = generateRandomString(3);
			String Usrname = obj_xls.getCellData("AddUser", "Username", rowNum);
			String NewUsername = Usrname.concat(uno);
			System.out.println("username of new user : " + NewUsername);
			driver.findElement(txt_UserName).clear();
			driver.findElement(txt_UserName).sendKeys(NewUsername);

			driver.findElement(dd_Language).click();
			driver.findElement(By.xpath("//button[text()='" + Language + "']")).click();

			String Password = obj_xls.getCellData("AddUser", "Password", rowNum);
			driver.findElement(txt_Password).sendKeys(Password);

			String ConfirmPassword = obj_xls.getCellData("AddUser", "ConfirmPassword", rowNum);
			driver.findElement(txt_ConfirmPassword).sendKeys(ConfirmPassword);

			driver.findElement(btn_CreateUser).click();

			returnUsername = NewUsername;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnUsername;
	}

	public void resetUserPassword() throws InterruptedException {

		driver.findElement(link_ResetPassword).click();
		driver.findElement(txt_NewPassword).sendKeys("Test@123");
		driver.findElement(txt_ConfirmPassword).sendKeys("Test@123");
		driver.findElement(txt_YourPassword).sendKeys(password);
		driver.findElement(btn_Reset).click();
	}

	public void changeUserStatus(String Status) throws InterruptedException {

		WebElement CurrentStatus = driver.findElement(By.xpath("//label[text()='" + Status + "']"));
		boolean UserStatus = CurrentStatus.isSelected();
		if (UserStatus) {
			System.out.println("status is : " + UserStatus);
			return;
		} else {
			driver.findElement(icon_ChangeStatus).click();
			driver.findElement(btn_ChangeStatus).click();
			Thread.sleep(5000);
			assertFalse(CurrentStatus.isSelected(), "User status not change");
		}
	}

	public void searchExistingUser(String username) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='" + username + "']/ancestor::td[1]")).click();
	}

	public void editUserProfile() {

		driver.findElement(link_EditProfile).click();
		driver.findElement(txt_FirstName).clear();
		driver.findElement(txt_FirstName).sendKeys("FirstName_UP");
		driver.findElement(txt_LastName).clear();
		driver.findElement(txt_LastName).sendKeys("LastName_UP");
		driver.findElement(btn_Save).click();
	}

	public void deleteUserProfile() {

		driver.findElement(link_DeleteProfile).click();
		driver.findElement(btn_Delete).click();
	}

	public void sortUserList() throws InterruptedException {

		driver.findElement(img_Sort).click();
		Thread.sleep(5000);
		String shortname = driver.findElement(txt_ShortName).getText();
		System.out.println(shortname);
		assertTrue(!(shortname.startsWith("A")), "Sorting not done successfully");
	}

	public void lockAndUnlockUserProfile(String user) throws InterruptedException {

		obj_log = new pageLogin(driver);
		obj_log.UserLogin(user, "Dolex#123");
		obj_log.UserLogin(user, "Test#123");
		obj_log.UserLogin(user, "Dolex123");
		obj_log.UserLogin(user, "Doll1234");

		String expErrorMsg = "Your account has been locked. Please contact your Manager or Business Owner to unlock it.";
		String actErrorMsg = driver.findElement(txt_ErrorMsg).getText();
		assertEquals(actErrorMsg, expErrorMsg, "Locked user error message not matches");

		obj_log.UserLogin(username, "Dolex@123");
		goToUserProfileMenu(UserManagement);
		searchExistingUser(user);
		Thread.sleep(2000);
		driver.findElement(img_lock).click();
		Thread.sleep(5000);
	}

	public void verifyUserDetails(String expUsername) {

		String actUsername = driver.findElement(txt_ActUsername).getText();
		assertTrue(actUsername.contentEquals(expUsername), "Different logged in user");
		String ActivationDate = driver.findElement(txt_DOActivate).getText();
		System.out.println("The user : " + actUsername + " is activated on : " + ActivationDate);
	}

	public void changeLoggedInUserPassword(String CurrentPassword, String NewPassword) throws InterruptedException {

		driver.findElement(link_ChangePassword).click();
		driver.findElement(txt_CurrentPassword).sendKeys(CurrentPassword);
		driver.findElement(txt_NewPassword).sendKeys(NewPassword);
		driver.findElement(txt_ConfirmPassword).sendKeys(NewPassword);
		driver.findElement(btn_Save).click();
	}

	public void changeLanguage(String Language) {

		driver.findElement(img_changeLangDD).click();
		driver.findElement(By.xpath("//a[text()='" + Language + "']")).click();
	}

	public void configureNewPrinterDetails(String PrinterName, String PrinterType) {

		driver.findElement(btn_ConfigurePrinter).click();
		driver.findElement(dd_PrinterName).click();
		driver.findElement(By.xpath("//button[text()='" + PrinterName + "']")).click();
		driver.findElement(dd_PrinterType).click();
		driver.findElement(By.xpath("//button[text()='" + PrinterType + "']")).click();
		driver.findElement(ch_DocReceipts).click();
		driver.findElement(ch_DocPDS).click();
		driver.findElement(btn_Configure).click();
	}

	public void editconfiguredPrinterDetails() {

		driver.findElement(link_EditPrinter).click();
		driver.findElement(ch_DocPDS).click();
		driver.findElement(btn_Save).click();
	}

	public void deleteconfiguredPrinterDetails() {

		driver.findElement(link_DeletePrinter).click();
		driver.findElement(btn_Delete).click();
	}
	
	public void checkPermission(String User) {
		try {
			explicitWait(driver, sideBar);
			System.out.println(driver.findElement(sideBar).getText());
			if(User.startsWith("cash")) {
				Assertion softAssert = new SoftAssert();
				try {
					softAssert.assertFalse(driver.findElement(menu_CredAndColl).isDisplayed());
				}
				catch(Exception e) {
					System.out.println("Credit and Collections menu not displayed");
				}
				Thread.sleep(5000);
				explicitWait(driver, img_dd_ProfileMenu);
				driver.findElement(img_dd_ProfileMenu).click();
				Thread.sleep(2000);
				try {
					softAssert.assertFalse(driver.findElement(menu_UserManagement).isDisplayed());
				}
				catch(Exception e) {
					System.out.println("User Management menu not displayed");
				}
				try {
					softAssert.assertFalse(driver.findElement(menu_Settings).isDisplayed());
				}
				catch(Exception e) {
					System.out.println("Settins menu not displayed");
				}
				try {
					softAssert.assertFalse(driver.findElement(div_AccountDetails).isDisplayed());
				}
				catch(Exception e) {
					System.out.println("Account details section not displayed");
				}
				Thread.sleep(2000);
				driver.findElement(link_ViewDetails).click();
				try {
					softAssert.assertFalse(driver.findElement(img_Edit).isDisplayed());
				}
				catch(Exception e) {
					System.out.println("FX Rate edit link not displayed");
				}
			}
			else
			{
				Assertion softAssert = new SoftAssert();
				softAssert.assertTrue(driver.findElement(menu_CredAndColl).isDisplayed());
				Thread.sleep(5000);
				explicitWait(driver, img_dd_ProfileMenu);
				driver.findElement(img_dd_ProfileMenu).click();
				Thread.sleep(2000);
				softAssert.assertTrue(driver.findElement(menu_UserManagement).isDisplayed());
				softAssert.assertTrue(driver.findElement(menu_Settings).isDisplayed());
				driver.findElement(img_dd_ProfileMenu).click();
				softAssert.assertTrue(driver.findElement(div_AccountDetails).isDisplayed());
				Thread.sleep(2000);
				driver.findElement(link_ViewDetails).click();
				softAssert.assertTrue(driver.findElement(img_Edit).isDisplayed());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkThemeNote() {
		
		try {
		String Actnote = driver.findElement(txt_ThemeNote).getText();
		Assert.assertTrue(Actnote.contains("Quisqueyana"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
