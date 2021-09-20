package TestCases;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import Functionality.PageUserManagement;
import Functionality.pageLogin;

public class Profile extends baseTest {

	pageLogin obj_log;
	PageUserManagement obj_usr;
	
	String user = null;
	
	@Test(priority = 1,groups= {"Demo"})
	public void createUser() throws FindFailed, InterruptedException {

		obj_usr = new PageUserManagement(driver);
	//	obj_usr.acceptCookies();
		obj_usr.goToUserProfileMenu(UserManagement);
		user = obj_usr.addUser("Cashier", "English");
	}
	
	@Test(priority = 2,groups= {"Demo"})
	public void verifyLoggedInUserDetails() throws InterruptedException {
		obj_usr = new PageUserManagement(driver);
		obj_usr.goToUserProfileMenu(Logout);
		Thread.sleep(2000);
		obj_log = new pageLogin(driver);
		obj_log.UserLogin(user, "Dolex@123");
		Thread.sleep(5000);
		obj_log.firstTimeLogin();
		obj_usr.goToUserProfileMenu(Profile);
		obj_usr.verifyUserDetails(user);
	}
	
	@Test(priority = 3)
	public void changeLoggedInUserLanguageAsSpanish() throws InterruptedException {
		
		obj_usr = new PageUserManagement(driver);
		obj_usr.goToUserProfileMenu(Profile);
		obj_usr.changeLanguage("Spanish");
		Thread.sleep(5000);
	}
	
	@Test(priority = 4)
	public void changeLoggedInUserLanguageAsEnglish() throws InterruptedException {
		
		obj_usr = new PageUserManagement(driver);
		obj_usr.goToUserProfileMenu(Profile);
		obj_usr.changeLanguage("Inglés");
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 5)
	public void changeLoggedInUserPassword() throws InterruptedException {
		
		obj_usr = new PageUserManagement(driver);
		obj_usr.changeLoggedInUserPassword("Test@123", "Dolex@123");
		Thread.sleep(5000);
		obj_usr.goToUserProfileMenu(Logout);
		obj_log = new pageLogin(driver);
		obj_log = new pageLogin(driver);
		obj_log.UserLogin(user,"Dolex@123");
		obj_usr = new PageUserManagement(driver);
		obj_usr.goToUserProfileMenu(Profile);
		obj_usr.changeLoggedInUserPassword("Dolex@123","Test@123");
		Thread.sleep(5000);
	}
	
}
