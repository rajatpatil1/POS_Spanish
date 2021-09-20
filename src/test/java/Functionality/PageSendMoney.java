package Functionality;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.sun.xml.bind.v2.runtime.output.XMLStreamWriterOutput;
import com.util.ExcelData;
import com.util.XLS_Reader;

import TestCases.baseTest;
import junit.framework.Assert;

public class PageSendMoney extends baseTest {

	WebDriver driver;

	By sendAmount = By.id("amounttoSendEdit");
	By changePayerOffice = By.xpath("//div[text()='Change']");
	By sendMoneyTitle = By.xpath("//div[contains(text(), 'Send Money')]");
	By searchPayerOffice = By.xpath("//*[@id='payer-search-form']/div[2]/div[2]/div/div[2]/button");
	public By commonPayer = By.xpath("(//table[@id='payer-table']/tbody/tr/td)[1]");
	public By receiverUSA = By.xpath("//div[text()='PAGOS DOMESTICOS - UNITED STATES']");
	public By receiverCOL = By.xpath("//div[text()='DAVIVIENDA']");
	public By receiverMexico = By.xpath("(//table[@id='payer-table']/tbody/tr/td)[1]");
	public By receiverMexicoDiscount = By.xpath("//div[text()='FAMSA']");
	public By receiverMexicoAgg = By.xpath("//div[text()='BANSEFI / LA RED DE LA GENTE']");
	public By receiverBrazil = By.xpath("//div[text()='BANCO DO BRASIL S.A.']");
	public By receiverDominicanRepublic = By.xpath("//div[text()='BANCO UNION - PESOS DOMICILIO - FTP']");
	public By receiverDominicanRepublicDiffCurrency = By
			.xpath("//div[text()='CARIOCA/BANCO UNION /RED AGENTES (DOMICILIO)']");
	public By maxTransferLimitPayer = By.xpath("//div[text()='TELECOM -TELEGRAFOS']");
	By confirmBtn = By.xpath("//span[text()='Confirm']");
	By continuePaymentBtn = By.xpath("//span[text()='Continue']/ancestor::button[1]");
	By proceedPaymentBtn = By.xpath("//div[contains(@class,'modal-panel')]//*[text()='Proceed']");
	By proceedBtn = By.xpath("//*[text()='Proceed']");
	By viewRecipt = By.xpath("//div[text()='View Receipt']");
	By receiptFrame = By.xpath("//div[@class='modal-panel']");
	// By receiptFrame = By.cssSelector("body > div:nth-child(9) > div > div > div >
	// div.modal-body.col-md-12 > div > iframe");
	By pdsCheckbox = By.xpath("//input[@type='checkbox']");
	By receiptAccountNo = By.xpath("//input[@placeholder='Recipient Account No.']");
	By accountTypeBtn = By.xpath("//*[@id='location-selection-form']/div/div[2]/div/div/button");
	By accountType = By.xpath("//*[@id='location-selection-form']/div/div[2]/div/div/div/button[2]");
	By branchCode = By.id("branchCode");
	By serviceType = By.xpath("//*[@id='payer-search-form']/div[1]/div[2]/div/div[2]/div/div/button");
	By serviceTypeHomeDelivery = By
			.xpath("//*[@id='payer-search-form']/div[1]/div[2]/div/div[2]/div/div/div/button[2]");
	By locationCard = By.xpath("(//div[@class='location-card card'])[1]");
	By btn_CloseReceipt = By.xpath("//button[contains(@class,'react-responsive-modal-closeButton')]");
	By btn_BacktoMainScreen = By.xpath(
			"//div[contains(text(),'Want to make another transfer? ')]/ancestor::div[@class='modal-body row']//button[@class='colored-btn btn btn-primary']");
	By txt_AvailableCreditLine = By
			.xpath("//div[text()='Available Credit Line']/ancestor::div[1]//div[2]//span[2]//span");
	By img_SuspiciousTXIcon = By
			.xpath("//span[text()='Suspicious Transaction']/ancestor::div[1]//span[@class='cursor-pointer mark-icon']");
	By txt_CommentBox = By.id("otherReason");
	By btn_SaveComment = By.xpath("//div[text()='Save']");
	By btn_ResetTransaction = By.xpath("//span[text()='Reset']/ancestor::button[1]");
	By msg_PayerLoc = By.xpath("//div[text()='Payers cannot be located.']");
	By icon_CloseEditTX = By
			.xpath("//div[text()='Edit Transaction']/ancestor::div[1]//div[2]//*[@class='cursor-pointer']");
	By img_Overlay = By.id("Overlay");
	By sec_FXRateOverlay = By.className("fxrate-overlay");
	By img_FXRateRefreshIcon = By.xpath("//div[@class='fxrate-overlay']//img[@id='refresh-button']");
	By txt_FXRateCurrency = By
			.xpath("//div[@class='fxrate-overlay']//div[@class='col-md-4'][1]//div[@class='currency']");
	By txt_FXRateForCountry = By
			.xpath("//div[@class='fxrate-overlay']//div[@class='col-md-4'][1]//div[@class='selected-rate']//span");
	By area_Page = By.xpath("//div[@class='modal fade show']");
	By img_FXRateEdit = By.id("edit-button");
	By dd_FXRateCountry = By
			.xpath("//div[@class='fx-rate col']//div[@class='col-md-4'][1]//div[@id='selectedCountry']");
	By dd_SearchCountry = By.xpath("//div[contains(@class,'dropdown-menu show')]//div[text()='Search Countries']");
	By txt_SearchCountry = By.xpath(
			"//div[text()='Search Countries']/ancestor::div[@class='dropdown-menu show']//div[@class='react-select-inner__input']//input");
	By btn_Save = By.xpath("//*[text()='Save']");
	By img_IDDocDownArrow = By.xpath(
			"//span[text()='Identification Document']/ancestor::div[contains(@class,'row')]//div[contains(@class,'cursor-pointer')]//div[2]");
	By img_EmpInfoDownArrow = By.xpath("//span[text()='Employment Information']/ancestor::div[2]//div[2]");
	By img_EmplInfoUPArrow = By.xpath(
			"//span[contains(text(),'Employment Information')]/ancestor::div[contains(@class,'view-details doc-background')]//*[contains(@class,'aSelectDownArrow')]");
	By img_SourceOfFundsDownArrow = By.xpath(
			"//span[text()='Source and Purpose of Funds']/ancestor::div[2]//div[2]//*[contains(@class,'cursor-pointer')]");
	By img_SourceOfFundsUPArrow = By.xpath(
			"//span[contains(text(),'Source and Purpose')]/ancestor::div[contains(@class,'view-details doc-background')]//*[contains(@class,'aSelectDownArrow')]");
	By img_OtherDocDownArrow = By
			.xpath("//span[text()='Other Documents']/ancestor::div[2]//div[2]//*[contains(@class,'cursor-pointer')]");

