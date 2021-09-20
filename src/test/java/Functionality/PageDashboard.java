package Functionality;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import TestCases.baseTest;

public class PageDashboard extends baseTest {
	WebDriver driver;
	By accept_cookie_btn = By.id("psGotItBtn");
	By cookie_btn_frame = By.id("ps-nvm-frame");
	By btn_AddSender = By.xpath("//span[text()='Add Sender']/ancestor::button");
	By avaliableCreditLine = By.xpath("//div[@class='available-credit-line row']");
	By totalBalanceRow = By.xpath("//div[@class='total-balance row']");
	By fxCard = By.xpath("//div[@class='fxrate-card']");
	By agency = By.xpath("//div[@class='user-name-panel pl-2']");
	By creditLine = By.xpath("//*[@id='subcomponent']/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[3]");
	By sideBarProfile = By.className("sidebar-profile-info");


	public PageDashboard(WebDriver driver) {
		this.driver = driver;
	}

	

	public void accountDetails() {
		try {
			driver.switchTo().frame(driver.findElement(cookie_btn_frame));
			if (driver.findElement(accept_cookie_btn).isDisplayed()) {
				System.out.println("Accept cookie bar is display.");
				driver.findElement(accept_cookie_btn).click();
			}
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(1000);
			explicitWait(driver, avaliableCreditLine);
			String avacreditLine = driver.findElement(avaliableCreditLine).getText();
			System.out.println(avacreditLine);
			Thread.sleep(1000);
			String tlBalanceRow = driver.findElement(totalBalanceRow).getText();
			System.out.println(tlBalanceRow);
			Thread.sleep(1000);
			String cdtLine = driver.findElement(creditLine).getText();
			System.out.println(cdtLine);
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fxRates() {
		try {
			Thread.sleep(5000);
			explicitWait(driver, fxCard);
			String fxCardText = driver.findElement(fxCard).getText();
			System.out.println(fxCardText);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void agencyDetail() {
		try {
			Thread.sleep(1000);
			explicitWait(driver, agency);
			String agencyText = driver.findElement(agency).getText();
			System.out.println(agencyText);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sideBarAccDetails() {
		try {
			Thread.sleep(1000);
			explicitWait(driver, agency);
			String agencyText = driver.findElement(sideBarProfile).getText();
			System.out.println(agencyText);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
