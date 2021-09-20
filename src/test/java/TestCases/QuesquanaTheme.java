package TestCases;

import org.testng.annotations.Test;

import Functionality.PageUserManagement;
import Functionality.pageAdminUI;
import Functionality.pageLogin;

public class QuesquanaTheme extends baseTest {
	
	pageLogin obj_log;
	pageAdminUI obj_admin;
	PageUserManagement obj_usr;
	
	@Test(priority = 1)
	public void logout() {
		
		goToUserProfileMenu(Logout);
	}
	
	@Test(priority = 2)
	public void LoginAdmin() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.get("https://payments.hub.test.awsdolex.com/pos#/admin-login");
		Thread.sleep(5000);
		obj_log = new pageLogin(driver);	
		obj_log.UserLogin("admin", "123456");
		
	}
	
	@Test(priority = 3)
	public void searchAgencyandActivateTerminal() throws InterruptedException {
		
		obj_admin = new pageAdminUI(driver);
		obj_admin.deactivateTerminal();
		obj_admin.searchAgency("AC534");
		obj_admin.activateTerminal(2, "English");
	}
	
	@Test(priority = 4)
	public void LogoutAdmin() {
		
		obj_admin.logout();
	}

	@Test(priority = 5)
	public void login() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.get("https://payments.hub.test.awsdolex.com/pos#/login");
		Thread.sleep(5000);
		obj_log = new pageLogin(driver);	
		obj_log.Login("admin", "Iam1Jefe!");
		obj_usr = new PageUserManagement(driver);
		obj_usr.checkThemeNote();
	}
	
	@Test(priority = 6)
	public void logoutFromQuesqueana() {
		
		goToUserProfileMenu(Logout);
	}
	
	@Test(priority = 7)
	public void LoginAdminUser() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.get("https://payments.hub.test.awsdolex.com/pos#/admin-login");
		Thread.sleep(5000);
		obj_log = new pageLogin(driver);	
		obj_log.UserLogin("admin", "123456");
	}
	
	@Test(priority = 8)
	public void searchAgencyandActivateTerminalAgain() throws InterruptedException {
		
		obj_admin = new pageAdminUI(driver);
		obj_admin.deactivateTerminal();
		obj_admin.searchAgency("AD607");
		obj_admin.activateTerminal(8, "English");
	}
	
	@Test(priority = 9)
	public void LogoutAdminUser() {
		
		obj_admin.logout();
	}

}
