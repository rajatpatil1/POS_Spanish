package TestCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import Functionality.PageSendMoney;
import Functionality.pageBeneficiary;
import Functionality.pageSender;

public class SendMoney extends baseTest {

	pageSender obj_sender;
	pageBeneficiary obj_bene;
	PageSendMoney pageSendMoney;
	

	@Test(priority = 1, groups = { "Demo" })
	public void sendMoneyCreateSenderCreateRecipient() throws InterruptedException, FindFailed {
		System.out.println("Inside Create Sender Funcionality");
		obj_sender = new pageSender(driver);
		obj_bene = new pageBeneficiary(driver);
		Thread.sleep(7000);
		acceptCookies();
		GoToMenu(sendmoney);
		obj_sender.ManualAddress = false;
		obj_sender.CreateSenderProfile();
		obj_sender.ManualAddress = true;
		obj_bene.createRecipentProfile("USA");
		System.out.println("Navigating to send money page");
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();
	}

	/*	 @Test(priority = 2, groups = { "Demo" })//pass
	public void sendMoneyExistingSenderSingleRecipient() throws InterruptedException, FindFailed {
		System.out.println("Inside search existing sender funcionality");
		obj_sender = new pageSender(driver);
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		// Sender from USA - 1343036818
		String senderUSA = "1343036818";
//		String senderUSA = "null";
		obj_sender.searchExistingSender(senderUSA);
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();

	}

	 @Test(priority = 3)//pass
	public void sendMoneyExistingSenderMultipleRecipient() throws InterruptedException, FindFailed {
		System.out.println("Inside search existing sender funcionality");
		obj_sender = new pageSender(driver);
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		// Sender from USA with multiple benf - 1969688838
		String senderUSAmultiBenf = "1969688838";
		obj_sender.searchExistingSender(senderUSAmultiBenf);
		obj_bene = new pageBeneficiary(driver);
		obj_bene.selectExistingRecipent();
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();
	}

	 @Test(priority = 4)//pass
	public void editSenderAndRecipient() throws InterruptedException, FindFailed {
		System.out.println("Inside search existing sender funcionality");
		obj_sender = new pageSender(driver);
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		// Sender from USA - 1343036818
		String senderUSA = "1343036818";
		obj_sender.searchExistingSender(senderUSA);
		obj_sender.editExistingSender();
		obj_bene = new pageBeneficiary(driver);
		obj_bene.editExistingRecipient();
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();
	}

	 @Test(priority = 5)//pass
	public void sendMoneyUS_MX_TX() throws InterruptedException, FindFailed {
		System.out.println("Inside search existing sender funcionality");
		obj_sender = new pageSender(driver);
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		// Sender from USA and benf from Mexico- 1686154187
		String senderUSA = "1686154187";
		obj_sender.searchExistingSender(senderUSA);
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.cashPickup();
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();

	}

	 @Test(priority = 6)//pass
	public void sendMoneyUS_BR_TX() throws InterruptedException, FindFailed {
		System.out.println("Inside search existing sender funcionality");
		obj_sender = new pageSender(driver);
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		// Sender from USA and benf from brazil - 1813852477
		String senderUSA = "1813852477";
		obj_sender.searchExistingSender(senderUSA);
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.bankDeposit = true;
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "30");
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();

	}

	 @Test(priority = 7)//pass
	public void sendMoneyUS_DR_TX() throws InterruptedException, FindFailed {
		System.out.println("Inside search existing sender funcionality");
		obj_sender = new pageSender(driver);
		GoToMenu(sendmoney);
		// Sender from USA and benf from Dominican Republic - 1486269063
		String senderDR = "1486269063";
		obj_sender.searchExistingSender(senderDR);
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.serviceHomeDelivery = true;
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();

	}

	 @Test(priority = 8)//pass
	public void sendMoneyUS_DR_TXDiffCurrency() throws InterruptedException, FindFailed {
		System.out.println("Inside search existing sender funcionality");
		obj_sender = new pageSender(driver);
		Thread.sleep(5000);
		GoToMenu(sendmoney);
		// Sender from USA and benf from Dominican Republic - 1978237686
		String senderDR = "1978237686";
		obj_sender.searchExistingSender(senderDR);
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.serviceHomeDelivery = true;
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.changeCurrency();
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();

	}

	 @Test(priority = 9)
	public void maxTransferLimit() throws InterruptedException, FindFailed {
		System.out.println("Inside search existing sender funcionality");
		obj_sender = new pageSender(driver);
		Thread.sleep(20000);
		GoToMenu(sendmoney);
		// Sender from USA and benf from Dominican Republic - 2137525857
		String senderDR = "2137525857";
		obj_sender.searchExistingSender(senderDR);
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.cashPickup();
		pageSendMoney.makePayment(pageSendMoney.maxTransferLimitPayer, "1234");
		pageSendMoney.documentUpload();
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();

	}  */


