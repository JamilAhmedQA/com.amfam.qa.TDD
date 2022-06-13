package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.AllActions;
import dataProvider.AutoData;

public class ZipCodePage1 {
	
	public ZipCodePage1(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(id = "uid_54")
	WebElement inputZipCodeElement;
	@FindBy(xpath = "(//span[@class='LoadingButton__content'])[1]")
	WebElement clickonStartQuotElement;
	
	private void inputZipCode(AllActions allActions, String value) {
		allActions.inputText(inputZipCodeElement, value);
	}
	
	private void clickonStartQuot(AllActions allActions) {
		allActions.click(clickonStartQuotElement);
	}
	
	public void zipCodePage1Steps(AllActions allActions, String zipString) {
		inputZipCode(allActions, zipString);
		clickonStartQuot(allActions);
	}
	
	public void zipCodePage1Steps(AllActions allActions, AutoData autoData) {
		inputZipCode(allActions, autoData.getZipCode());
		clickonStartQuot(allActions);
	}

}
