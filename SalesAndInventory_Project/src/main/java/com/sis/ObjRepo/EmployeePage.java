package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.genericUtility.WebDriverUtility;

public class EmployeePage {

	
	//Declaration
		@FindBy(xpath = "//h4[contains(text(),'Employee')]/..//a[@data-toggle='modal']")
		private WebElement addEmployeeButton;
		
		@FindBy(xpath = "//input[@type='search']")
		private WebElement searchOption;
		
		@FindBy(name = "dataTable_length")
		private WebElement showEntriesDD;
		
		@FindBy(linkText = "Next")
		private WebElement nextButton;
		
		//Initialization
		public EmployeePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		
		//Utilization
		public WebElement getAddEmployeeButton() {
			return addEmployeeButton;
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
		public void addEmployee(WebDriverUtility wLib, WebDriver driver) {
			wLib.elementToBeClickable(driver, addEmployeeButton);
			addEmployeeButton.click();
		}
		
		public void searchFirstName(String firstname) {
			searchOption.sendKeys(firstname);
		}
		
		public void searchLastName(String lastname) {
			searchOption.sendKeys(lastname);
		}
		
		public void searchPhoneNumber(String Role) {
			searchOption.sendKeys(Role);
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
