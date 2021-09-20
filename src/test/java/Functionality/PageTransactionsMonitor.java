package Functionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import TestCases.baseTest;

public class PageTransactionsMonitor extends baseTest {
	WebDriver driver;
	By btn_AddSender = By.xpath("//span[text()='Add Sender']/ancestor::button");
	By retainedByCompliance = By.id("uncontrolled-tab-example-tab-retainedByCompliance");
	By needingFollowUp = By.id("uncontrolled-tab-example-tab-needingFollowUp");
	By pendingRefund = By.id("uncontrolled-tab-example-tab-pendingRefund");
	By inCancellationProcess = By.id("uncontrolled-tab-example-tab-inCancellationProcess");
	By pendingModifications = By.id("uncontrolled-tab-example-tab-pendingModifications");
	By transactionNumber = By.id("transactionNumber");
	By senderPhone = By.id("senderPhone");
	By searchBtn = By.cssSelector("button[type='submit']");
	By transactionRow = By.xpath("(//table[@id='transaction-table'])[4]/tbody/tr");
	By requestCancellationBtn = By.xpath("//span[text()='Request Cancellation']");
	By requestCancellationReason = By.xpath("//div[text()='Other']");
	By typeReason = By.cssSelector("textarea[placeholder='Type your message']");
	By doneBtn = By.xpath("//span[text()='Done']");
	By home = By.xpath("//a[@href='#/dashboard']");
	By requestModificationBtn = By.xpath("//span[text()='Request Modification']");
	By txt_FirstName = By.id("addSenderFirstName");
	By txt_MiddleName = By.id("addSenderMiddleName");
	By txt_LastName = By.id("addSenderLastName");
	By txt_SecLastName = By.id("addSenderSecondLastName");
	By txnRefund = By.xpath("(//table[@id='transaction-table'])[3]/tbody/tr");
	By refundTransaction = By.xpath("//span[text()='Refund Transaction']");
	By idType = By.xpath("(//div[@id='selectedCountry'])[1]");
	By searchIdType = By.xpath("//div[text()='Search ID Type']/ancestor::div/div[2]/div/input");
	By passportDropdown = By.xpath("//span[@title='PASSPORT / PASAPORTE']");
	By issuanceCountry = By.xpath("//div[text()='Issuance Country']/ancestor::div/button");
	By searchIssuanceCountry = By.xpath("(//div[text()='Search Countries']/ancestor::div/div[2]/div/input)[1]");
	By dropdownIssuanceCountry = By.xpath("//span[@title='UNITED STATES']");
	By docIdNumber = By.cssSelector("#docIdNumber");
	By issuanceDate = By.xpath("(//input[@placeholder='MM/DD/YYYY'])[1]");
	By activeIssuanceDate = By.xpath("(//table/tbody/tr/td[@class='rdtDay rdtActive'])[1]");
	By expirationDate = By.xpath("(//input[@placeholder='MM/DD/YYYY'])[2]");
	By activeExpirationDate = By.xpath("(//table/tbody/tr/td[@class='rdtDay rdtActive'])[2]");
	By issuedBy = By.xpath("//div[text()='Issued by']/following-sibling::button");
	By searchIssuedBy = By.xpath("//div[text()='Search Issued by']/ancestor::div/div[2]/div/input");
	By dropdownIssuedBy = By.xpath("//span[@title='US DEPARTMENT OF STATE']");
	By frontOfTheIdentification = By.xpath("(//div[@class='upload-file']/*[local-name()='svg'])[1]");
	By captureBtn = By.xpath("//*[@id='upload-image']/div[2]/div[2]/div/button");
	By uploadBtn = By.xpath("//span[text()='Upload']");
	By refundTransactionBtn = By.xpath("//span[text()='Refund Transaction']");
	By verifiedSenderChkBox = By.xpath("//div[@class='checkbox-component']/*[name()='svg']");
	By pendingModificationLink = By.xpath("//div[text()='Pending Modifications']");
	By viewModificationBtn = By.xpath("(//table[@id='transaction-table'])[5]/tbody/tr[1]/td[8]");
	By modifiedRecipient = By.xpath("(//div[@class='beneficary-details modified-data']/div[2])[1]");
	By pendingRefundTab = By.xpath("//div[text()='Pending Refund']");
	By cancellationTab = By.id("uncontrolled-tab-example-tab-inCancellationProcess");
	By pendingModificationsTab = By.id("uncontrolled-tab-example-tab-pendingModifications");
	By retainedByComplianceTab = By.id("uncontrolled-tab-example-tab-retainedByCompliance");
	By needingFollowUpTab = By.id("uncontrolled-tab-example-tab-needingFollowUp");
	By sortBtn = By.xpath("(//th[text()='Transaction Date and Time']/span/*[name()='svg'])[2]");
	By viewModificationTxn = By.xpath("(//table[@id='transaction-table'])[5]/tbody/tr[1]");
	By kycViewBtn = By.xpath("//span[text()='KYC']/following-sibling::span");
	By kycViewReceipt = By
			.cssSelector("body > div:nth-child(9) > div > div > div > div.modal-body.col-md-12 > div > iframe");
	By closePopup = By.xpath("//*[name()='svg' and @id='close-button']");
	By explanatoryLetterViewBtn = By.xpath("//div[text()='Explanatory Letter']/following-sibling::div/div/div");
	By explanatoryLetterViewReceipt = By.cssSelector(
			"body > div:nth-child(10) > div > div > div > div.modal-body.col-md-12 > div.modal-panel > iframe");
	By transactionReceiptViewBtn = By.xpath("//div[text()='Transaction Receipt']/following-sibling::div/div");
	By transactionReceiptViewReceipt = By.cssSelector(
			"body > div:nth-child(9) > div > div > div > div.modal-body.col-md-12 > div.modal-panel > iframe");
	By retainedByComplianceLink = By.xpath("//div[text()='Retained by Compliance']");
	By viewretainedByComplianceTxn = By.xpath("(//table[@id='transaction-table'])[1]/tbody/tr[1]");
	By provideAdditionalInformationViewBtn = By
			.xpath("//div[text()='Provide Additional Information']/following-sibling::div/div");
	By greyCircle = By.xpath("//*[name()='circle' and @fill='#afaba7']");
	By greenCircle = By.xpath("//*[name()='circle' and @fill='#168d4f']");

