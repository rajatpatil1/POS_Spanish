package Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import TestCases.baseTest;

public class PageReceiveMoney extends baseTest {
	WebDriver driver;

	public PageReceiveMoney(WebDriver driver) {
		this.driver = driver;
	}

	By sendAmount = By.cssSelector("#pinNumber");
	By proceedBtn = By.xpath("//button[@type='submit']");
	By recipientNameMatchBtn = By.xpath("//span[text()='Yes']");
	By recipientNameMatchBtnNo = By.xpath("//span[text()='No']");
	By idType = By.xpath("(//div[@id='selectedCountry'])[6]");
	By searchIdType = By.xpath("//div[text()='Search ID Type']/ancestor::div/div[2]/div/input");
	By passportDropdown = By.xpath("//span[@title='PASSPORT / PASAPORTE']");
	By issuanceCountry = By.xpath("//div[text()='Issuance Country']/ancestor::div/button");
	By searchIssuanceCountry = By.xpath("(//div[text()='Search Countries']/ancestor::div/div[2]/div/input)[3]");
	By dropdownIssuanceCountry = By.xpath("//span[@title='UNITED STATES']");
	By docIdNumber = By.cssSelector("#docIdNumber");
	By issuanceDate = By.xpath("(//input[@placeholder='MM/DD/YYYY'])[1]");
	By expirationDate = By.xpath("(//input[@placeholder='MM/DD/YYYY'])[2]");
	By activeIssuanceDate = By.xpath("(//table/tbody/tr/td[@class='rdtDay rdtActive'])[1]");
	By activeExpirationDate = By.xpath("(//table/tbody/tr/td[@class='rdtDay rdtActive'])[2]");
	By issuedBy = By.xpath("//div[text()='Issued by']/following-sibling::button");
	By searchIssuedBy = By.xpath("//div[text()='Search Issued by']/ancestor::div/div[2]/div/input");
	By dropdownIssuedBy = By.xpath("//span[@title='US DEPARTMENT OF STATE']");
	By frontOfTheIdentification = By.xpath("(//div[@class='upload-file']/*[local-name()='svg'])[1]");
	By captureBtn = By.xpath("//*[@id='upload-image']/div[2]/div[2]/div/button");
	By uploadBtn = By.xpath("//span[text()='Upload']");
	By currentMonthYear = By.xpath("(//th[@class='rdtSwitch'])[2]");
	By completeTransaction = By.xpath("//span[text()='Complete Transaction']");
	By confirmTransaction = By.xpath("//span[text()='Confirm Transaction']");
	By incompleteName = By.xpath("//div[text()='Incomplete Name']");
	By enterBeneficiaryName = By.id("beneficiaryIdentificationName");
	By sendButton = By.xpath("//button[text()='Send']");

	public void receiveMoneyTransaction() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {

			// Clave number - 1327344856
			driver.findElement(sendAmount).sendKeys("1327344856");
			driver.findElement(proceedBtn).click();

			explicitWait(driver, recipientNameMatchBtn);
			driver.findElement(recipientNameMatchBtn).click();

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

			Thread.sleep(5000);
			js.executeScript("arguments[0].click()", driver.findElement(completeTransaction));
			Thread.sleep(5000);
			js.executeScript("arguments[0].click()", driver.findElement(completeTransaction));
			Thread.sleep(5000);
			js.executeScript("arguments[0].click()", driver.findElement(confirmTransaction));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void receiveMoneyNameIdentification() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			driver.findElement(sendAmount).sendKeys("1327345135");
			driver.findElement(proceedBtn).click();

			explicitWait(driver, recipientNameMatchBtnNo);
			driver.findElement(recipientNameMatchBtnNo).click();
			explicitWait(driver, incompleteName);
			driver.findElement(incompleteName).click();
			driver.findElement(enterBeneficiaryName).sendKeys("ModifyName");
			driver.findElement(sendButton).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
