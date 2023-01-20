package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.genericUtility.WebDriverUtility;

public class CustomerPage {

	
	//Declaration
	@FindBy(xpath = "//h4[contains(text(),'Customer')]/..//a[@data-toggle='modal']")
	private WebElement addCustomerButton;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchOption;
	
	@FindBy(name = "dataTable_length")
	private WebElement showEntriesDD;
	
	@FindBy(linkText = "Next")
	private WebElement nextButton;
	
	//Initialization
	public CustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getAddCustomerButton() {
		return addCustomerButton;
	}

	public WebElement getSearchOption() {
		return searchOption;
	}

	public WebElement getShowEntriesDD() {
		return showEntriesDD;
	}

	public WebElement getNextButton() {
		return nextButton;
	}
	
	//Business Library
	public void addCustomer() {
		addCustomerButton.click();
	}
	
	public void showEntries(WebDriverUtility wLib) {
		wLib.select(showEntriesDD, 0);
	}
	
	public void showEntries1(WebDriverUtility wLib) {
		wLib.select(showEntriesDD, 1);
	}
	
	public void showEntries2(WebDriverUtility wLib) {
		wLib.select(showEntriesDD, 2);
	}
	
	public void showEntries3(WebDriverUtility wLib) {
		wLib.select(showEntriesDD, 3);
	}
	
	public void searchFirstName(String firstname) {
		searchOption.sendKeys(firstname);
	}
	
	public void searchLastName(String lastname) {
		searchOption.sendKeys(lastname);
	}
	
	public void searchPhoneNumber(String Phonenumber) {
		searchOption.sendKeys(Phonenumber);
	}
	
	public void next() {
		nextButton.click();
	}
}
