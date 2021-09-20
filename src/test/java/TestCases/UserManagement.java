package TestCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import Functionality.PageUserManagement;
import Functionality.pageLogin;

public class UserManagement extends baseTest{
	
	PageUserManagement obj_usr;
	pageLogin obj_log;
	
	String username = null;
	
	@Test(priority = 1,groups= {"Demo"})
	public void checkUserList() throws InterruptedException {
		
		obj_usr = new PageUserManagement(driver);
		obj_usr.acceptCookies();
		obj_usr.goToUserProfileMenu(UserManagement);
		obj_usr.checkUserListDisplay();
	}
	
	@Test(priority = 2,groups= {"Demo"})
	public void createUser() throws FindFailed, InterruptedException {
		
		obj_usr = new PageUserManagement(driver);
		username = obj_usr.addUser("Cashier", "English");
	}
	
	@Test(priority = 3)
	public void resetPassword() throws FindFailed, InterruptedException {
		
		obj_usr = new PageUserManagement(driver);
		obj_usr.goToUserProfileMenu(UserManagement);
		obj_usr.searchExistingUser(username);
		obj_usr.resetUserPassword();
		obj_usr.goToUserProfileMenu(Logout);
		obj_log = new pageLogin(driver);
		obj_log.UserLogin("teautomation", "Dolex@123");
	}
	
	@Test(priority = 4)
	public void makeUserInactive() throws FindFailed, InterruptedException {
		
		obj_usr = new PageUserManagement(driver);
		obj_usr.goToUserProfileMenu(UserManagement);
		username = obj_usr.addUser("Manager", "English");
		obj_usr.searchExistingUser(username);
		obj_usr.changeUserStatus("Inactive");
	}
	
	@Test(priority = 5)
	public void editUserDetails() throws FindFailed, InterruptedException {
		
		obj_usr = new PageUserManagement(driver);
		obj_usr.goToUserProfileMenu(UserManagement);
		obj_usr.searchExistingUser(username);
		obj_usr.editUserProfile();
	}
	
	@Test(priority = 6)
	public void lockAndUnlockUser() throws FindFailed, InterruptedException {
		
		obj_usr = new PageUserManagement(driver);
		Thread.sleep(5000);
		obj_usr.goToUserProfileMenu(UserManagement);
		username = obj_usr.addUser("Cashier", "English");
		obj_usr.searchExistingUser(username);
		obj_usr.resetUserPassword();
		obj_usr.goToUserProfileMenu(Logout);
		obj_usr.lockAndUnlockUserProfile(username);
	}
	
	@Test(priority = 7)
	public void sortUserListDetails() throws FindFailed, InterruptedException {
		
		obj_usr = new PageUserManagement(driver);
		Thread.sleep(5000);
		obj_usr.goToUserProfileMenu(UserManagement);
		obj_usr.sortUserList();
	}
	
	@Test(priority = 8)
	public void deleteUser() throws FindFailed, InterruptedException {
		
		obj_usr = new PageUserManagement(driver);
		obj_usr.goToUserProfileMenu(UserManagement);
		obj_usr.searchExistingUser(username);
		obj_usr.deleteUserProfile();
	}
	
}