	By dd_Country = By.xpath("//span[contains(text(),'Country')]/ancestor::div[1]//div[@id='selectedCountry']");
	By txt_dd_Country = By.xpath(
			"//div[text()='Search Countries or Currency']/ancestor::div[contains(@class,'dropdown-menu')]//input");
	By dd_State = By.xpath("//span[contains(text(),'State')]/ancestor::div[1]//div[@id='selectedCountry']");
	By txt_dd_State = By.xpath("//div[text()='Search States']/ancestor::div[contains(@class,'dropdown-menu')]//input");
	By dd_City = By.xpath("//span[text()='City']/ancestor::div[1]//div[@id='selectedCountry']");
	By txt_dd_City = By.xpath("//div[text()='Search Cities']/ancestor::div[contains(@class,'dropdown-menu')]//input");
	By dd_PayerName = By.xpath("//span[text()='Payer Name']/ancestor::div[1]//div[@id='selectedCountry']");
	By txt_dd_PayerName = By
			.xpath("//div[text()='Search Payer']/ancestor::div[contains(@class,'dropdown-menu')]//input");
	By txt_Amount = By.id("amountToSend");

	By dd_IDType = By.xpath("//div[text()='ID Type']/ancestor::div[1]//button[contains(@class,'toggle-dropdown')]");
	By dd_txt_IDType = By.xpath("//div[text()='Search ID Type']/ancestor::div/div[2]/div/input");
	By dd_IssuanceCountry = By
			.xpath("//div[text()='Issuance Country`']/ancestor::div[1]//button[contains(@class,'toggle-dropdown')]");
	By dd_txt_IssuanceCountry = By.xpath("//div[text()='Search Countries']/ancestor::div/div[2]/div/input");
	By txt_IDNumber = By.id("docIdNumber");
	By dd_IssuedBy = By.xpath("//div[text()='Issued by']/ancestor::div[1]//button[contains(@class,'toggle-dropdown')]");
	By dd_txt_IssuedBy = By.xpath("//div[text()='Search Issued by']/ancestor::div/div[2]/div/input");
	By img_IssuanceDateCalIcon = By.xpath("//div[text()='Issuance Date']/ancestor::div[1]//input");
	By img_ExpirationDateCalIcon = By.xpath("//div[text()='Expiration Date']/ancestor::div[1]//input");
	By activeExpirationDate = By.xpath("(//table/tbody/tr/td[@class='rdtDay rdtActive'])[2]");
	By frontOfTheIdentification = By.xpath("(//div[@class='upload-file']/*[local-name()='svg'])[1]");
	By backOfTheIdentification = By.xpath("(//div[@class='upload-file']/*[local-name()='svg'])[2]");
	By captureBtn = By.xpath("//*[@id='upload-image']/div[2]/div[2]/div/button");
	By uploadBtn = By.xpath("//span[text()='Upload']");
	By txt_SSN = By.id("addSSNNumber");
	By ch_IsSSN = By.xpath("//label[text()='Does not have SSN/ITIN']/ancestor::div[@class='checkbox-component']");

