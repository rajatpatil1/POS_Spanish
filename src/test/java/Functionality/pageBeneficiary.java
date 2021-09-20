package Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;

import com.util.XLS_Reader;

import TestCases.baseTest;

public class pageBeneficiary extends baseTest {

	WebDriver driver;

	By btn_AddSender = By.xpath("//span[text()='Add Sender']/ancestor::button");
	By txt_FirstName = By.id("addSenderFirstName");
	By txt_MiddleName = By.id("addSenderMiddleName");
	By txt_LastName = By.id("addSenderLastName");
	By txt_SecLastName = By.id("addSenderSecondLastName");
	By txt_PhoneNum = By.id("addSenderTelephone");
	By ch_IsMobile = By.xpath("//label[text()='Mobile']/ancestor::div[@class='checkbox-component']");
	By dd_Country = By.xpath(
			"//div[text()='Country Of Birth']/ancestor::div[@class='dropdown']//button[contains(@class,'toggle-dropdown')]");
	By txt_AddressLine1 = By.id("addSenderAddressLine1");
	By txt_AddressLine2 = By.id("addSenderAddressLine2");
	By dd_State = By.xpath(
			"//div[text()='State']/ancestor::div[@class='dropup dropdown']//button[contains(@class,'toggle-dropdown')]");
	By dd_City = By.xpath(
			"//div[text()='City']/ancestor::div[@class='dropup dropdown']//button[contains(@class,'toggle-dropdown')]");
	By txt_PostalCode = By.xpath(
			"//div[text()='Postal Code']/ancestor::div[@class='dropup dropdown']//button[contains(@class,'toggle-dropdown')]");
	By btn_Save = By.xpath("//span[text()='Create Profile']/ancestor::button");
	By btn_Back = By.xpath("//span[text()='Create Profile']/ancestor::button");
	By recipientTitle = By.xpath("//*[contains(text(), 'Add Recipient')]");
	By txt_TeleNum = By.id("addBeneficiaryTelephone");
	By recipientCountry = By.xpath("//*[@id=\"add-edit-beneficiary-form\"]/div[1]/div[2]/div[2]/div/div/div/button");
//	By recipientSearchCountry = By.xpath("//div[contains(text(), 'Search Countries')]");
	By recipientSearchCountry = By
			.xpath("//*[@id='add-edit-beneficiary-form']/div[1]/div[2]/div[2]/div/div/div/div[2]/div/div[1]/div[1]");
	By txt_dd_State = By.xpath(
			"//div[text()='State']/ancestor::div[contains(@class,'dropup dropdown')]//div[contains(@class,'react-select-inner__value-container')]//input");
	By txt_dd_City = By.xpath(
			"//div[text()='City']/ancestor::div[contains(@class,'dropup dropdown')]//div[contains(@class,'react-select-inner__value-container')]//input");
	By btn_CreateProfile = By.xpath("//span[text()='Create Profile']/ancestor::button");
	By selectRecipientTitle = By.xpath("//*[@id='content']/div/div[3]/div[text()='Select Recipient']");
	String filePath = System.getProperty("user.dir");
	By editRecipient = By.xpath(
			"//div[text()='Recipient']/ancestor::div[@class='heading-text pt-2 mb-1 card-title h5']//div[text()='Edit Details']");
	By editBtn = By.xpath(
			"//span[text()='Profile Details']/ancestor::div[contains(@class,'custom-profile-card')]//*[@id='edit-button']");
	By saveBtn = By.xpath("//span[text()='Save']");
	By btn_Proceed = By.xpath(
			"//div[text()='If you proceed you will have to choose another payer.']/ancestor::div[contains(@class,'modal-container')]//span[text()='Proceed']/ancestor::button[1]");
	By btn_Select = By.xpath("//span[text()='Select']/ancestor::button[1]");
	By receipentAddressCheckbox = By.xpath("(//div[@class='checkbox-component']/*[name()='svg'])[2]");

	public pageBeneficiary(WebDriver driver) {

		this.driver = driver;
	}

