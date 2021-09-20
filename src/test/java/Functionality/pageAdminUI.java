package Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestCases.baseTest;

public class pageAdminUI extends baseTest{
	
	WebDriver driver;
	
	By txt_AgentCode = By.id("agentCode");
	By btn_Search = By.xpath("//span[text()='Search']/ancestor::button[1]");
	By btn_Activate = By.xpath("//button[text()='Activate']");
	By dd_DefLang = By.xpath("//img[@alt='down_arrow']");
	By link_SignOut = By.xpath("//div[text()='Sign Out']");
	By link_DeactivateTerminal = By.xpath("//span[text()='Deactivate Terminal']");
	By btn_DeactivateTerminal = By.xpath("//span[text()='Deactivate']");
	
	public pageAdminUI(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void searchAgency(String Agency) throws InterruptedException {
		
		driver.findElement(txt_AgentCode).sendKeys(Agency);
		driver.findElement(btn_Search).click();
		Thread.sleep(2000);
	}
	
	public void activateTerminal(int Terminal, String Language) throws InterruptedException {
		
		driver.findElement(By.xpath("//div[text()='Select a Terminal']/ancestor::div[1]//div[text()='"+Terminal+"']")).click();
		driver.findElement(dd_DefLang).click();
		driver.findElement(By.xpath("//a[text()='"+Language+"']")).click();
		driver.findElement(btn_Activate).click();
		Thread.sleep(2000);
	}
	
	public void deactivateTerminal() {
		
		driver.findElement(link_DeactivateTerminal).click();
		explicitWait(driver, btn_DeactivateTerminal);
		driver.findElement(btn_DeactivateTerminal).click();
	}

	public void logout() {
		
		driver.findElement(link_SignOut).click();
	}
}
