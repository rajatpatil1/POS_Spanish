package Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import TestCases.baseTest;

public class PageCreditCollections extends baseTest {
	WebDriver driver;
	By summaryBar = By.xpath("//div[@class='summary-header p-0 py-1 row']//following-sibling::div");
	By paymentMethod = By.xpath("//div[@class='payment-methods col-md-12']");
	By fromDate = By.xpath("(//input[@placeholder='MM/DD/YYYY'])[1]");
	By toDate = By.xpath("(//input[@placeholder='MM/DD/YYYY'])[2]");
	By activefromDate = By.xpath("//table/tbody/tr/td[@class='rdtDay rdtActive'][1]");
	By activetoDate = By.xpath("//table/tbody/tr/td[@class='rdtDay rdtActive'][2]");
	By viewBtn = By.xpath("//button/span[text()='View']");
	By downloadBtn = By.xpath("//span[text()='Download']");
	By searchTxn = By.id("searchByDescription");
	By dd_FilterType = By.xpath("//div[contains(@class,'custom-dropdown dropdown')]");
	By searchTxnBtn = By.xpath("//button[@type='submit']");
	By cross = By.id("close-button");

	public PageCreditCollections(WebDriver driver) {
		this.driver = driver;
	}

	public void checkSummaryBar() {
		try {
			String text = driver.findElement(summaryBar).getText();
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchTxns() {
		try {
			driver.findElement(searchTxn).sendKeys("20876");
			driver.findElement(searchTxnBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchTxnsWithFilter(String FilterType) {
		try {
			driver.findElement(searchTxn).clear();
			driver.findElement(dd_FilterType).click();
			driver.findElement(By.xpath("//button[text()='"+FilterType+"']")).click();
			driver.findElement(searchTxnBtn).click();
			Thread.sleep(3000);
			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='position-relative']//div[contains(@class,'user-data')][1]//div[text()='"+FilterType+"']")).isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkPaymentMethod() {
		try {
			String text = driver.findElement(paymentMethod).getText();
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void generateAccountStatement() {
		try {
			driver.findElement(fromDate).sendKeys("08152021");
			Thread.sleep(1000);
			driver.findElement(activefromDate).click();
			driver.findElement(toDate).sendKeys("09142021");
			Thread.sleep(1000);
			driver.findElement(activetoDate).click();
			driver.findElement(viewBtn).click();
			Thread.sleep(10000);
			driver.findElement(downloadBtn).click();
			driver.findElement(cross).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
