package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.AllActions;
import dataProvider.AutoData;

public class PolicyholderDetails {

	public PolicyholderDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "F_PH_FirstName_0")
	WebElement firstNamElement;
	@FindBy(id = "F_PH_MiddleInitial_0")
	WebElement middleNamElement;
	@FindBy(id = "F_PH_LastName_0")
	WebElement lastNamElement;
	@FindBy(id = "F_PH_DOB_0")
	WebElement dobElement;
	@FindBy(id = "F_PH_email_0")
	WebElement emailElement;
	@FindBy(id = "F_street_0")
	WebElement addressElement;
	@FindBy(id = "F_city_0")
	WebElement cityElement;
	@FindBy(id = "F_state_0")
	WebElement stateElement;
	@FindBy(id = "F_zipCode_0")
	WebElement zipElement;
	@FindBy(id = "F_livingYear_0")
	WebElement livingDurationElement;
	@FindBy(xpath = "//span[contains(.,'Continue')] ")
	WebElement continueElement;

	private void inputFirstName(AllActions allActions, String firstName) {
		allActions.inputText(firstNamElement, firstName);
	}

	private void inputMiddleName(AllActions allActions, char middleName) {
		allActions.inputText(middleNamElement, middleName);
	}

	private void inputLastName(AllActions allActions, String lastName) {
		allActions.inputText(lastNamElement, lastName);
	}

	private void inputDob(AllActions allActions, String dob) {
		allActions.inputText(dobElement, dob);
	}

	private void inputEmail(AllActions allActions, String email) {
		allActions.inputText(emailElement, email);
	}

	private void inputAddress(AllActions allActions, String address) {
		allActions.inputText(addressElement, address);
	}

	private void inputCity(AllActions allActions, String city) {
		allActions.inputText(cityElement, city);
	}

	private void selectState(AllActions allActions, String state) {
		allActions.selectByValue(stateElement, state);
	}

	private void inputZipCode(AllActions allActions, String zipString) {
		allActions.inputText(zipElement, zipString);
	}

	private void inputYear(AllActions allActions, String livingDuration) {
		allActions.inputText(livingDurationElement, livingDuration);
	}

	private void clickOnContinue(AllActions allActions) {
		allActions.click(continueElement);
	}

	public void policyholderDetailsPageSteps(AllActions allActions, String firstName, char middleName, String lastName,
			String dob, String email, String address, String city, String state, String zipString,
			String livingDuration) {
		inputFirstName(allActions, firstName);
		inputMiddleName(allActions, middleName);
		inputLastName(allActions, lastName);
		inputDob(allActions, dob);
		inputEmail(allActions, email);
		inputAddress(allActions, address);
		inputCity(allActions, city);
		selectState(allActions, state);
		inputZipCode(allActions, zipString);
		inputYear(allActions, livingDuration);
		clickOnContinue(allActions);
	}

	public void policyholderDetailsPageSteps(AllActions allActions, AutoData autoData) {
		inputFirstName(allActions, autoData.getFirstName());
		inputMiddleName(allActions, autoData.getMiddleName());
		inputLastName(allActions, autoData.getLastName());
		inputDob(allActions, autoData.getDob());
		inputEmail(allActions, autoData.getEmail());
		inputAddress(allActions, autoData.getAddress());
		inputCity(allActions, autoData.getCity());
		selectState(allActions, autoData.getState());
		inputZipCode(allActions, autoData.getZipCode3());
		inputYear(allActions, autoData.getYear());
		clickOnContinue(allActions);
	}

}
