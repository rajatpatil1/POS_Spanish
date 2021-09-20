package TestCases;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import Functionality.PageCreditCollections;

public class CreditsAndCollections extends baseTest {
	PageCreditCollections obj_pageCreditCollections;

	@Test(priority = 1, groups = { "Demo" })
	public void checkAgentStatus() throws InterruptedException, FindFailed {
		GoToMenu(creditAndBalance);
		obj_pageCreditCollections = new PageCreditCollections(driver);
		// obj_pageCreditCollections.searchTxns();
		obj_pageCreditCollections.searchTxnsWithFilter("Cancellation");
		obj_pageCreditCollections.checkSummaryBar();
		obj_pageCreditCollections.checkPaymentMethod();
		obj_pageCreditCollections.generateAccountStatement();
	}

}
