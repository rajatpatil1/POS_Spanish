package TestCases;

import org.testng.annotations.Test;

import Functionality.PageUserManagement;
import Functionality.pageLogin;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class LoginTest extends baseTest {

	pageLogin obj_log;
	PageUserManagement obj_usr;

	@Description("Login to POS app and Verify logo on home page")
	@Feature("Feature: Login")
	@Story("Story: Login and check logo presence")
	@Step("Verify Login functionality and logo presence")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 1, groups = { "Demo" })
	public void User_Login() throws InterruptedException {

		obj_log = new pageLogin(driver);
		obj_log.Login(username, password);
	//	obj_log.acceptCookies();

	}

	@Test(priority = 2)
	public void changeUserLanguage() throws InterruptedException {
		if (Language.equalsIgnoreCase("Spanish")) {
			obj_usr = new PageUserManagement(driver);
			Thread.sleep(5000);
			obj_usr.goToUserProfileMenu(Profile);
			obj_usr.changeLanguage(Language);
			Thread.sleep(5000);
		}
	}
}
