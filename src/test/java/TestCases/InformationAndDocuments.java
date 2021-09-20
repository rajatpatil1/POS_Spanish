package TestCases;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import Functionality.PageInformationDocument;

public class InformationAndDocuments extends baseTest {
	PageInformationDocument obj_pageInformationDocument;

	@Test(priority = 1, groups = { "Demo" })
	public void checkAgentStatus() throws InterruptedException, FindFailed {
		obj_pageInformationDocument = new PageInformationDocument(driver);
		GoToMenu(infodocs);
		obj_pageInformationDocument.impInfo();
		obj_pageInformationDocument.downloadFormsManuals();
		GoToMenu(dashboard);
	}
}
