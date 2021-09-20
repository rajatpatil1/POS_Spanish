package TestCases;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import Functionality.PageUserManagement;
import Functionality.pageLogin;

public class Settings extends baseTest {

	pageLogin obj_log;
	PageUserManagement obj_usr;
	
	String user = null;
	
	@Test(priority = 1)
	public void createUser() throws FindFailed, InterruptedException {
		
		obj_usr = new PageUserManagement(driver);
		obj_usr.goToUserProfileMenu(UserManagement);
		user = obj_usr.addUser("Manager", "English");
	}
	
	@Test(priority = 2)
	public void changeLoginPageLangauge() throws InterruptedException {
		
		obj_usr.goToUserProfileMenu(Settings);
		Thread.sleep(3000);
		obj_usr.changeLanguage("Spanish");
		obj_usr.goToUserProfileMenu(Logout);
		Thread.sleep(2000);
		obj_log = new pageLogin(driver);
		obj_log.UserLogin(user, "Dolex@123");
		Thread.sleep(5000);
		obj_log.firstTimeLogin();
		obj_usr.goToUserProfileMenu(Settings);
		obj_usr.changeLanguage("English");
	}
	
	@Test(priority = 3,groups= {"Demo"})
	public void configurePrinter() throws InterruptedException {
		obj_usr = new PageUserManagement(driver);
		obj_usr.goToUserProfileMenu(Settings);
		obj_usr.configureNewPrinterDetails("Fax", "THERMAL 3 IN");
	}
	
	@Test(priority = 4)
	public void editConfiguredPrinter() throws InterruptedException {
		
		obj_usr.goToUserProfileMenu(Settings);
		obj_usr.editconfiguredPrinterDetails();
	}
	
	@Test(priority = 5,groups= {"Demo"})
	public void deleteConfiguredPrinter() throws InterruptedException {
		
		obj_usr.goToUserProfileMenu(Settings);
		obj_usr.deleteconfiguredPrinterDetails();
	}
}
