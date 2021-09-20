package Functionality;

import java.io.Reader;
import java.util.regex.Pattern;

import javax.swing.plaf.synth.SynthSliderUI;

import org.joda.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import org.testng.internal.Systematiser;

import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.util.XLS_Reader;

import TestCases.SendMoney;
import TestCases.baseTest;
import junit.framework.Assert;

public class pageSender extends baseTest {

	WebDriver driver;
	By btn_AddSender = By.xpath("//span[text()='Add Sender']");
	By txt_FirstName = By.id("addSenderFirstName");
	By txt_MiddleName = By.id("addSenderMiddleName");
	By txt_LastName = By.id("addSenderLastName");
	By txt_SecLastName = By.id("addSenderSecondLastName");
	By txt_DOB = By.xpath("//input[@placeholder = 'MM/DD/YYYY']");
	By dd_BirthCountry = By.xpath(
			"//div[text()='Country Of Birth']/ancestor::div[@class='dropdown']//button[contains(@class,'toggle-dropdown')]");
	By dd_BirthCountrySpanish = By.xpath(
			"//div[text()='País de nacimiento']/ancestor::div[@class='dropdown']//button[contains(@class,'toggle-dropdown')]");

	By txt_dd_BirthCountry = By.xpath(
			"//div[text()='Country Of Birth']/ancestor::div[contains(@class,'dropdown')]//div[contains(@class,'react-select-inner__value-container')]//input");
	By txt_dd_BirthCountrySpanish = By.xpath(
			"//div[text()='País de nacimiento']/ancestor::div[contains(@class,'dropdown')]//div[contains(@class,'react-select-inner__value-container')]//input");
	By txt_ALCardNum = By.id("addSenderALCard");
	By txt_SSN = By.id("addSSNNumber");
	By ch_IsSSN = By.xpath("//label[text()='Does not have SSN/ITIN']/ancestor::div[@class='checkbox-component']");
	By ch_IsSSNSpanish = By.xpath("//label[text()='No tiene SSN / ITIN']/ancestor::div[@class='checkbox-component']");
	By txt_TeleNum = By.id("addSenderTelephone");
	By ch_IsMobile = By.xpath("//label[text()='Mobile']/ancestor::div[@class='checkbox-component']");
	By txt_EmailID = By.id("addSenderEmail");
	By txt_Address = By.xpath("//div[text()='Address']/ancestor::div[1]//input[@placeholder = 'Enter Sender Address']");
	By autoSuggestAddress = By.xpath("(//div[@id='autosuggest']/a)[1]");
	By ch_ManualAddress = By
			.xpath("//label[text()='Enter address manually']/ancestor::div[@class='checkbox-component']");
	By txt_AddressLine1 = By.id("addSenderAddressLine1");
	By txt_AddressLine2 = By.id("addSenderAddressLine2");
	By dd_State = By.xpath(
			"//div[text()='State']/ancestor::div[contains(@class,'dropup dropdown')]//button[contains(@class,'toggle-dropdown')]");
	By txt_dd_State = By.xpath(
			"//div[text()='State']/ancestor::div[contains(@class,'dropup dropdown')]//div[contains(@class,'react-select-inner__value-container')]//input");
	By dd_City = By.xpath(
			"//div[text()='City']/ancestor::div[contains(@class,'dropup dropdown')]//button[contains(@class,'toggle-dropdown')]");
	By txt_dd_City = By.xpath(
			"//div[text()='City']/ancestor::div[contains(@class,'dropup dropdown')]//div[contains(@class,'react-select-inner__value-container')]//input");
	By dd_PostalCode = By.xpath(
			"//div[text()='Postal Code']/ancestor::div[contains(@class,'dropup dropdown')]//button[contains(@class,'toggle-dropdown')]");
	By txt_dd_PostalCode = By.xpath(
			"//div[text()='Postal Code']/ancestor::div[contains(@class,'dropup dropdown')]//div[contains(@class,'react-select-inner__value-container')]//input");
	By btn_CreateProfile = By.xpath("//span[text()='Create Profile']/ancestor::button");