	public void createRecipentProfile(String BeneCountry) {
		Screen screen = new Screen();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			explicitWait(driver, recipientTitle);
			if (driver.findElement(recipientTitle).isDisplayed()) {
				System.out.println("On Add recipient page.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

		try {
			XLS_Reader obj_xls = new XLS_Reader(filePath + "\\src\\test\\resources\\TestData.xlsx");
			int rowNum = 0;
			
			if(Language.equalsIgnoreCase("English")) {
			switch (BeneCountry) {
			case "USA":
				rowNum = 2;
				break;
			case "MX":
				rowNum = 3;
				break;
			case "BR":
				rowNum = 4;
				break;
			case "DR":
				rowNum = 5;
				break;
			default:
				rowNum = 2;
			}
			}else {
				switch (BeneCountry) {
				case "USA":
					rowNum = 6;
					break;
				case "MX":
					rowNum = 7;
					break;
				case "BR":
					rowNum = 8;
					break;
				case "DR":
					rowNum = 9;
					break;
				default:
					rowNum = 6;
				}
			}
			String FirstName = obj_xls.getCellData("AddRecipient", "FirstName", rowNum);
			String fName = FirstName.concat(getAlphaNumericString());
			driver.findElement(txt_FirstName).sendKeys(fName);

			String MiddleName = obj_xls.getCellData("AddRecipient", "MiddleName", rowNum);
			driver.findElement(txt_MiddleName).sendKeys(MiddleName);

			String LastName = obj_xls.getCellData("AddRecipient", "LastName", rowNum);
			String lName = LastName.concat(getAlphaNumericString());
			driver.findElement(txt_LastName).sendKeys(lName);

			String SecLastName = obj_xls.getCellData("AddRecipient", "SecLastName", rowNum);
			driver.findElement(txt_SecLastName).sendKeys(SecLastName);

			String TelephoneNumber = generateRandom(10);
			driver.findElement(txt_TeleNum).sendKeys(TelephoneNumber);

			String BirthCountry = obj_xls.getCellData("AddRecipient", "Country", rowNum);
			js.executeScript("arguments[0].click()", driver.findElement(recipientCountry));
			explicitWait(driver, recipientSearchCountry);
			js.executeScript("arguments[0].value='" + BirthCountry + "';", driver.findElement(recipientSearchCountry));
			driver.findElement(By.xpath("//span[text()='" + BirthCountry + "']")).click();

			String manualAddress = obj_xls.getCellData("AddRecipient", "ManualAddress", rowNum);
			System.out.println(manualAddress);

			if (manualAddress.equalsIgnoreCase("TRUE")) {
				Thread.sleep(2000);
				driver.findElement(receipentAddressCheckbox).click();
			}
			String Adrs = obj_xls.getCellData("AddRecipient", "Address1", rowNum);
			driver.findElement(txt_AddressLine1).sendKeys(Adrs);

			js.executeScript("window.scrollBy(0,100)");
			String State = obj_xls.getCellData("AddRecipient", "State", rowNum);
			driver.findElement(dd_State).click();
			Thread.sleep(2000);
			driver.findElement(txt_dd_State).sendKeys(State);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@title='" + State + "']")).click();

			String City = obj_xls.getCellData("AddRecipient", "City", rowNum);
			driver.findElement(dd_City).click();
			Thread.sleep(2000);
			driver.findElement(txt_dd_City).sendKeys(City);
			driver.findElement(By.xpath("//span[@title='" + City + "']")).click();
			driver.findElement(btn_CreateProfile).click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void CreateSenderProfile() {

		driver.findElement(btn_AddSender).click();
		XLS_Reader obj_xls = new XLS_Reader(
				"C:\\Users\\manasee.shere\\eclipse-workspace\\DolEx_POS\\src\\test\\resources\\TestData.xlsx");
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

		String BirthCountry = obj_xls.getCellData("AddSender", "CountryOfBirth", 2);
		driver.findElement(dd_Country).sendKeys(BirthCountry);

		String TelephoneNumber = generateRandom(10);
		driver.findElement(txt_PhoneNum).sendKeys(TelephoneNumber);

		String IsMobile = obj_xls.getCellData("AddSender", "IsMobile", 2);
		if (IsMobile.equalsIgnoreCase("True")) {
			driver.findElement(ch_IsMobile).click();
		}

		String hno = generateRandom(3);
		String Adrs = obj_xls.getCellData("AddSender", "Address1", 2);
		String Address1 = hno.concat(Adrs);
		driver.findElement(txt_AddressLine1).sendKeys(Address1);

		String Address2 = obj_xls.getCellData("AddSender", "Address2", 2);
		driver.findElement(txt_AddressLine2).sendKeys(Address2);

		String State = obj_xls.getCellData("AddSender", "State", 2);
		driver.findElement(dd_State).sendKeys(State);

		String City = obj_xls.getCellData("AddSender", "City", 2);
		driver.findElement(dd_City).sendKeys(City);

		String PostalCode = obj_xls.getCellData("AddSender", "PostalCode", 2);
		driver.findElement(txt_PostalCode).sendKeys(PostalCode);

		driver.findElement(btn_Save).click();
	}

	public void selectExistingRecipent() {
		Screen screen = new Screen();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			explicitWait(driver, selectRecipientTitle);
			if (driver.findElement(selectRecipientTitle).isDisplayed()) {
				System.out.println("On select existing recipient page.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

		try {
			org.sikuli.script.Pattern ch_Address = new org.sikuli.script.Pattern(
					filePath + "\\lib\\Patterns\\SelectRecipient.png");
			screen.click(ch_Address);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void editExistingRecipient() throws FindFailed, InterruptedException {
		Screen screen = new Screen();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			Thread.sleep(5000);
			explicitWait(driver, editRecipient);
			driver.findElement(editRecipient).click();
			Thread.sleep(4000);
//			explicitWait(driver, editBtn);
			driver.findElement(editBtn).click();

			XLS_Reader obj_xls = new XLS_Reader(filePath + "\\src\\test\\resources\\TestData.xlsx");
			String FirstName = obj_xls.getCellData("AddRecipient", "FirstName", 2);
			String fName = FirstName.concat(getAlphaNumericString());
			driver.findElement(txt_FirstName).sendKeys(fName);

			String MiddleName = obj_xls.getCellData("AddRecipient", "MiddleName", 2);
			driver.findElement(txt_MiddleName).sendKeys(MiddleName);

			String LastName = obj_xls.getCellData("AddRecipient", "LastName", 2);
			String lName = LastName.concat(getAlphaNumericString());
			driver.findElement(txt_LastName).sendKeys(lName);

			String SecLastName = obj_xls.getCellData("AddRecipient", "SecLastName", 2);
			driver.findElement(txt_SecLastName).sendKeys(SecLastName);
			js.executeScript("window.scrollBy(0,100)");
			driver.findElement(saveBtn).click();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void editBeneficiaryAddress(String Country, String State, String City) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(editRecipient).click();
		Thread.sleep(4000);
		driver.findElement(editBtn).click();
		driver.findElement(recipientCountry).click();
		explicitWait(driver, recipientSearchCountry);
		js.executeScript("arguments[0].value='" + Country + "';", driver.findElement(recipientSearchCountry));
		driver.findElement(By.xpath("//span[text()='" + Country + "']")).click();

		String hno = generateRandom(3);
		String Address1 = hno.concat("505 Lt Raman Road");
		driver.findElement(txt_AddressLine1).sendKeys(Address1);

		driver.findElement(dd_State).click();
		Thread.sleep(2000);
		driver.findElement(txt_dd_State).sendKeys(State);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@title='" + State + "']")).click();

		driver.findElement(dd_City).click();
		Thread.sleep(2000);
		driver.findElement(txt_dd_City).sendKeys(City);
		driver.findElement(By.xpath("//span[@title='" + City + "']")).click();

		driver.findElement(saveBtn).click();
		Thread.sleep(2000);
		driver.findElement(editRecipient).click();
		Thread.sleep(2000);
		driver.findElement(btn_Select).click();
	}

	public void BeneAddressNotMatches() throws InterruptedException {

		driver.findElement(btn_Proceed).click();

	}
}
