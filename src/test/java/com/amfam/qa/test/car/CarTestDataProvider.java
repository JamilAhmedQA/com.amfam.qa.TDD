package com.amfam.qa.test.car;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.AutoData;

public class CarTestDataProvider extends BaseClass {

	@DataProvider(name = "autoData")
	public Iterator<AutoData> autoData() {
		ArrayList<AutoData> list = new ArrayList<AutoData>();
		AutoData kashemInfo = new AutoData("11417", "11417", "A", "kashem", 'J', "Ahmed", "06/03/1985",
				"batman_95@yahoo.com", "10351 104th st", "Ozone park", "NY", "11417", "2016");
		list.add(kashemInfo);
		return list.iterator();
	}

	@Test(enabled = true, priority = 1, dataProvider = "autoData")
	public void carTest2(AutoData autoData) {
		landingPage.landingPageSteps(allActions);
		zipCodePage1.zipCodePage1Steps(allActions, autoData);
		getQuatoPage.getQuatoPageSteps(allActions);
		zipCodePage2.zipCodePage2Steps(allActions, autoData);
		policyholderDetails.policyholderDetailsPageSteps(allActions, autoData);
		continuePage.continuePageSteps(allActions);
	}

}