	By senderPhone = By.xpath("//span[text()='Telephone Number']/ancestor::div[1]//input");
	By editBtn = By.id("edit-button");
	By searchSender = By.xpath("//form[@id='sender-search-form']//button[@type='submit']");
	By saveBtn = By.xpath("//span[text()='Save']");
	By selectBtn = By.xpath("//span[text()='Select']");
	By editSender = By.xpath(
			"//div[text()='Sender']/ancestor::div[@class='heading-text pt-2 mb-1 card-title h5']//div[text()='Edit Details']");
	By mobileCheckbox = By.xpath("(//div[@class='checkbox-component']/*[name()='svg'])[2]");
	By addressManualCheckbox = By.xpath("(//div[@class='checkbox-component']/*[name()='svg'])[3]");
	By calenderAddSender = By.xpath("//*[@alt='calendar icon']/preceding-sibling::input");

	String filePath = System.getProperty("user.dir");
	public static boolean ManualAddress = true;

	public pageSender(WebDriver driver) {

		this.driver = driver;
	}

	public void CreateSenderProfile() throws FindFailed, InterruptedException {
		try {
			int rowNum = 0;
			switch (Language) {
			
			
			case "English":
				rowNum = 2;
				break;
			case "Spanish":
				rowNum = 3;
				break;
			default:
				rowNum = 2;
			}
			
			Screen s = new Screen();
			driver.findElement(btn_AddSender).click();
			XLS_Reader obj_xls = new XLS_Reader(filePath + "\\src\\test\\resources\\TestData.xlsx");
			String FirstName = obj_xls.getCellData("AddSender", "FirstName", rowNum);
			String fName = FirstName.concat(getAlphaNumericString());
			driver.findElement(txt_FirstName).sendKeys(fName);

			String MiddleName = obj_xls.getCellData("AddSender", "MiddleName", rowNum);
			driver.findElement(txt_MiddleName).sendKeys(MiddleName);

			String LastName = obj_xls.getCellData("AddSender", "LastName", rowNum);
			String lName = LastName.concat(getAlphaNumericString());
			driver.findElement(txt_LastName).sendKeys(lName);

			String SecLastName = obj_xls.getCellData("AddSender", "SecLastName", rowNum);
			driver.findElement(txt_SecLastName).sendKeys(SecLastName);

			java.time.LocalDate randomDate = createRandomDate(1940, 2000);
			String dob = randomDate.toString();
			System.out.println(dob);
			driver.findElement(calenderAddSender).click();
			clickOnDate(dob);

			String BirthCountry = obj_xls.getCellData("AddSender", "CountryOfBirth", rowNum);
			if (Language.equalsIgnoreCase("Spanish")) {
				driver.findElement(dd_BirthCountrySpanish).click();
			} else {
				driver.findElement(dd_BirthCountry).click();
			}
			Thread.sleep(2000);
			if (Language.equalsIgnoreCase("Spanish")) {
				driver.findElement(txt_dd_BirthCountrySpanish).sendKeys("Estados Unidos");
				driver.findElement(By.xpath("//span[text()='Estados Unidos']")).click();
			} else {
				driver.findElement(txt_dd_BirthCountry).sendKeys(BirthCountry);
				driver.findElement(By.xpath("//span[text()='" + BirthCountry + "']")).click();
			}

			String ALCardNumber = generateRandom(8);
			driver.findElement(txt_ALCardNum).sendKeys(ALCardNumber);

			String IsSSN = obj_xls.getCellData("AddSender", "IsSSN", rowNum);
			if (Language.equalsIgnoreCase("Spanish")) {
				if (IsSSN.equalsIgnoreCase("False")) {
					driver.findElement(ch_IsSSN).click();
				} else {
					String SSNumber = generateRandom(10);
					driver.findElement(txt_SSN).sendKeys(SSNumber);
				}
			} else {
				if (IsSSN.equalsIgnoreCase("False")) {
					driver.findElement(ch_IsSSN).click();
				} else {
					String SSNumber = generateRandom(10);
					driver.findElement(txt_SSN).sendKeys(SSNumber);
				}
			}
			String TelephoneNumber = generateRandom(10);
			driver.findElement(txt_TeleNum).sendKeys(TelephoneNumber);

			String IsMobile = obj_xls.getCellData("AddSender", "IsMobile", rowNum);
			if (IsMobile.equalsIgnoreCase("TRUE")) {
				driver.findElement(mobileCheckbox).click();
			}

			String EmailID = obj_xls.getCellData("AddSender", "EmailID", rowNum);
			driver.findElement(txt_EmailID).sendKeys(EmailID);

			String Address = obj_xls.getCellData("AddSender", "Address", rowNum);
//			driver.findElement(txt_Address).sendKeys(Address);

			if (ManualAddress) {
				driver.findElement(addressManualCheckbox).click();

				String hno = generateRandom(3);
				String Adrs = obj_xls.getCellData("AddSender", "Address1", rowNum);
				String Address1 = hno.concat(Adrs);
				driver.findElement(txt_AddressLine1).sendKeys(Address1);

				String Address2 = obj_xls.getCellData("AddSender", "Address2", rowNum);
				driver.findElement(txt_AddressLine2).sendKeys(Address2);

				// Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,100)");
				Thread.sleep(2000);
				String State = obj_xls.getCellData("AddSender", "State", rowNum);
				driver.findElement(dd_State).click();
				Thread.sleep(2000);
				driver.findElement(txt_dd_State).sendKeys(State);
				driver.findElement(By.xpath("//span[text()='" + State + "']")).click();

				String City = obj_xls.getCellData("AddSender", "City", rowNum);
				Thread.sleep(5000);
				driver.findElement(dd_City).click();
				driver.findElement(txt_dd_City).sendKeys(City);
				driver.findElement(By.xpath("//span[text()='" + City + "']")).click();

				String PostalCode = obj_xls.getCellData("AddSender", "PostalCode", rowNum);
				Thread.sleep(5000);
				driver.findElement(dd_PostalCode).click();
				Thread.sleep(2000);
				driver.findElement(txt_dd_PostalCode).sendKeys(PostalCode);
				driver.findElement(By.xpath("//span[@title='" + PostalCode + "']")).click();
			} else {
				driver.findElement(txt_Address).sendKeys("66");
				Thread.sleep(3000);
				driver.findElement(autoSuggestAddress).click();
			}

			driver.findElement(btn_CreateProfile).click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void searchExistingSender(String sender) throws FindFailed, InterruptedException {

		try {
			driver.findElement(senderPhone).sendKeys(sender);
			driver.findElement(searchSender).click();
		} catch (

		Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void editExistingSender() throws FindFailed, InterruptedException {
		Screen screen = new Screen();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			driver.findElement(editSender).click();
			Thread.sleep(4000);
//			explicitWait(driver, editBtn);
			driver.findElement(editBtn).click();

			XLS_Reader obj_xls = new XLS_Reader(filePath + "\\src\\test\\resources\\TestData.xlsx");
			String FirstName = obj_xls.getCellData("AddSender", "FirstName", 2);
			String fName = FirstName.concat(getAlphaNumericString());
			driver.findElement(txt_FirstName).sendKeys(fName);

			String MiddleName = obj_xls.getCellData("AddSender", "MiddleName", 2);
			driver.findElement(txt_MiddleName).sendKeys(MiddleName);

			String LastName = obj_xls.getCellData("AddSender", "LastName", 2);
			String lName = LastName.concat(getAlphaNumericString());
			driver.findElement(txt_LastName).sendKeys(lName);

			String SecLastName = obj_xls.getCellData("AddSender", "SecLastName", 2);
			driver.findElement(txt_SecLastName).sendKeys(SecLastName);
			js.executeScript("window.scrollBy(0,100)");
			driver.findElement(saveBtn).click();

			js.executeScript("arguments[0].click()", driver.findElement(selectBtn));

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

}