	public PageTransactionsMonitor(WebDriver driver) {
		this.driver = driver;
	}

	public void txnDetails() {
		try {
			String rc = driver.findElement(retainedByCompliance).getText();
			System.out.println(rc);
			String nfu = driver.findElement(needingFollowUp).getText();
			System.out.println(nfu);
			String pf = driver.findElement(pendingRefund).getText();
			System.out.println(pf);
			String icp = driver.findElement(inCancellationProcess).getText();
			System.out.println(icp);
			String pm = driver.findElement(pendingModifications).getText();
			System.out.println(pm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void txnInfoUsingTxnNo(String number) {
		try {
			// Transaction Number = MTAX560020601
			driver.findElement(transactionNumber).sendKeys(number);
			driver.findElement(searchBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goHome() {
		try {
			Thread.sleep(4000);
			driver.findElement(home).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void requestCancellation() {
		try {
			driver.findElement(transactionRow).click();
			driver.findElement(requestCancellationBtn).click();
			driver.findElement(requestCancellationReason).click();
			driver.findElement(typeReason).sendKeys("Transaction initiate by mistake.");
			driver.findElement(searchBtn).click();
			Thread.sleep(4000);
			driver.findElement(doneBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void requestModification() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.findElement(transactionNumber).sendKeys("MTAX560020848");
			driver.findElement(searchBtn).click();
			Thread.sleep(1000);
			js.executeScript("arguments[0].click()", driver.findElement(transactionRow));
			driver.findElement(requestModificationBtn).click();
			driver.findElement(txt_FirstName).sendKeys("ModifyFname");
			driver.findElement(txt_MiddleName).sendKeys("ModifyMname");
			driver.findElement(txt_LastName).sendKeys("ModifyLname");
			driver.findElement(txt_SecLastName).sendKeys("ModifySLname");
			driver.findElement(searchBtn).click();
			Thread.sleep(4000);
			driver.findElement(doneBtn).click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pendingModificationTxn() {
		try {
			driver.findElement(pendingModificationLink).click();
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void retainedByComplianceTxn() {
		try {
			driver.findElement(retainedByComplianceLink).click();
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewFirstModificationTxn() {
		try {
			driver.findElement(viewModificationTxn).click();
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewFirstretainedByComplianceTxn() {
		try {
			driver.findElement(viewretainedByComplianceTxn).click();
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewKYC() {
		try {
			Thread.sleep(2000);
			driver.findElement(kycViewBtn).click();
			Thread.sleep(7000);
			Actions actions = new Actions(driver);
			WebElement elementLocator = driver.findElement(kycViewReceipt);
			actions.contextClick(elementLocator).perform();
			Thread.sleep(3000);
			Screen screen = new Screen();
			org.sikuli.script.Pattern saveAsBtn = new org.sikuli.script.Pattern(
					filePath + "\\lib\\Patterns\\saveAsBtn.png");
			screen.click(saveAsBtn);
			Thread.sleep(2000);
			org.sikuli.script.Pattern fileName = new org.sikuli.script.Pattern(
					filePath + "\\lib\\Patterns\\fileName.png");
			screen.type(fileName, "a", Key.CTRL);
			screen.type(Key.BACKSPACE);
			screen.type(fileName, filePath + "\\Receipt\\" + getAlphaNumericString() + ".pdf");
			Thread.sleep(2000);
			org.sikuli.script.Pattern saveBtn = new org.sikuli.script.Pattern(
					filePath + "\\lib\\Patterns\\saveBtn.png");
			screen.click(saveBtn);
			driver.findElement(closePopup).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewExplanatoryLetter() {
		try {
			Thread.sleep(2000);
			driver.findElement(explanatoryLetterViewBtn).click();
			Thread.sleep(7000);
			Actions actions = new Actions(driver);
			WebElement elementLocator = driver.findElement(explanatoryLetterViewReceipt);
			actions.contextClick(elementLocator).perform();
			Thread.sleep(3000);
			Screen screen = new Screen();
			org.sikuli.script.Pattern saveAsBtn = new org.sikuli.script.Pattern(
					filePath + "\\lib\\Patterns\\saveAsBtn.png");
			screen.click(saveAsBtn);
			Thread.sleep(2000);
			org.sikuli.script.Pattern fileName = new org.sikuli.script.Pattern(
					filePath + "\\lib\\Patterns\\fileName.png");
			screen.type(fileName, "a", Key.CTRL);
			screen.type(Key.BACKSPACE);
			screen.type(fileName, filePath + "\\Receipt\\" + getAlphaNumericString() + ".pdf");
			Thread.sleep(2000);
			org.sikuli.script.Pattern saveBtn = new org.sikuli.script.Pattern(
					filePath + "\\lib\\Patterns\\saveBtn.png");
			screen.click(saveBtn);
			Thread.sleep(2000);
			driver.findElement(closePopup).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewTransactionReceipt() {
		try {
			Thread.sleep(2000);
			driver.findElement(transactionReceiptViewBtn).click();
			Thread.sleep(7000);
			Actions actions = new Actions(driver);
			WebElement elementLocator = driver.findElement(transactionReceiptViewReceipt);
			actions.contextClick(elementLocator).perform();
			Thread.sleep(3000);
			Screen screen = new Screen();
			org.sikuli.script.Pattern saveAsBtn = new org.sikuli.script.Pattern(
					filePath + "\\lib\\Patterns\\saveAsBtn.png");
			screen.click(saveAsBtn);
			Thread.sleep(2000);
			org.sikuli.script.Pattern fileName = new org.sikuli.script.Pattern(
					filePath + "\\lib\\Patterns\\fileName.png");
			screen.type(fileName, "a", Key.CTRL);
			screen.type(Key.BACKSPACE);
			screen.type(fileName, filePath + "\\Receipt\\" + getAlphaNumericString() + ".pdf");
			Thread.sleep(2000);
			org.sikuli.script.Pattern saveBtn = new org.sikuli.script.Pattern(
					filePath + "\\lib\\Patterns\\saveBtn.png");
			screen.click(saveBtn);
			Thread.sleep(2000);
			driver.findElement(closePopup).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewModification() {
		try {
			pendingModificationTxn();
			driver.findElement(viewModificationBtn).click();
			String modifiedRecipent = driver.findElement(modifiedRecipient).getAttribute("innerHTML");
			System.out.println(modifiedRecipent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewAdditionalInformation() {
		try {
			driver.findElement(provideAdditionalInformationViewBtn).click();
			Thread.sleep(2000);
			List<WebElement> findElements = driver.findElements(greenCircle);
			System.out.println("Total complete documents - " + findElements.size());
			List<WebElement> findElements1 = driver.findElements(greyCircle);
			System.out.println("Total incomplete documents - " + findElements1.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkPendingRefundTransaction() {
		try {
			driver.findElement(pendingRefundTab).click();
			Thread.sleep(4000);
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 8; j++) {
					System.out.println(driver
							.findElement(
									By.xpath("(//table[@id='transaction-table'])[3]/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText());
				}
			}
			GoToMenu(dashboard);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inCancellationProcess() {
		try {
			driver.findElement(cancellationTab).click();
			Thread.sleep(4000);
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 8; j++) {
					System.out.println(driver
							.findElement(
									By.xpath("(//table[@id='transaction-table'])[4]/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText());
				}
			}
			GoToMenu(dashboard);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pendingModifications() {
		try {
			driver.findElement(pendingModificationsTab).click();
			Thread.sleep(4000);
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 8; j++) {
					System.out.println(driver
							.findElement(
									By.xpath("(//table[@id='transaction-table'])[5]/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText());
				}
			}
			GoToMenu(dashboard);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void retainedByCompliance() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", driver.findElement(retainedByComplianceTab));
			Thread.sleep(4000);
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 8; j++) {
					System.out.println(driver
							.findElement(
									By.xpath("(//table[@id='transaction-table'])[1]/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText());
				}
			}
			GoToMenu(dashboard);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void needingFollowUp() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", driver.findElement(needingFollowUpTab));
			Thread.sleep(4000);
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 8; j++) {
					System.out.println(driver
							.findElement(
									By.xpath("(//table[@id='transaction-table'])[2]/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText());
				}
			}
			GoToMenu(dashboard);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sortTransaction() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", driver.findElement(needingFollowUpTab));
			Thread.sleep(4000);
			driver.findElement(sortBtn).click();

			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 8; j++) {
					System.out.println(driver
							.findElement(
									By.xpath("(//table[@id='transaction-table'])[2]/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText());
				}
			}
			GoToMenu(dashboard);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void transactionRefund() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.findElement(pendingRefund).click();
			driver.findElement(txnRefund).click();
			Thread.sleep(4000);
			driver.findElement(refundTransaction).click();

			driver.findElement(idType).click();
			explicitWait(driver, searchIdType);
			driver.findElement(searchIdType).sendKeys("PASSPORT");
			driver.findElement(passportDropdown).click();

			driver.findElement(issuanceCountry).click();
			explicitWait(driver, searchIssuanceCountry);
			driver.findElement(searchIssuanceCountry).sendKeys("United States");
			driver.findElement(dropdownIssuanceCountry).click();

			explicitWait(driver, docIdNumber);
			driver.findElement(docIdNumber).sendKeys("123456789");

			driver.findElement(issuanceDate).sendKeys("04182020");
			Thread.sleep(1000);
			driver.findElement(activeIssuanceDate).click();

			driver.findElement(expirationDate).sendKeys("04182022");
			Thread.sleep(1000);
			driver.findElement(activeExpirationDate).click();

			driver.findElement(issuedBy).click();
			driver.findElement(searchIssuedBy).sendKeys("US DEPARTMENT OF STATE");
			driver.findElement(dropdownIssuedBy).click();

			driver.findElement(frontOfTheIdentification).click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].click()", driver.findElement(captureBtn));
			explicitWait(driver, uploadBtn);
			js.executeScript("arguments[0].click()", driver.findElement(uploadBtn));

			Thread.sleep(10000);
			driver.findElement(verifiedSenderChkBox).click();
			driver.findElement(refundTransactionBtn).click();
			Thread.sleep(4000);
			driver.findElement(doneBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void txnInfoUsingSendersNo() {
		try {
			// Sender's telephone = 1246343779
			Thread.sleep(5000);
			driver.findElement(senderPhone).sendKeys("1315517759");
			driver.findElement(searchBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
