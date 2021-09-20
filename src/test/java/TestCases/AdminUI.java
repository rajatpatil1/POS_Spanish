package TestCases;

import org.testng.annotations.Test;

import Functionality.PageDashboard;
import Functionality.PageUserManagement;
import Functionality.pageAdminUI;
import Functionality.pageLogin;

public class AdminUI extends baseTest {

	pageLogin obj_log;
	pageAdminUI obj_admin;
	PageUserManagement obj_usr;
	
	@Test(priority = 1)
	public void LoginAdmin() throws InterruptedException {
		
		obj_usr = new PageUserManagement(driver);
		obj_usr.goToUserProfileMenu(Logout);
		Thread.sleep(5000);
		driver.get("https://payments.hub.test.awsdolex.com/pos#/admin-login");
		obj_log = new pageLogin(driver);	
		Thread.sleep(5000);
		obj_log.UserLogin("admin", "123456");
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 2)
	public void searchAgencyandActivateTerminal() throws InterruptedException {
		
		obj_admin = new pageAdminUI(driver);
		obj_admin.deactivateTerminal();
		obj_admin.searchAgency("AD607");
		obj_admin.activateTerminal(11, "English");
	}
	
	@Test(priority = 3)
	public void configurePrinter() throws InterruptedException {
		
		obj_usr = new PageUserManagement(driver);
		obj_usr.configureNewPrinterDetails("Fax", "THERMAL 3 IN");
	}
	
	@Test(priority = 4)
	public void editConfiguredPrinter() throws InterruptedException {
		
		obj_usr.editconfiguredPrinterDetails();
	}
	
	@Test(priority = 5)
	public void deleteConfiguredPrinter() throws InterruptedException {
		
		obj_usr.deleteconfiguredPrinterDetails();
	}
	
	@Test(priority = 6)
	public void reactivateCurrentTerminal() throws InterruptedException {
		
		obj_admin = new pageAdminUI(driver);
		obj_admin.deactivateTerminal();
		obj_admin.searchAgency("AD607");
		obj_admin.activateTerminal(11, "English");
	}
	
	@Test(priority = 7)
	public void LogoutAdmin() {
		
		obj_admin.logout();
	}
	
}