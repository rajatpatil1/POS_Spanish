package TestCases;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import Functionality.PageAnnouncements;
import Functionality.PageDashboard;
import Functionality.PageTransactionsMonitor;

public class Dashboard extends baseTest {
	PageDashboard obj_dashboard;
	PageTransactionsMonitor obj_transactionsMonitor;
	PageAnnouncements obj_announcements;

	@Test(priority = 1, groups = { "Demo" })
	public void fetchAccDetails() throws InterruptedException, FindFailed {
		obj_dashboard = new PageDashboard(driver);
		obj_dashboard.accountDetails();
//		GoToMenu("Transactions Monitor");
//		obj_transactionsMonitor = new PageTransactionsMonitor(driver);
//		obj_transactionsMonitor.txnDetails();
	}

	@Test(priority = 2, groups = { "Demo" })
	public void fetchFxRate() throws InterruptedException, FindFailed {
		obj_dashboard = new PageDashboard(driver);
		obj_dashboard.fxRates();
	}

	@Test(priority = 3)
	public void agencyDetails() throws InterruptedException, FindFailed {
		obj_dashboard.agencyDetail();
	}

	@Test(priority = 4)
	public void accDetailsLeftPannel() throws InterruptedException, FindFailed {
		obj_dashboard.sideBarAccDetails();
	}

	@Test(priority = 5)
	public void announcements() throws InterruptedException, FindFailed {
		GoToMenu(infodocs);
		obj_announcements = new PageAnnouncements(driver);
		obj_announcements.announcement();
	}
}
