package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.genericUtility.WebDriverUtility;

public class ProductPage {

	
	//Declaration
	@FindBy(xpath = "//h4[contains(text(),'Product')]/..//a[@data-toggle='modal']")
	private WebElement addProductButton;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchOption;
	
	@FindBy(name = "dataTable_length")
	private WebElement showEntriesDD;
	
	@FindBy(linkText = "Next")
	private WebElement nextButton;
	
	//Initialization
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	public WebElement getAddProductButton() {
		return addProductButton;
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
	public void addProduct() {
		addProductButton.click();
	}
	
	public void searchFirstName(String ProductCode) {
		searchOption.sendKeys(ProductCode);
	}
	
	public void searchLastName(String Name) {
		searchOption.sendKeys(Name);
	}
	
	public void searchPhoneNumber(String Price) {
		searchOption.sendKeys(Price);
	}
	public void searchCategory(String Category) {
		searchOption.sendKeys(Category);
	}
	
	public void next() {
		nextButton.click();
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
}
