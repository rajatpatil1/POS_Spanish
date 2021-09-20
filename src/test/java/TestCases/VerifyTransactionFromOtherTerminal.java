package TestCases;

import org.testng.annotations.Test;

import Functionality.PageAdminLogin;

public class VerifyTransactionFromOtherTerminal extends baseTest {
	PageAdminLogin obj_pageAdminLogin;

	@Test(priority = 1,groups= {"Demo"})
	public void fetchAccDetails() throws InterruptedException {
		obj_pageAdminLogin = new PageAdminLogin(driver);
//		obj_pageAdminLogin.adminLogin();
//		obj_pageAdminLogin.deactivateTerminaalAdmin();
//		obj_pageAdminLogin.searchAgent();
//		obj_pageAdminLogin.selectTerminal();
		obj_pageAdminLogin.demoUserLogin();
		obj_pageAdminLogin.verifyTransaction();
	}
}
