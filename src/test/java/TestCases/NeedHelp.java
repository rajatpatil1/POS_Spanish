package TestCases;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import Functionality.PageNeedHelp;

public class NeedHelp extends baseTest {
	PageNeedHelp obj_pageNeedHelp;

	@Test(priority = 1, groups = { "Demo" })
	public void fetchAccDetails() throws InterruptedException, FindFailed {
		obj_pageNeedHelp = new PageNeedHelp(driver);
		GoToMenu(needhelp);
		obj_pageNeedHelp.needHelp();
	}

}