	By dd_Occupation = By.xpath("//div[text()='Occupation']/ancestor::div[1]//div[@id='selectedCountry']");
	By dd_txt_Occupation = By
			.xpath("//div[text()='Search occupation']/ancestor::div[contains(@class,'dropdown-menu')]//input");
	By txt_CompanyName = By.xpath("//span[text()='Company Name']/ancestor::div[1]//input");
	By txt_Income = By.id("income");
	By txt_TelNumber = By.id("telephoneNumber");
	By dd_PaymentFrequency = By
			.xpath("//span[text()='Payment frequency']/ancestor::div[2]//div[contains(@class,'custom-dropdown')]");
	By ch_EnterAddrManually = By.xpath("(//*[name()='rect' and @class='checkbox_b'])");
	By txt_Address1 = By.id("addSenderAddressLine1");
	By dd_PostalCode = By.xpath(
			"//div[text()='Postal Code']/ancestor::div[contains(@class,'dropup dropdown')]//button[contains(@class,'toggle-dropdown')]");
	By txt_dd_PostalCode = By.xpath(
			"//div[text()='Postal Code']/ancestor::div[contains(@class,'dropup dropdown')]//div[contains(@class,'react-select-inner__value-container')]//input");
	By dd_State_emp = By.xpath(
			"//div[text()='State']/ancestor::div[contains(@class,'dropup dropdown')]//button[contains(@class,'toggle-dropdown')]");
	By txt_dd_State_emp = By.xpath(
			"//div[text()='State']/ancestor::div[contains(@class,'dropup dropdown')]//div[contains(@class,'react-select-inner__value-container')]//input");
	By dd_City_emp = By.xpath(
			"//div[text()='City']/ancestor::div[contains(@class,'dropup dropdown')]//button[contains(@class,'toggle-dropdown')]");
	By txt_dd_City_emp = By.xpath(
			"//div[text()='City']/ancestor::div[contains(@class,'dropup dropdown')]//div[contains(@class,'react-select-inner__value-container')]//input");

	By txt_Relationship = By.xpath("//input[@id='relation-with-sender']");
	By txt_SourceOfFunds = By
			.xpath("//div[text()='The Money that is being sent comes from']/ancestor::div[1]//textarea[1]");
	By txt_PurposeOfFunds = By.xpath("//div[text()='Purpose of Funds']/ancestor::div[1]//textarea[1]");
	By img_AddAttachment = By.xpath("//div[contains(@class,'upload-file')]");

