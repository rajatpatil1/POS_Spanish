package Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestCases.baseTest;

public class PageApm extends baseTest {

	WebDriver driver;
	By searchBox = By.xpath("//input[@placeholder='Enter Agent Code']");
	By searchBtn = By.xpath("//button/span[text()='Search']");

	public PageApm(WebDriver driver) {
		this.driver = driver;
	}

	public void searchApmAgency() {
		try {
			explicitWait(driver, searchBox);
			driver.findElement(searchBox).sendKeys("AD607");
			driver.findElement(searchBtn).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
