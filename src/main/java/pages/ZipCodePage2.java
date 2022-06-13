package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.AllActions;
import dataProvider.AutoData;

public class ZipCodePage2 {

	public ZipCodePage2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='uid_34']")
	WebElement inputZipCodElement1;
	@FindBy(xpath = "//select[@id='uid_37']")
	WebElement dropDownElement;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement clickonQuoto;
	
	private void inputZipCode1(AllActions allActions, String value) {
		allActions.inputText(inputZipCodElement1, value);	
	}
	
	private void selectTypeOfInsurance(AllActions allActions, String value) {
		allActions.selectByValue(dropDownElement, value);
	}
	
	private void clickonQuoto(AllActions actions) {
		actions.click(clickonQuoto);
	}
	
	public void zipCodePage2Steps(AllActions allActions, String value1,String value) {
		inputZipCode1(allActions, value1);
		selectTypeOfInsurance(allActions, value);
	    clickonQuoto(allActions);
	}
	
	public void zipCodePage2Steps(AllActions allActions, AutoData autoData) {
		inputZipCode1(allActions, autoData.getZipCode2());
		selectTypeOfInsurance(allActions, autoData.getInsuranceType());
	    clickonQuoto(allActions);
	}
	
}
