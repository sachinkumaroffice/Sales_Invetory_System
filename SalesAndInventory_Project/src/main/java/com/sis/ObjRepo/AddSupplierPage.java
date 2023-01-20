package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.genericUtility.WebDriverUtility;

public class AddSupplierPage {

	
	@FindBy(name = "companyname")
	private WebElement supplierCompanynameTF;
	
	@FindBy(xpath = "//form[@action='sup_transac.php?action=add']//select[@id='province']")
	private WebElement supplierProvinceDD;
	
	@FindBy(xpath = "//form[@action='sup_transac.php?action=add']//select[@id='city']")
	private WebElement supplierCityDD;
	
	@FindBy(xpath = "//form[@action='sup_transac.php?action=add']//input[@name='phonenumber']")
	private WebElement supplierPhonenumberTF;
	
	@FindBy(xpath = "//form[@action='sup_transac.php?action=add']/button[text()='Save']")
	private WebElement supplierSaveButton;
	
	@FindBy(xpath = "//form[@action='sup_transac.php?action=add']/button[text()='Reset']")
	private WebElement supplierResetButton;
	
	@FindBy(xpath = "//form[@action='sup_transac.php?action=add']/button[text()='Cancel']")
	private WebElement supplierCancelButton;
	
	@FindBy(xpath = "//h5[text()='Add Supplier']/..//button[@class='close']")
	private WebElement supplierCloseOption;
	
	public AddSupplierPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSupplierCompanynameTF() {
		return supplierCompanynameTF;
	}

	public WebElement getSupplierProvinceDD() {
		return supplierProvinceDD;
	}

	public WebElement getSupplierCityDD() {
		return supplierCityDD;
	}

	public WebElement getSupplierPhonenumberTF() {
		return supplierPhonenumberTF;
	}

	public WebElement getSupplierSaveButton() {
		return supplierSaveButton;
	}

	public WebElement getSupplierResetButton() {
		return supplierResetButton;
	}

	public WebElement getSupplierCancelButton() {
		return supplierCancelButton;
	}

	public WebElement getSupplierCloseOption() {
		return supplierCloseOption;
	}
	
	//Business Library
	public void saveSupplier(String CompanynameSUPP, String ProvinceSUPP, String CitySUPP, String PhonenumberSupp, WebDriverUtility wLib) {
		supplierCompanynameTF.sendKeys(CompanynameSUPP);
		wLib.select(ProvinceSUPP, supplierProvinceDD);
		wLib.select(CitySUPP, supplierCityDD);
		supplierPhonenumberTF.sendKeys(PhonenumberSupp);
		supplierSaveButton.click();
	}
	
	public void resetSupplier(String CompanynameSUPP, String ProvinceSUPP, String CitySUPP, String PhonenumberSupp, WebDriverUtility wLib) {
		supplierCompanynameTF.sendKeys(CompanynameSUPP);
		wLib.select(ProvinceSUPP, supplierProvinceDD);
		wLib.select(CitySUPP, supplierCityDD);
		supplierPhonenumberTF.sendKeys(PhonenumberSupp);
		supplierResetButton.click();
	}
	
	public void cancelSupplier() {
		supplierCancelButton.click();
	}
	
	public void closeSupplier() {
		supplierCloseOption.click();
	}
}
