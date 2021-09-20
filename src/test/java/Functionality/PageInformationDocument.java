package Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestCases.baseTest;

public class PageInformationDocument extends baseTest {
	WebDriver driver;
	By sendAmount = By.cssSelector("#pinNumber");
	By formsCustomerService = By.xpath("(//div[text()='Customer Service'])[1]");
	By formsCompliance = By.xpath("(//div[text()='Compliance'])[1]");
	By complaintsReportAgents = By.xpath("//div[text()='Complaints Report Agents']");
	By dolexExpLetter = By.xpath("//div[text()='Dolex AML Explanation Letter Form']");
	By dolexWelcomePackage = By.xpath("//div[text()='Dolex Welcome Package']");
	By dolexAMLHandbook = By.xpath("//div[text()='Dolex AML Handbook for Agents']");
	By manualsCompliance = By.xpath("(//div[text()='Compliance'])[2]");
	By manualsCFPB = By.xpath("//div[text()='CFPB (Dodd Frank)']");
	By doddFrankMemorandum = By.xpath("//div[text()='Dodd Frank Memorandum']");
	By impInfo = By.id("memos-result-table");
	By sortImpInfoBtn = By.xpath("//th/span/*[name()='svg']");

	public PageInformationDocument(WebDriver driver) {
		this.driver = driver;
	}

	public void impInfo() {
		try {
			System.out.println(driver.findElement(impInfo).getText());
			driver.findElement(sortImpInfoBtn).click();
			System.out.println(driver.findElement(impInfo).getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void downloadFormsManuals() {
		try {
			driver.findElement(complaintsReportAgents).click();
			Thread.sleep(5000);
			explicitWait(driver, formsCompliance);
			driver.findElement(formsCompliance).click();
			driver.findElement(dolexExpLetter).click();
			Thread.sleep(5000);
			explicitWait(driver, dolexWelcomePackage);
			driver.findElement(dolexWelcomePackage).click();
			Thread.sleep(5000);
			explicitWait(driver, manualsCompliance);
			driver.findElement(manualsCompliance).click();
			driver.findElement(dolexAMLHandbook).click();
			Thread.sleep(10000);
			explicitWait(driver, manualsCFPB);
			driver.findElement(manualsCFPB).click();
			driver.findElement(doddFrankMemorandum).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
