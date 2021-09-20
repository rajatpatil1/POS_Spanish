package Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestCases.baseTest;

public class PageAnnouncements extends baseTest {
	WebDriver driver;
	By announce1 = By.xpath("//div[@class='image-container mx-0 row']/div[1]/img");
	By announce2 = By.xpath("//div[@class='image-container mx-0 row']/div[2]/img");
	By announce3 = By.xpath("//div[@class='image-container mx-0 row']/div[3]/img");
	By cross = By.id("close-button");

	public PageAnnouncements(WebDriver driver) {
		this.driver = driver;
	}

	public void announcement() {
		try {
			Thread.sleep(5000);
			driver.findElement(announce1).click();
			Thread.sleep(1000);
			driver.findElement(cross).click();
			Thread.sleep(1000);
			driver.findElement(announce2).click();
			Thread.sleep(1000);
			driver.findElement(cross).click();
			Thread.sleep(1000);
			driver.findElement(announce3).click();
			Thread.sleep(1000);
			driver.findElement(cross).click();
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
