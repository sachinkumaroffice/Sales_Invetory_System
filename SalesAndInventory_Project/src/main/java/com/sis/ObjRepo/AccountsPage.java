 package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {

	
	@FindBy(name = "dataTable_length")
	private WebElement showEntriesDDAccounts;
	
	@FindBy(xpath = "//label[text()='Search:']/..//input[@type='search']")
	private WebElement searchOptionAccounts;
	
	@FindBy(xpath = "//h4[contains(text(),'User Accounts')]/a[@data-toggle='modal']")
	private WebElement adduserAccountsButton;
	
	@FindBy(id = "dataTable_next")
	private WebElement nextButtonAdminAccounts;
	
	public AccountsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getShowEntriesDDAccounts() {
		return showEntriesDDAccounts;
	}

	public WebElement getSearchOptionAccounts() {
		return searchOptionAccounts;
	}

	public WebElement getAdduserAccountsButton() {
		return adduserAccountsButton;
	}

	public WebElement getNextButtonAdminAccounts() {
		return nextButtonAdminAccounts;
	}
	
	//Business Library
	public void addUserAccount() {
		adduserAccountsButton.click();
	}
	public void searchAdminAccount(String Name) {
		searchOptionAccounts.sendKeys(Name);
	}
	public void searchAdminAccount1(String Username) {
		searchOptionAccounts.sendKeys(Username);
	}
	public void searchAdminAccount2(String Type) {
		searchOptionAccounts.sendKeys(Type);
	}
	public void nextAdmin() {
		nextButtonAdminAccounts.click();
	}
}
