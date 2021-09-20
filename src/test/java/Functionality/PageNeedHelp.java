package Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestCases.baseTest;

public class PageNeedHelp extends baseTest {
	WebDriver driver;
	By contactUsCard = By.className("contact-us-card");

	public PageNeedHelp(WebDriver driver) {
		this.driver = driver;
	}

	public void needHelp() {
		try {
			System.out.println(driver.findElement(contactUsCard).getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