	By img_IncomeReport = By.xpath("//div[text()='W-2 Income Report']/ancestor::div[1]");
	By img_1099MISC = By.xpath("//div[text()='1099 MISC']/ancestor::div[1]");
	By img_1040 = By.xpath("//div[text()='1040']/ancestor::div[1]");
	By img_EmpLetter = By.xpath("//div[text()='Employer Letter']/ancestor::div[1]");
	By img_BusiLicense = By.xpath("//div[text()='Business License']/ancestor::div[1]");
	By serviceType1 = By.xpath("(//button/div[@class='selected-value'])[2]");
	By cashPickup = By.xpath("//button[text()='Cash Pickup']");
	By currency = By.xpath("(//div[@class='selected-value'])[3]");
	By domCurrency = By.xpath("//button[text()='DOP']");
	By idType = By.xpath("(//div[@id='selectedCountry'])[2]");
	By searchIdType = By.xpath("//div[text()='Search ID Type']/ancestor::div/div[2]/div/input");
	By passportDropdown = By.xpath("//span[@title='PASSPORT / PASAPORTE']");
	By issuanceCountry = By.xpath("//div[text()='Issuance Country']/ancestor::div/button");
	By searchIssuanceCountry = By.xpath("(//div[text()='Search Countries']/ancestor::div/div[2]/div/input)[1]");
	By dropdownIssuanceCountry = By.xpath("//span[@title='UNITED STATES']");
	By docIdNumber = By.cssSelector("#docIdNumber");
	By issuanceDate = By.xpath("(//input[@placeholder='MM/DD/YYYY'])[1]");
	By expirationDate = By.xpath("(//input[@placeholder='MM/DD/YYYY'])[2]");
	By activeIssuanceDate = By.xpath("(//table/tbody/tr/td[@class='rdtDay rdtActive'])[1]");
	By issuedBy = By.xpath("//div[text()='Issued by']/following-sibling::button");
	By searchIssuedBy = By.xpath("//div[text()='Search Issued by']/ancestor::div/div[2]/div/input");
	By dropdownIssuedBy = By.xpath("//span[@title='US DEPARTMENT OF STATE']");
	By applyLink = By.xpath("//div[text()='Apply']");
	By adjUpto = By.xpath("//*[@id='adjustments-form']/div[1]/div");
	By discountValue = By.xpath("//*[@id='discount']");
	By applyBtn = By.xpath("//button/span[text()='Apply']");
	By payerTableLocation = By.xpath("(//table[@id='payer-table']/tbody/tr/td)[6]");
	By creditRefresh = By.xpath("//div[text()='Account Details']/ancestor::div[1]//img[@id='refresh-button']");

	String filePath = System.getProperty("user.dir");
	XLS_Reader obj_xls = new XLS_Reader(filePath + "\\src\\test\\resources\\TestData.xlsx");

	public static ArrayList<Object[]> receiptData = new ArrayList<Object[]>();
	public boolean bankDeposit = false;
	public boolean serviceHomeDelivery = false;
	public boolean locationReq = false;
	public boolean ContinuePaymentflag = true;
	public String transactionNo;

	public PageSendMoney(WebDriver driver) {
		this.driver = driver;
	}

	public boolean locationRequired() {
		String text = driver.findElement(payerTableLocation).getText();
		if (text.equals("Location Required")) {
			return true;
		}
		return false;
	}

	public long AvailableCreditLine() throws InterruptedException {
		System.out.println("Inside Available credit line function");
		Thread.sleep(5000);
		driver.findElement(creditRefresh).click();
		String CreditAmount = driver.findElement(txt_AvailableCreditLine).getText();
		System.out.println("Credit Amount = " + CreditAmount);
		String CredAmount = CreditAmount.substring(0, CreditAmount.indexOf("."));
		String CredAmt = CredAmount.replace(",", "");
		long CreditLine = Long.parseLong(CredAmt);
		return CreditLine;
	}

