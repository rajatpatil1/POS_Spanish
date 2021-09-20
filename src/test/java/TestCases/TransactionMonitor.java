package TestCases;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import Functionality.PageDashboard;
import Functionality.PageSendMoney;
import Functionality.PageTransactionsMonitor;
import Functionality.pageSender;

public class TransactionMonitor extends baseTest {
	PageTransactionsMonitor obj_transactionsMonitor;
	pageSender obj_sender;
	PageSendMoney pageSendMoney;

	 @Test(priority = 1, groups = { "Demo" })
	public void fetchAccDetails() throws InterruptedException, FindFailed {
		GoToMenu(txnmonitor);
		obj_sender = new pageSender(driver);
		obj_sender.acceptCookies();
		obj_transactionsMonitor = new PageTransactionsMonitor(driver);
		obj_transactionsMonitor.txnDetails();
		GoToMenu(dashboard);
	}

	 @Test(priority = 2, groups = { "Demo" })
	public void transactionInfoUsingSendersNo() throws InterruptedException, FindFailed {
		obj_transactionsMonitor.txnInfoUsingSendersNo();
	}

//	@Test(priority = 3)
	public void transactionInfoUsingTxnNo_requestCancellation() throws InterruptedException, FindFailed {
		Thread.sleep(5000);
		obj_sender = new pageSender(driver);
		GoToMenu(sendmoney);
		// Sender from USA - 1978237686
		String senderUSA = "1978237686";
//		String senderUSA = "null";
		obj_sender.searchExistingSender(senderUSA);
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.serviceHomeDelivery = true;
		pageSendMoney.makePayment(pageSendMoney.receiverDominicanRepublicDiffCurrency, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();
		System.out.println(pageSendMoney.transactionNo);
		GoToMenu(txnmonitor);
		Thread.sleep(5000);
		obj_transactionsMonitor = new PageTransactionsMonitor(driver);
		obj_transactionsMonitor.txnInfoUsingTxnNo(pageSendMoney.transactionNo);
		obj_transactionsMonitor.requestCancellation();
		obj_transactionsMonitor.goHome();
	}

	// @Test(priority = 4)
	public void transactionInfoUsingTxnNo_requestModification() throws InterruptedException, FindFailed {
		/*
		 * Add Send payment and get transaction number
		 */
		GoToMenu(txnmonitor);
		obj_transactionsMonitor.requestModification();
		obj_transactionsMonitor.goHome();
	}

	 @Test(priority = 5)
	public void transactionViewModification() throws InterruptedException, FindFailed {
		obj_transactionsMonitor.viewModification();
		obj_transactionsMonitor.goHome();
	}

	 @Test(priority = 6, groups = { "Demo" })
	public void pendingRefundTransaction() throws InterruptedException, FindFailed {
		GoToMenu(txnmonitor);
		obj_transactionsMonitor.checkPendingRefundTransaction();
	}

	 @Test(priority = 7)
	public void inCancellationProcessTransaction() throws InterruptedException, FindFailed {
		GoToMenu(txnmonitor);
		obj_transactionsMonitor.inCancellationProcess();
	}

	 @Test(priority = 8)
	public void pendingModificationsTransaction() throws InterruptedException, FindFailed {
		GoToMenu(txnmonitor);
		obj_transactionsMonitor.pendingModifications();
	}

	 @Test(priority = 9, groups = { "Demo" })
	public void retainedByComplianceTransaction() throws InterruptedException, FindFailed {
		GoToMenu(txnmonitor);
		obj_transactionsMonitor.retainedByCompliance();
	}

	 @Test(priority = 10)
	public void needingFollowUpTransaction() throws InterruptedException, FindFailed {
		GoToMenu(txnmonitor);
		obj_transactionsMonitor.needingFollowUp();
	}

	 @Test(priority = 11)
	public void printSortedTransaction() throws InterruptedException, FindFailed {
		GoToMenu(txnmonitor);
		obj_transactionsMonitor.sortTransaction();
	}

	 @Test(priority = 12)
	public void viewKycExpLetterTxnReceipt() throws InterruptedException, FindFailed {
		obj_transactionsMonitor.retainedByComplianceTxn();
		obj_transactionsMonitor.viewFirstretainedByComplianceTxn();
		obj_transactionsMonitor.viewKYC();
		obj_transactionsMonitor.viewExplanatoryLetter();
		obj_transactionsMonitor.viewTransactionReceipt();
		obj_transactionsMonitor.viewAdditionalInformation();
		obj_transactionsMonitor.goHome();
	}

	 @Test(priority = 13)
	public void txnRefund() throws InterruptedException, FindFailed {
		GoToMenu(txnmonitor);
		obj_transactionsMonitor.transactionRefund();
		obj_transactionsMonitor.goHome();
	}

}