	 @Test(priority = 10) // last line fail
	public void sendMoneyCheckCreditLineUpdate() throws InterruptedException, FindFailed {
		System.out.println("Inside sendMoneyCheckCreditLineUpdate Funcionality");
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		pageSendMoney = new PageSendMoney(driver);
		long CredLine = pageSendMoney.AvailableCreditLine();
		obj_sender = new pageSender(driver);
		obj_bene = new pageBeneficiary(driver);
		obj_sender.CreateSenderProfile();
		obj_bene.createRecipentProfile("USA");
		System.out.println("Navigating to send money page");
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();
		Thread.sleep(5000);
		long Exp_CredLine = CredLine - 20;
		long Act_CredLine = pageSendMoney.AvailableCreditLine();
		assertEquals(Act_CredLine, Exp_CredLine, "Credit Line is not updated");
	}

/*	 @Test(priority = 11, groups = { "Demo" })//pass
	public void sendMoneyFromSameSender() throws InterruptedException, FindFailed {
		System.out.println("Inside sendMoneyFromSameSender Funcionality");
		obj_sender = new pageSender(driver);
		obj_bene = new pageBeneficiary(driver);
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		obj_sender.CreateSenderProfile();
		obj_bene.createRecipentProfile("USA");
		System.out.println("Navigating to send money page");
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.ContinuePaymentflag = false;
		pageSendMoney.completePaymentAndViewReceipt();
		driver.findElement(By.xpath("//span[text()='Same Sender']/ancestor::button")).click();
		Thread.sleep(3000);
		obj_bene = new pageBeneficiary(driver);
		driver.findElement(By.xpath("//*[contains(text(), 'Add Recipient')]/ancestor::div[1]")).click();
		obj_bene.createRecipentProfile("USA");
		System.out.println("Navigating to send money page");
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.ContinuePaymentflag = true;
		pageSendMoney.completePaymentAndViewReceipt();

	}

	 @Test(priority = 12) // fail
	public void sendMoneyFromNewSender() throws InterruptedException, FindFailed {
		System.out.println("Inside sendMoneyFromNewSender Funcionality");
		obj_sender = new pageSender(driver);
		obj_bene = new pageBeneficiary(driver);
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		obj_sender.CreateSenderProfile();
		obj_bene.createRecipentProfile("USA");
		System.out.println("Navigating to send money page");
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.ContinuePaymentflag = false;
		pageSendMoney.completePaymentAndViewReceipt();
		driver.findElement(By.xpath("//span[text()='Change Sender']/ancestor::button")).click();
		Thread.sleep(3000);
		obj_sender = new pageSender(driver);
		obj_sender.CreateSenderProfile();
		obj_bene = new pageBeneficiary(driver);
		obj_bene.createRecipentProfile("USA");
		System.out.println("Navigating to send money page");
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.ContinuePaymentflag = true;
		pageSendMoney.completePaymentAndViewReceipt();
	}

	 @Test(priority = 13)//pass
	public void sendSuspiciousTransaction() throws InterruptedException, FindFailed {
		System.out.println("Inside sendSuspiciousTransaction Funcionality");
		obj_sender = new pageSender(driver);
		obj_bene = new pageBeneficiary(driver);
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		obj_sender.CreateSenderProfile();
		obj_bene.createRecipentProfile("USA");
		Thread.sleep(5000);
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.markTransactionAsSuspicious("Sender does several transactions / Structured transactions");
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();
	}

	 @Test(priority = 14)//pass
	public void sendMoneyResetTransaction() throws InterruptedException, FindFailed {
		System.out.println("Inside Create Sender Funcionality");
		obj_sender = new pageSender(driver);
		obj_bene = new pageBeneficiary(driver);
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		obj_sender.CreateSenderProfile();
		obj_bene.createRecipentProfile("USA");
		System.out.println("Navigating to send money page");
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.resetTransactionDetails();
		obj_sender = new pageSender(driver);
		obj_sender.CreateSenderProfile();
		obj_bene = new pageBeneficiary(driver);
		obj_bene.createRecipentProfile("USA");
		System.out.println("Navigating to send money page");
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();
	}

	 @Test(priority = 15)//pass
	public void sendMoneyTXAmountMoreThanPayerLimit() throws InterruptedException, FindFailed {
		System.out.println("Inside sendMoneyTXAmountMoreThanPayerLimit Funcionality");
		obj_sender = new pageSender(driver);
		obj_bene = new pageBeneficiary(driver);
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		obj_sender.CreateSenderProfile();
		obj_bene.createRecipentProfile("USA");
		System.out.println("Navigating to send money page");
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.sendMoneyExceedsPayerLimit("Payers cannot be located.");
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();
	}

	 @Test(priority = 16)//pass
	public void sendMoneyCheckFXRateInOverlay() throws InterruptedException, FindFailed {
		System.out.println("Inside sendMoneyCheckFXRateInOverlay Funcionality");
		obj_sender = new pageSender(driver);
		obj_bene = new pageBeneficiary(driver);
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		obj_sender.CreateSenderProfile();
		obj_bene.createRecipentProfile("USA");
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.checkFXRateInOverlay();
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();

	}

	 @Test(priority = 17) //pass
	public void checkFXRateForCountry() throws InterruptedException, FindFailed {
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.checkFXRateForDiffCountry("Haiti");
	}

	 @Test(priority = 18)//pass
	public void sendMoneyBeneandPayerAddressNotMatches() throws InterruptedException, FindFailed {
		System.out.println("Inside Create Sender Funcionality");
		obj_sender = new pageSender(driver);
		obj_bene = new pageBeneficiary(driver);
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		obj_sender.CreateSenderProfile();
		obj_bene.createRecipentProfile("USA");
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		obj_bene = new pageBeneficiary(driver);
		obj_bene.editBeneficiaryAddress("Colombia", "ARAUCA", "TAME");
		obj_bene.BeneAddressNotMatches();
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();
	}

	 @Test(priority = 19) // pass
	public void sendMoneyEstimateTransaction() throws InterruptedException, FindFailed {
		System.out.println("Inside sendMoneyEstimateTransaction Funcionality");
		obj_sender = new pageSender(driver);
		obj_bene = new pageBeneficiary(driver);
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.estimateTransaction("United States", "NEVADA", "LAS VEGAS", "PAGOS DOMESTICOS - UNITED STATES");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Select Sender']")).click();
		String senderUSA = "1969688838";
		obj_sender.searchExistingSender(senderUSA);
		driver.findElement(By.xpath("//div[@class='position-relative']//div[text()='196-968-8838']")).click();
		obj_bene = new pageBeneficiary(driver);
		obj_bene.selectExistingRecipent();
		Thread.sleep(4000);
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();
	}

	 @Test(priority = 20, groups = { "Demo" })//pass
	public void sendMoneyEstimateTransactionBeneAddressNotMatches() throws InterruptedException, FindFailed {
		try {
			System.out.println("Inside sendMoneyEstimateTransactionBeneAddressNotMatches Funcionality");
			obj_sender = new pageSender(driver);
			obj_bene = new pageBeneficiary(driver);
			Thread.sleep(7000);
			GoToMenu(sendmoney);
			pageSendMoney = new PageSendMoney(driver);
			pageSendMoney.estimateTransaction("Ecuador", "GUAYAS", "ANCON", "BANCO DEL AUSTRO");
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[text()='Select Sender']")).click();
			String senderUSAmultiBenf = "1969688838";
			obj_sender.searchExistingSender(senderUSAmultiBenf);
			driver.findElement(By.xpath("//div[@class='position-relative']//div[text()='196-968-8838']")).click();
			obj_bene.selectExistingRecipent();
			obj_bene.BeneAddressNotMatches();
			pageSendMoney.makePayment(pageSendMoney.commonPayer, "20");
			pageSendMoney.continuePayment();
			pageSendMoney.completePaymentAndViewReceipt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}  

	 @Test(priority = 21)//pass
	public void sendMoneyAggregationProceedWithoutDoc() throws InterruptedException, FindFailed {
		System.out.println("Inside Create Sender Funcionality");
		obj_sender = new pageSender(driver);
		obj_bene = new pageBeneficiary(driver);
		Thread.sleep(7000);
		GoToMenu(sendmoney);
		obj_sender.CreateSenderProfile();
		obj_bene.createRecipentProfile("MX");
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.commonPayer, "3000");
		pageSendMoney.continuePayment();
		pageSendMoney.proceedWithDocumentationPart();
		Thread.sleep(5000);
		pageSendMoney.completePaymentAndViewReceipt();

	}

	 @Test(priority = 22, groups = { "Demo" })
	public void sendMoneyAggregationFor3K() throws InterruptedException, FindFailed {
		System.out.println("Inside Create Sender Funcionality");
		obj_sender = new pageSender(driver);
		obj_bene = new pageBeneficiary(driver);
		GoToMenu(sendmoney);
		obj_sender.CreateSenderProfile();
		obj_bene.createRecipentProfile("MX");
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.receiverMexicoAgg, "3000");
		pageSendMoney.continuePayment();
		pageSendMoney.uploadIdentificationDocument();
		pageSendMoney.proceedWithDocumentationPart();

		Thread.sleep(10000);
		pageSendMoney.completePaymentAndViewReceipt();
	}

	 @Test(priority = 23)
	public void sendMoneyAggregationFor5K() throws InterruptedException, FindFailed {
		System.out.println("Inside Create Sender Funcionality");
		obj_sender = new pageSender(driver);
		obj_bene = new pageBeneficiary(driver);
		GoToMenu(sendmoney);
		obj_sender.CreateSenderProfile();
		obj_bene.createRecipentProfile("MX");
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.receiverMexicoAgg, "5000");
		pageSendMoney.continuePayment();
		pageSendMoney.uploadIdentificationDocument();
		pageSendMoney.uploadEmploymentInfo();
		pageSendMoney.uploadSourceOfFundsInfo();
		pageSendMoney.uploadOtherDoc();
		pageSendMoney.proceedWithDocumentationPart();
		pageSendMoney.completePaymentAndViewReceipt();
	}


	 @Test(priority = 24)//passs
	public void discountAdd() throws InterruptedException, FindFailed {
		System.out.println("Inside search existing sender funcionality");
		obj_sender = new pageSender(driver);
		GoToMenu(sendmoney);
		// Sender from USA and benf from Mexico- 2137525857
		String senderUSA = "2137525857";
		obj_sender.searchExistingSender(senderUSA);
		pageSendMoney = new PageSendMoney(driver);
		pageSendMoney.makePayment(pageSendMoney.receiverMexicoDiscount, "20");
		pageSendMoney.addDiscount();
		pageSendMoney.continuePayment();
		pageSendMoney.completePaymentAndViewReceipt();

	}*/
}