	public void cashPickup() {
		try {
			Thread.sleep(10000);
			driver.findElement(serviceType1).click();
			driver.findElement(cashPickup).click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void addDiscount() {
		try {
			driver.findElement(applyLink).click();
			Thread.sleep(2000);
			String discount = driver.findElement(adjUpto).getText();
			String discountAmt = discount.substring(discount.length() - 1);
			driver.findElement(discountValue).sendKeys(discountAmt);
			driver.findElement(applyBtn).click();
			System.out.println("Discount applied - " + discountAmt);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void documentUpload() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(5000);
			driver.findElement(idType).click();
			explicitWait(driver, searchIdType);
			driver.findElement(searchIdType).sendKeys("PASSPORT");
			driver.findElement(passportDropdown).click();
			Thread.sleep(2000);
			driver.findElement(issuanceCountry).click();
			explicitWait(driver, searchIssuanceCountry);
			driver.findElement(searchIssuanceCountry).sendKeys("United States");
			driver.findElement(dropdownIssuanceCountry).click();
			Thread.sleep(2000);
			explicitWait(driver, docIdNumber);
			driver.findElement(docIdNumber).sendKeys("123456789");
			Thread.sleep(2000);
			driver.findElement(issuanceDate).sendKeys("04182020");
			Thread.sleep(1000);
			driver.findElement(activeIssuanceDate).click();
			Thread.sleep(2000);
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
			
			Thread.sleep(2000);
			String IsSSN = obj_xls.getCellData("IdentificationDoc", "SSN", 2);
			if (IsSSN.equalsIgnoreCase("False")) {
				driver.findElement(ch_IsSSN).click();
			} else {
				driver.findElement(txt_SSN).sendKeys("777123454");
			}

			Thread.sleep(2000);
			driver.findElement(btn_Save).click();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void changeCurrency() {
		try {
			Thread.sleep(5000);
			driver.findElement(currency).click();
			Thread.sleep(2000);
			driver.findElement(domCurrency).click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void makePayment(By payer, String Amount) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			Thread.sleep(5000);
			explicitWait(driver, sendMoneyTitle);
			if (driver.findElement(sendMoneyTitle).isDisplayed()) {
				System.out.println("On send money page.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

		try {
			Thread.sleep(5000);
			explicitWait(driver, changePayerOffice);
			js.executeScript("arguments[0].click()", driver.findElement(changePayerOffice));
//			explicitWait(driver, sendAmount);
			Thread.sleep(2000);
			driver.findElement(sendAmount).sendKeys(Amount);
			if (serviceHomeDelivery) {
				Thread.sleep(2000);
				driver.findElement(serviceType).click();
				Thread.sleep(1000);
				driver.findElement(serviceTypeHomeDelivery).click();
			}
			js.executeScript("arguments[0].click()", driver.findElement(searchPayerOffice));

			explicitWait(driver, payer);
			driver.findElement(payer).click();
			locationReq = locationRequired();
			if (serviceHomeDelivery || locationReq) {
				Thread.sleep(4000);
				driver.findElement(locationCard).click();
			}
			if (bankDeposit) {
				Thread.sleep(1000);
				driver.findElement(receiptAccountNo).sendKeys("7777777");
				driver.findElement(accountTypeBtn).click();
				Thread.sleep(1000);
				driver.findElement(accountType).click();
			}
			driver.findElement(confirmBtn).click();
			if (bankDeposit) {
				Thread.sleep(1000);
				driver.findElement(branchCode).sendKeys("22222");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void continuePayment() {

		explicitWait(driver, continuePaymentBtn);
		driver.findElement(continuePaymentBtn).click();
	}

	public void completePaymentAndViewReceipt() {
		Screen screen = new Screen();
		String filePath = System.getProperty("user.dir");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			Thread.sleep(5000);
			explicitWait(driver, proceedPaymentBtn);
			js.executeScript("arguments[0].click()", driver.findElement(pdsCheckbox));
			Thread.sleep(5000);
			driver.findElement(proceedPaymentBtn).click();
			Thread.sleep(5000);
			driver.findElement(viewRecipt).click();
			Thread.sleep(4000);

			Actions actions = new Actions(driver);
			WebElement elementLocator = driver.findElement(receiptFrame);
			actions.contextClick(elementLocator).perform();
			Thread.sleep(2000);
			org.sikuli.script.Pattern saveAsBtn = new org.sikuli.script.Pattern(
					filePath + "\\lib\\Patterns\\saveAsBtn.png");
			screen.click(saveAsBtn);
			Thread.sleep(2000);

			org.sikuli.script.Pattern fileName = new org.sikuli.script.Pattern(
					filePath + "\\lib\\Patterns\\fileName.png");
			screen.type(fileName, "a", Key.CTRL);
			screen.type(Key.BACKSPACE);
			screen.type(fileName, filePath + "\\Receipt\\" + pdfFileName);
			Thread.sleep(2000);
			org.sikuli.script.Pattern saveBtn = new org.sikuli.script.Pattern(
					filePath + "\\lib\\Patterns\\saveBtn.png");
			screen.click(saveBtn);

			System.out.println("Pdf file saved - " + pdfFileName);
			Thread.sleep(5000);
			// Loading an existing document
			File file = new File(filePath + "\\Receipt\\" + pdfFileName);
			PDDocument document = PDDocument.load(file);
			// Instantiate PDFTextStripper class
			PDFTextStripper pdfStripper = new PDFTextStripper();
			// Retrieving text from PDF document
			String text = pdfStripper.getText(document);
//			System.out.println(text);
			transactionNo = text.substring(text.lastIndexOf("Transaction No./ No. de Transacción:") + 38,
					text.lastIndexOf("Transaction No./ No. de Transacción:") + 51);
			System.out.println("Transaction No./ No. de Transacción: " + transactionNo);
			String clave = text.substring(text.lastIndexOf("PIN number / Clave / Folio:") + 29,
					text.lastIndexOf("PIN number / Clave / Folio:") + 43);
			System.out.println("PIN number / Clave / Folio: " + clave);
			receiptData.add(new String[] { transactionNo, clave });
			ExcelData.writeExcelData(receiptData);
			Thread.sleep(2000);
			driver.findElement(btn_CloseReceipt).click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		if (ContinuePaymentflag) {
			driver.findElement(btn_BacktoMainScreen).click();
		}
	}

	public void resetTransactionDetails() throws InterruptedException {

		explicitWait(driver, btn_ResetTransaction);
		driver.findElement(btn_ResetTransaction).click();
		Thread.sleep(2000);
		driver.findElement(confirmBtn).click();

	}

	public void markTransactionAsSuspicious(String Comment) {

		driver.findElement(img_SuspiciousTXIcon).click();
		try {

			driver.findElement(By.xpath("//div[text()='" + Comment + "']")).isDisplayed();
			driver.findElement(By.xpath("//div[text()='" + Comment + "']")).click();
		} catch (Exception e) {

			driver.findElement(txt_CommentBox).sendKeys(Comment);
			driver.findElement(btn_SaveComment).click();
		}

	}

	public void sendMoneyExceedsPayerLimit(String ExpMsg) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(5000);
		explicitWait(driver, changePayerOffice);
		js.executeScript("arguments[0].click()", driver.findElement(changePayerOffice));
		Thread.sleep(2000);
		driver.findElement(sendAmount).sendKeys("99999");
		String ActMsg = driver.findElement(msg_PayerLoc).getText();
		assertEquals(ActMsg, ExpMsg);
		Thread.sleep(2000);
		driver.findElement(icon_CloseEditTX).click();
	}

	public void checkFXRateInOverlay() throws InterruptedException {

		driver.findElement(img_Overlay).click();
		Thread.sleep(2000);
		assertTrue(driver.findElement(sec_FXRateOverlay).isDisplayed(), "FX Rate section is display in Overlay");
		driver.findElement(img_FXRateRefreshIcon).click();
		Thread.sleep(3000);
		String Currency = driver.findElement(txt_FXRateCurrency).getText();
		String FXRate = driver.findElement(txt_FXRateForCountry).getText();
		System.out.println("Current FX Rate for Currency = " + Currency + " is = " + FXRate);
		driver.findElement(area_Page).click();
	}

	public void checkFXRateForDiffCountry(String Country) throws InterruptedException {
		try {

			driver.findElement(img_FXRateEdit).click();
			driver.findElement(dd_FXRateCountry).click();
			driver.findElement(dd_SearchCountry).click();
			Thread.sleep(2000);
			driver.findElement(txt_SearchCountry).sendKeys(Country);
			driver.findElement(
					By.xpath("//div[@class='dropdown-menu show']//span[text()='" + Country + "']/ancestor::div[1]"))
					.click();
			String FXRate = driver.findElement(By.xpath("//div[text()='" + Country
					+ "']/ancestor::div[@class='col-md-4']//div[@class='selected-rate']//span")).getText();
			System.out.println("Current FX Rate for Country = " + Country + " is = " + FXRate);
			driver.findElement(btn_Save).click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void estimateTransaction(String Country, String State, String City, String Payer)
			throws InterruptedException {
		try {
			driver.findElement(dd_Country).click();
			Thread.sleep(2000);
			driver.findElement(txt_dd_Country).sendKeys(Country);
			driver.findElement(By.xpath("//span[text()='" + Country + "']")).click();

			driver.findElement(dd_State).click();
			Thread.sleep(2000);
			driver.findElement(txt_dd_State).sendKeys(State);
			driver.findElement(By.xpath("//span[text()='" + State + "']")).click();

			driver.findElement(dd_City).click();
			Thread.sleep(2000);
			driver.findElement(txt_dd_City).sendKeys(City);
			driver.findElement(By.xpath("//span[text()='" + City + "']")).click();

			Thread.sleep(2000);
			driver.findElement(dd_PayerName).click();
			Thread.sleep(2000);
			driver.findElement(txt_dd_PayerName).sendKeys(Payer);
			driver.findElement(By.xpath("//span[text()='" + Payer + "']")).click();

			driver.findElement(txt_Amount).sendKeys("50");
			driver.findElement(By.xpath("//*[@class='right-icon']")).click();
			Thread.sleep(3000);

			driver.findElement(proceedBtn).click();
			Thread.sleep(5000);
			locationReq = locationRequired();
			if (locationReq) {
				Thread.sleep(4000);
				driver.findElement(locationCard).click();
			}
			driver.findElement(confirmBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void uploadIdentificationDocument() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {

			driver.findElement(dd_IDType).click();
			String IDType = obj_xls.getCellData("IdentificationDoc", "IDType", 2);
			driver.findElement(dd_txt_IDType).sendKeys(IDType);
			driver.findElement(By.xpath("//span[text()='" + IDType + "']")).click();

			Thread.sleep(2000);
			String Number = generateRandom(7);
			String IDNumber = "Q".concat(Number);
			driver.findElement(txt_IDNumber).sendKeys(IDNumber);

			java.time.LocalDate randomDate = createRandomDate(1940, 2000);
			String issDate = randomDate.toString();
			System.out.println(issDate);
			driver.findElement(img_IssuanceDateCalIcon).click();
			clickOnDate(issDate);

			Thread.sleep(2000);
			driver.findElement(img_ExpirationDateCalIcon).sendKeys("10302021");
			Thread.sleep(2000);
			driver.findElement(activeExpirationDate).click();

			driver.findElement(frontOfTheIdentification).click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].click()", driver.findElement(captureBtn));
			explicitWait(driver, uploadBtn);
			js.executeScript("arguments[0].click()", driver.findElement(uploadBtn));

			Thread.sleep(5000);
			driver.findElement(backOfTheIdentification).click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].click()", driver.findElement(captureBtn));
			explicitWait(driver, uploadBtn);
			js.executeScript("arguments[0].click()", driver.findElement(uploadBtn));

			Thread.sleep(2000);
			String IsSSN = obj_xls.getCellData("IdentificationDoc", "SSN", 2);
			if (IsSSN.equalsIgnoreCase("False")) {
				driver.findElement(ch_IsSSN).click();
			} else {
				driver.findElement(txt_SSN).sendKeys("777123454");
			}

			Thread.sleep(2000);
			driver.findElement(btn_Save).click();

			driver.findElement(img_IDDocDownArrow).click();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void uploadEmploymentInfo() throws InterruptedException {

		try {

			explicitWait(driver, img_EmpInfoDownArrow);
			driver.findElement(img_EmpInfoDownArrow).click();

			driver.findElement(dd_Occupation).click();
			Thread.sleep(1000);
			String Occupation = obj_xls.getCellData("EmploymentInfo", "Occupation", 2);
			driver.findElement(dd_txt_Occupation).sendKeys(Occupation);
			driver.findElement(By.xpath("//span[text()='" + Occupation + "']")).click();

			Thread.sleep(2000);
			String CompanyName = obj_xls.getCellData("EmploymentInfo", "CompanyName", 2);
			driver.findElement(txt_CompanyName).sendKeys(CompanyName);

			String Income = generateRandom(4);
			driver.findElement(txt_Income).sendKeys(Income);

			String TelNum = generateRandom(10);
			driver.findElement(txt_TelNumber).sendKeys(TelNum);

			String PayFreq = obj_xls.getCellData("EmploymentInfo", "Frequency", 2);
			driver.findElement(dd_PaymentFrequency).click();
			driver.findElement(By.xpath("//button[text()='" + PayFreq + "']")).click();

			driver.findElement(ch_EnterAddrManually).click();
			String hno = generateRandom(3);
			String Adrs = obj_xls.getCellData("EmploymentInfo", "Address1", 2);
			String Address1 = hno.concat(Adrs);
			driver.findElement(txt_Address1).sendKeys(Address1);

			Thread.sleep(2000);
			String State = obj_xls.getCellData("EmploymentInfo", "State", 2);
			driver.findElement(dd_State_emp).click();
			Thread.sleep(2000);
			driver.findElement(txt_dd_State_emp).sendKeys(State);
			driver.findElement(By.xpath("//span[text()='" + State + "']")).click();

			String City = obj_xls.getCellData("EmploymentInfo", "City", 2);
			driver.findElement(dd_City_emp).click();
			Thread.sleep(2000);
			driver.findElement(txt_dd_City_emp).sendKeys(City);
			driver.findElement(By.xpath("//span[text()='" + City + "']")).click();

			String PostalCode = obj_xls.getCellData("EmploymentInfo", "PostalCode", 2);
			driver.findElement(dd_PostalCode).click();
			Thread.sleep(2000);
			driver.findElement(txt_dd_PostalCode).sendKeys(PostalCode);
			driver.findElement(By.xpath("//span[@title='" + PostalCode + "']")).click();

			Thread.sleep(2000);
			driver.findElement(btn_Save).click();

			Thread.sleep(3000);
			driver.findElement(img_EmplInfoUPArrow).click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void uploadSourceOfFundsInfo() {

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			explicitWait(driver, img_SourceOfFundsDownArrow);
			driver.findElement(img_SourceOfFundsDownArrow).click();

			String Relationship = obj_xls.getCellData("SourceOfFundInfo", "Relationship", 2);
			driver.findElement(txt_Relationship).sendKeys(Relationship);

			String Source = obj_xls.getCellData("SourceOfFundInfo", "Source", 2);
			driver.findElement(txt_SourceOfFunds).sendKeys(Source);

			String Purpose = obj_xls.getCellData("SourceOfFundInfo", "Purpose", 2);
			driver.findElement(txt_PurposeOfFunds).sendKeys(Purpose);

			driver.findElement(img_AddAttachment).click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].click()", driver.findElement(captureBtn));
			explicitWait(driver, uploadBtn);
			js.executeScript("arguments[0].click()", driver.findElement(uploadBtn));

			Thread.sleep(2000);
			driver.findElement(btn_Save).click();

			explicitWait(driver, img_SourceOfFundsUPArrow);
			driver.findElement(img_SourceOfFundsUPArrow).click();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void uploadOtherDoc() {

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			explicitWait(driver, img_OtherDocDownArrow);
			driver.findElement(img_OtherDocDownArrow).click();

			driver.findElement(img_IncomeReport).click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].click()", driver.findElement(captureBtn));
			explicitWait(driver, uploadBtn);
			js.executeScript("arguments[0].click()", driver.findElement(uploadBtn));

			driver.findElement(img_1099MISC).click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].click()", driver.findElement(captureBtn));
			explicitWait(driver, uploadBtn);
			js.executeScript("arguments[0].click()", driver.findElement(uploadBtn));

			driver.findElement(img_1040).click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].click()", driver.findElement(captureBtn));
			explicitWait(driver, uploadBtn);
			js.executeScript("arguments[0].click()", driver.findElement(uploadBtn));

			driver.findElement(img_EmpLetter).click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].click()", driver.findElement(captureBtn));
			explicitWait(driver, uploadBtn);
			js.executeScript("arguments[0].click()", driver.findElement(uploadBtn));

			driver.findElement(img_BusiLicense).click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].click()", driver.findElement(captureBtn));
			explicitWait(driver, uploadBtn);
			js.executeScript("arguments[0].click()", driver.findElement(uploadBtn));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void proceedWithDocumentationPart() {

		explicitWait(driver, proceedBtn);
		driver.findElement(proceedBtn).click();

	}

}
