package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.genericUtility.ExcelUtility;
import com.sis.genericUtility.JavaUtility;

public class AddCustomerPage {

	
	//Declaration
	@FindBy(xpath = "(//h5[text()='Add Customer']/../..//input[@name='firstname'])[1]")
	private WebElement firstnameTF;
	
	@FindBy(xpath = "(//h5[text()='Add Customer']/../..//input[@name='lastname'])[1]")
	private WebElement lastnameTF;
	
	@FindBy(xpath = "//form[@action='cust_transac.php?action=add']//input[@name='phonenumber']")
	private WebElement phonenumberTF;
	
	@FindBy (xpath = "(//h5[text()='Add Customer']/../..//button[@type='submit'])[1]")
	private WebElement saveButton;
	
	@FindBy(xpath = "(//h5[text()='Add Customer']/../..//button[@type='reset'])[1]")
	private WebElement resetButton;
	
	@FindBy (xpath = "(//h5[text()='Add Customer']/../..//button[text()='Cancel'])[1]")
	private WebElement cancelButton;
	
	@FindBy(xpath = "(//h5[text()='Add Customer']/../..//button[@class='close'])[1]")
	private WebElement closeOption;
	
	//Initialization
	public AddCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getFirstnameTF() {
		return firstnameTF;
	}

	public WebElement getLastnameTF() {
		return lastnameTF;
	}

	public WebElement getPhonenumberTF() {
		return phonenumberTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getResetButton() {
		return resetButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getCloseOption() {
		return closeOption;
	}
	
	
	//Business Library
	public void addCustomer(String Sheetname, ExcelUtility eLib, JavaUtility jLib) throws Throwable {
		firstnameTF.sendKeys(eLib.readDataFromExcel(Sheetname, 0, 1));
		lastnameTF.sendKeys(eLib.readDataFromExcel(Sheetname, 1, 1));
		phonenumberTF.sendKeys(eLib.readDataFromExcel(Sheetname, 2, 1));
		saveButton.click();
	}
	
	public void addCustomer1(String Sheetname, ExcelUtility eLib, JavaUtility jLib) throws Throwable {
		firstnameTF.sendKeys(eLib.readDataFromExcel(Sheetname, 0, 1)+jLib.getRanDomNumber());
		lastnameTF.sendKeys(eLib.readDataFromExcel(Sheetname, 1, 1)+jLib.getRanDomNumber());
		saveButton.click();
	}
	public void addCustomerCancel() {
		cancelButton.click();
	}
	public void addCustomerReset(String Sheetname, ExcelUtility eLib, JavaUtility jLib) throws Throwable {
		firstnameTF.sendKeys(eLib.readDataFromExcel(Sheetname, 0, 1)+jLib.getRanDomNumber());
		lastnameTF.sendKeys(eLib.readDataFromExcel(Sheetname, 1, 1)+jLib.getRanDomNumber());
		phonenumberTF.sendKeys(eLib.readDataFromExcel(Sheetname, 2, 1));
		resetButton.click();
	}
	public void addCustomerClose() {
		closeOption.click();
	}
	
	
}
