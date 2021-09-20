package Functionality;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestCases.baseTest;


public class PageAdminLogin extends baseTest {
	WebDriver driver;

	
	By txt_username = By.id("userName");
	By txt_password = By.id("password");
	By btn_Login = By.xpath("//button[contains(@class,'login-button')]");
	By deactivateTerminal = By.xpath("//span[text()='Deactivate Terminal']");
	By deactivateBtn = By.xpath("//span[text()='Deactivate']");
	By agentCode = By.id("agentCode");
	By searchBtn = By.xpath("//button[@type='submit']");
	By terminal35 = By.xpath("//div[text()='35']");
	By activateBtn = By.xpath("//button[text()='Activate']");

	public PageAdminLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void adminLogin() {
		try {

			driver.get("https://payments.hub.dev.awsdolex.com/pos#/admin-login");
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(txt_username)));
			driver.findElement(txt_username).sendKeys("admin");
			driver.findElement(txt_password).sendKeys("123456");
			driver.findElement(btn_Login).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deactivateTerminaalAdmin() throws InterruptedException {
		try {
			explicitWait(driver, deactivateTerminal);
			driver.findElement(deactivateTerminal).click();
			Thread.sleep(2000);
			driver.findElement(deactivateBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void searchAgent() throws InterruptedException {
		try {
			explicitWait(driver, agentCode);
			driver.findElement(agentCode).sendKeys("AX560");
			driver.findElement(searchBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectTerminal() throws InterruptedException {
		try {
			explicitWait(driver, terminal35);
			driver.findElement(terminal35).click();
			driver.findElement(activateBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void demoUserLogin() throws InterruptedException {
		try {
			driver.get("https://payments.hub.test.awsdolex.com/pos#/login");
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_SPACE);
			Thread.sleep(1000);
			r.keyRelease(KeyEvent.VK_SPACE);
			explicitWait(driver, txt_username);
			driver.findElement(txt_username).sendKeys("atus");
			driver.findElement(txt_password).sendKeys("Test@1234");
			driver.findElement(btn_Login).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyTransaction() throws InterruptedException {
		try {
			pageLogin p = new pageLogin(driver);
			explicitWait(driver, p.img_Logo);
			for (int i = 1; i < 6; i++) {
				String txnNo = driver
						.findElement(By.xpath("//table[@id='transaction-table']/tbody/tr[" + i + "]/td[5]")).getText();
				if (txnNo.equals("MTAX560020869")) {
					System.out.println("Transaction Verified.....");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
