package TestCases;

import org.testng.annotations.Test;

import Functionality.PageApm;
import Functionality.pageLogin;

public class APM extends baseTest {
	pageLogin obj_log;
	PageApm obj_apm;

	@Test(priority = 1)
	public void userLogin() throws InterruptedException {
		obj_log = new pageLogin(driver);
		obj_log.Login("admin", "123456");

	}

	@Test(priority = 2)
	public void searchAgency() throws InterruptedException {
		obj_apm = new PageApm(driver);
		obj_apm.searchApmAgency();
	}
}
