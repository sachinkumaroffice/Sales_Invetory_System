package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.genericUtility.WebDriverUtility;

public class AddUserAccountsPage {

	
	@FindBy(name = "empid")
	private WebElement selectEmployeeDDAccounts;
	
	@FindBy(xpath = "//div[@class='form-group']/input[@name='username']")
	private WebElement usernameTFAccounts;
	
	@FindBy(xpath = "//div[@class='form-group']/input[@name='password']")
	private WebElement passwordTFAccounts;
	
	@FindBy(xpath = "//form[@action='us_transac.php?action=add']/button[@type='submit']")
	private WebElement saveButtonAccounts;
	
	@FindBy(xpath = "//form[@action='us_transac.php?action=add']/button[@type='reset']")
	private WebElement resetButtonAccounts;
	
	@FindBy(xpath = "//form[@action='us_transac.php?action=add']/button[text()='Cancel']")
	private WebElement cancelButtonAccounts;
	
	@FindBy(xpath = "//h5[text()='Add User Account']/..//button[@class='close']")
	private WebElement closeOptionAccounts;
	
	public AddUserAccountsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSelectEmployeeDDAccounts() {
		return selectEmployeeDDAccounts;
	}

	public WebElement getUsernameTFAccounts() {
		return usernameTFAccounts;
	}

	public WebElement getPasswordTFAccounts() {
		return passwordTFAccounts;
	}

	public WebElement getSaveButtonAccounts() {
		return saveButtonAccounts;
	}

	public WebElement getResetButtonAccounts() {
		return resetButtonAccounts;
	}

	public WebElement getCancelButtonAccounts() {
		return cancelButtonAccounts;
	}

	public WebElement getCloseOptionAccounts() {
		return closeOptionAccounts;
	}
	
	//Business Library
	public void detailsOfUserAccounts(WebDriverUtility wLib, String Username, String Password) {
		wLib.select(selectEmployeeDDAccounts, 5);
		usernameTFAccounts.sendKeys(Username);
		passwordTFAccounts.sendKeys(Password);
		saveButtonAccounts.click();
	}
	public void resetAccountDetails(WebDriverUtility wLib, String Username, String Password) {
		wLib.select(selectEmployeeDDAccounts, 5);
		usernameTFAccounts.sendKeys(Username);
		passwordTFAccounts.sendKeys(Password);
		resetButtonAccounts.click();
	}
	public void cancelAccounts() {
		cancelButtonAccounts.click();
	}
	public void closeAccounts() {
		closeOptionAccounts.click();
	}
}
