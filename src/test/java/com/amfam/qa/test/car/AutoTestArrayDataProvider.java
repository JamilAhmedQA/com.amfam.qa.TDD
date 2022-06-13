package com.amfam.qa.test.car;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import utils.ExcelUtils;
import utils.ReadConfigFile;

public class AutoTestArrayDataProvider extends BaseClass {

	@DataProvider(name = "autoData")
	public Object[][] dataObjects() {
		String filePath = ReadConfigFile.getInstance().getExcelPath();
		String sheetName = ReadConfigFile.getInstance().getSheetName();
		ExcelUtils excelUtils = new ExcelUtils(filePath, sheetName);
		return excelUtils.dataTable();
	}

	@Test(dataProvider = "autoData")
	public void carTest(String zipCode, String zipCode2, String insuranceType, String firstName, String middleName,
			String lastName, String dob, String email, String address, String city, String state, String zipCode3,
			String year) {
		landingPage.landingPageSteps(allActions);
		zipCodePage1.zipCodePage1Steps(allActions, zipCode);
		getQuatoPage.getQuatoPageSteps(allActions);
		zipCodePage2.zipCodePage2Steps(allActions, zipCode2, insuranceType);
		policyholderDetails.policyholderDetailsPageSteps(allActions, firstName, middleName.charAt(0), lastName, dob, email,
				address, city, state, zipCode3, year);
		continuePage.continuePageSteps(allActions);

	}

}
