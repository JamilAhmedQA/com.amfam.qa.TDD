package com.amfam.qa.test.car;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import base.BaseClass;

public class CarTest extends BaseClass {

//	@Test(enabled = true, priority = 1, groups = {"jamil"})
//	public void carTest() {
//		landingPage.landingPageSteps(allActions);
//		zipCodePage1.zipCodePage1Steps(allActions, "11416");
//		getQuatoPage.getQuatoPageSteps(allActions);
//		zipCodePage2.zipCodePage2Steps(allActions, "11416", "A");
//		policyholderDetails.policyholderDetailsPageSteps(allActions, "Mohammad", 'J', "Ahmed", "06/03/1991",
//				"batman_95@yahoo.com","8434 102nd AVE", "Ozone park","NY", "11416", "2016");
//		continuePage.continuePageSteps(allActions);
//	}
//	
	
	@Test(enabled = true, priority = 1, groups = {"david"})
	public void carTest2() {
		landingPage.landingPageSteps(allActions);
		zipCodePage1.zipCodePage1Steps(allActions, "11417");
		getQuatoPage.getQuatoPageSteps(allActions);
		zipCodePage2.zipCodePage2Steps(allActions, "11417", "A");
		policyholderDetails.policyholderDetailsPageSteps(allActions, "David", 'J', "Ahmed", "06/03/1985",
				"batman_95@yahoo.com","10351 104th st", "Ozone park","NY", "11417", "2016");
		continuePage.continuePageSteps(allActions);
	}
	
	@Test(enabled = true, priority = 1, groups = {"zayson"})
	public void carTest3() {
		landingPage.landingPageSteps(allActions);
		zipCodePage1.zipCodePage1Steps(allActions, "11417");
		getQuatoPage.getQuatoPageSteps(allActions);
		zipCodePage2.zipCodePage2Steps(allActions, "11417", "A");
		policyholderDetails.policyholderDetailsPageSteps(allActions, "Zayson", 'J', "Ahmed", "06/03/1965",
				"batman_95@yahoo.com","10351 104th st", "Ozone park","NY", "11417", "2016");
		continuePage.continuePageSteps(allActions);
	}
}
