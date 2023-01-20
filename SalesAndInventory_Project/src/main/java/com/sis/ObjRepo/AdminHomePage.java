package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.genericUtility.WebDriverUtility;

public class AdminHomePage {

	
	//Declaration
	@FindBy(xpath = "//span[text()='Customer']")
	private WebElement customer;
	
	@FindBy(xpath = "//a[@href='employee.php']/span[text()='Employee']")
	private WebElement employee;
	
	@FindBy (xpath = "//span[text()='Product']")
	private WebElement product;
	
	@FindBy (xpath = "//span[text()='Inventory']")
	private WebElement inventory;
	
	@FindBy (xpath = "//span[text()='Transaction']")
	private WebElement transaction;
	
	@FindBy (xpath = "//span[text()='Supplier']")
	private WebElement supplier;
	
	@FindBy (xpath = "//span[text()='Accounts']")
	private WebElement accounts;
	
	@FindBy (xpath = "//span[text()='POS']")
	private WebElement POS;
	
	@FindBy (id = "userDropdown")
	private WebElement adminMenuOption;
	
	@FindBy(xpath = "//a[@data-toggle='modal']")
	private WebElement logOut;
	
	@FindBy(linkText = "Logout")
	private WebElement logOutPopup;

	//Initialization
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCustomer() {
		return customer;
	}
	
	public WebElement getEmployee() {
		return employee;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getInventory() {
		return inventory;
	}

	public WebElement getTransaction() {
		return transaction;
	}

	public WebElement getSupplier() {
		return supplier;
	}

	public WebElement getAccounts() {
		return accounts;
	}

	public WebElement getPOS() {
		return POS;
	}

	public WebElement getAdminMenuOption() {
		return adminMenuOption;
	}
	public WebElement getLogOut() {
		return logOut;
	}
	public WebElement getLogOutPopup() {
		return logOutPopup;
	}

	
	//Business Library
	public void customerModule(WebDriverUtility wLib, WebDriver driver) {
		wLib.elementToBeClickable(driver, customer);
		customer.click();
	}
	
	public void employeeModule(WebDriverUtility wLib, WebDriver driver) {
		wLib.elementToBeClickable(driver, employee);
		employee.click();
	}
	
	public void productModule(WebDriverUtility wLib, WebDriver driver) {
		wLib.elementToBeClickable(driver, product);
		product.click();
	}
	
	public void inventoryModule(WebDriverUtility wLib, WebDriver driver) {
		wLib.elementToBeClickable(driver, transaction);
		inventory.click();
	}
	
	public void transactionModule(WebDriverUtility wLib, WebDriver driver) {
		wLib.elementToBeClickable(driver, transaction);
		transaction.click();
	}
	
	public void supplierModule(WebDriverUtility wLib, WebDriver driver) {
		wLib.elementToBeClickable(driver, supplier);
		supplier.click();
	}
	
	public void accountsModule(WebDriverUtility wLib, WebDriver driver) {
		wLib.elementToBeClickable(driver, accounts);
		accounts.click();
	}
	
	public void posModule(WebDriverUtility wLib, WebDriver driver) {
		wLib.elementToBeClickable(driver, POS);
		POS.click();
	}
	
	public void logOutModule(WebDriverUtility wLib, WebDriver driver) {
		wLib.refresh(driver);
		wLib.elementToBeClickable(driver, adminMenuOption);
		adminMenuOption.click();
		wLib.elementToBeClickable(driver, logOut);
		logOut.click();
		logOutPopup.click();
	}
	
}
 