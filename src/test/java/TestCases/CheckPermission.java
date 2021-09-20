package TestCases;

import org.testng.annotations.Test;

import Functionality.PageDashboard;
import Functionality.PageUserManagement;
import Functionality.pageLogin;

public class CheckPermission extends baseTest {

	pageLogin obj_log;
	PageUserManagement obj_usr;
	public static String cashierUser, managerUser = null;
	
	@Test(priority = 1,groups= {"Demo"})
	public void createUsers() throws InterruptedException {
		obj_usr = new PageUserManagement(driver);
		goToUserProfileMenu(UserManagement);
		cashierUser = obj_usr.addUser("Cashier", "English");
		Thread.sleep(5000);
		managerUser = obj_usr.addUser("Manager", "English");
		goToUserProfileMenu(Logout);
	}
	
	@Test(priority =2)
	public void checkCashierPermission() throws InterruptedException {
		
		obj_log = new pageLogin(driver);
		obj_log.UserLogin(cashierUser, "Dolex@123");
		Thread.sleep(5000);
		obj_log.firstTimeLogin();
		obj_usr = new PageUserManagement(driver);
		obj_usr.checkPermission(cashierUser);
		goToUserProfileMenu(Logout);
	}
	
	@Test(priority =3)
	public void checkManagerPermission() throws InterruptedException {
		
		obj_log = new pageLogin(driver);
		obj_log.UserLogin(managerUser, "Dolex@123");
		Thread.sleep(5000);
		obj_log.firstTimeLogin();
		obj_usr = new PageUserManagement(driver);
		obj_usr.checkPermission(managerUser);
		goToUserProfileMenu(Logout);
	}
}
