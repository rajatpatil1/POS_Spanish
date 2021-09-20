package TestCases;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import Functionality.PageReceiveMoney;
import Functionality.pageSender;

public class ReceiveMoney extends baseTest {
	PageReceiveMoney pageReceiveMoney;
	pageSender obj_sender;

	@Test(priority = 1)
	public void recipientNameIdentification() throws InterruptedException, FindFailed {
		GoToMenu(receivemoney);
		obj_sender = new pageSender(driver);
		obj_sender.acceptCookies();
		pageReceiveMoney = new PageReceiveMoney(driver);
		pageReceiveMoney.receiveMoneyNameIdentification();
	}

//	@Test(priority = 2)
	public void receiveMoney() throws InterruptedException, FindFailed {
		GoToMenu(receivemoney);
		obj_sender = new pageSender(driver);
		obj_sender.acceptCookies();
		pageReceiveMoney = new PageReceiveMoney(driver);
		pageReceiveMoney.receiveMoneyTransaction();
	}
}
