package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.genericUtility.WebDriverUtility;

public class AddProductPage {

	
	@FindBy(name = "prodcode")
	private WebElement productCodeTF;
	
	@FindBy(name = "name")
	private WebElement nameTF;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement descriptionTA;
	
	@FindBy (name = "quantity")
	private WebElement quantityTF;
	
	@FindBy(name = "onhand")
	private WebElement onhandTF;
	
	@FindBy(name = "price")
	private WebElement priceTF;
	
	@FindBy(name = "category")
	private WebElement categoryDD;
	
	@FindBy (name = "supplier")
	private WebElement supplierDD;
	
	@FindBy(name = "datestock")
	private WebElement dateStockInButton;
	
	@FindBy(xpath = "//form[@action='pro_transac.php?action=add']/button[text()='Save']")
	private WebElement saveButtonProd;
	
	@FindBy(xpath = "//form[@action='pro_transac.php?action=add']/button[text()='Reset']")
	private WebElement resetButtonProd;
	
	@FindBy(xpath = "//form[@action='pro_transac.php?action=add']/button[text()='Cancel']")
	private WebElement cancelButtonProd;
	
	@FindBy(xpath = "//h5[text()='Add Product']/..//button[@class='close']")
	private WebElement closeOptionProd;
	
	//Initialization
	public AddProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getProductCodeTF() {
		return productCodeTF;
	}

	public WebElement getNameTF() {
		return nameTF;
	}

	public WebElement getDescriptionTA() {
		return descriptionTA;
	}

	public WebElement getQuantityTF() {
		return quantityTF;
	}

	public WebElement getOnhandTF() {
		return onhandTF;
	}

	public WebElement getPriceTF() {
		return priceTF;
	}

	public WebElement getCategoryDD() {
		return categoryDD;
	}

	public WebElement getSupplierDD() {
		return supplierDD;
	}

	public WebElement getDateStockInButton() {
		return dateStockInButton;
	}

	public WebElement getSaveButtonProd() {
		return saveButtonProd;
	}

	public WebElement getResetButtonProd() {
		return resetButtonProd;
	}

	public WebElement getCancelButtonProd() {
		return cancelButtonProd;
	}

	public WebElement getCloseOptionProd() {
		return closeOptionProd;
	}
	
	//Business Library
	public void detailsOfProduct(String Productcode, String Name, String Description, String Quantity, String Onhand, String Price, WebDriverUtility wLib, String Category, String Supplier) {
		productCodeTF.sendKeys(Productcode);
		nameTF.sendKeys(Name);
		descriptionTA.sendKeys(Description);
		quantityTF.sendKeys(Quantity);
		onhandTF.sendKeys(Onhand);
		priceTF.sendKeys(Price);
		wLib.select(Category, categoryDD);
		wLib.select(Supplier, supplierDD);
		dateStockInButton.click();
	}
	public void saveProduct() {
		saveButtonProd.click();
	}
	public void resetProduct() {
		resetButtonProd.click();
	}
	public void resetProduct(String Productcode, String Name, String Description, String Quantity, String Onhand, String Price, WebDriverUtility wLib, String Category, String Supplier) {
		productCodeTF.sendKeys(Productcode);
		nameTF.sendKeys(Name);
		descriptionTA.sendKeys(Description);
		quantityTF.sendKeys(Quantity);
		onhandTF.sendKeys(Onhand);
		priceTF.sendKeys(Price);
		wLib.select(Category, categoryDD);
		wLib.select(Supplier, supplierDD);
		dateStockInButton.click();
	}
	public void cancelProd() {
		cancelButtonProd.click();
	}
	public void closeProd() {
		closeOptionProd.click();
	}
}
