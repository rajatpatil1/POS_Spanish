package Functionality;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestCases.*;
import junit.framework.Assert;

public class pageLogin extends baseTest {

	WebDriver driver;

	By txt_username = By.id("userName");
	By txt_password = By.id("password");
	By btn_Login = By.xpath("//button[contains(@class,'login-button')]");
	By img_Logo = By.className("header-logo");

	By txt_CurrentPassword = By.id("currentPassword");
	By txt_NewPassword = By.id("password");
	By txt_ConfirmPassword = By.id("confirmpassword");

	public pageLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void Login(String un,String psd) {
		try {
			System.out.println("I am in Login Function");

			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(txt_username)));
//			assertEquals("DolEx POS", driver.getTitle());
			driver.findElement(txt_username).sendKeys(un);
			driver.findElement(txt_password).sendKeys(psd);
			driver.findElement(btn_Login).click();
			Thread.sleep(2000);
//			Assert.assertTrue(driver.findElement(img_Logo).isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void UserLogin(String Username, String Password) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(txt_username)));
		assertEquals("DolEx POS", driver.getTitle());
		driver.findElement(txt_username).clear();
		driver.findElement(txt_username).sendKeys(Username);
		driver.findElement(txt_password).clear();
		driver.findElement(txt_password).sendKeys(Password);
		driver.findElement(btn_Login).click();
		Thread.sleep(2000);
	}

	public void firstTimeLogin() {

		driver.findElement(txt_CurrentPassword).sendKeys("Dolex@123");
		driver.findElement(txt_NewPassword).sendKeys("Test@123");
		driver.findElement(txt_ConfirmPassword).sendKeys("Test@123");
		driver.findElement(btn_Login).click();
	}
}