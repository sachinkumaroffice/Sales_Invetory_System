package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.genericUtility.WebDriverUtility;

public class AddEmployeePage {

	
	
	//Declaration
	@FindBy(xpath = "//form[@action='emp_transac.php?action=add']//input[@name='firstname']")
	private WebElement employeeFirstnameTF;
	
	@FindBy(xpath = "//form[@action='emp_transac.php?action=add']//input[@name='lastname']")
	private WebElement employeeLastnameTF;
	
	@FindBy(xpath = "//div[@class='form-group']/select[@name='gender']")
	private WebElement employeeGenderDD;
	
	@FindBy(xpath = "//form[@action='emp_transac.php?action=add']//input[@name='email']")
	private WebElement employeeEmailTF;
	
	@FindBy(xpath = "//form[@action='emp_transac.php?action=add']//input[@name='phonenumber']")
	private WebElement employeePhonenumberTF;
	
	@FindBy(xpath = "//div[@class='form-group']/select[@name='jobs']")
	private WebElement employeeJobDD;
	
	@FindBy (id = "FromDate")
	private WebElement employeeHireddateTF;
	
	@FindBy(id = "province")
	private WebElement employeeProvinceDD;
	
	@FindBy(id = "city")
	private WebElement employeeCityDD;
	
	@FindBy(xpath = "//form[@action='emp_transac.php?action=add']/button[text()='Save']")
	private WebElement employeeSaveButton;
	
	@FindBy(xpath = "(//form[@action='emp_transac.php?action=add']//button[text()='Reset']")
	private WebElement employeeResetButton;
	
	@FindBy(xpath = "(//form[@action='emp_transac.php?action=add']//button[text()='Cancel']")
	private WebElement employeeCancelButton;
	
	@FindBy(xpath = "//h5[text()='Add Employee']/..//button[@class='close']")
	private WebElement employeeCloseOption;
	
	//Initialization
	public AddEmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getEmployeeFirstnameTF() {
		return employeeFirstnameTF;
	}

	public WebElement getEmployeeLastnameTF() {
		return employeeLastnameTF;
	}

	public WebElement getEmployeeGenderDD() {
		return employeeGenderDD;
	}

	public WebElement getEmployeeEmailTF() {
		return employeeEmailTF;
	}

	public WebElement getEmployeePhonenumberTF() {
		return employeePhonenumberTF;
	}

	public WebElement getEmployeeJobDD() {
		return employeeJobDD;
	}

	public WebElement getEmployeeHireddateTF() {
		return employeeHireddateTF;
	}

	public WebElement getEmployeeProvinceDD() {
		return employeeProvinceDD;
	}

	public WebElement getEmployeeCityDD() {
		return employeeCityDD;
	}

	public WebElement getEmployeeSaveButton() {
		return employeeSaveButton;
	}

	public WebElement getEmployeeResetButton() {
		return employeeResetButton;
	}

	public WebElement getEmployeeCancelButton() {
		return employeeCancelButton;
	}

	public WebElement getEmployeeCloseOption() {
		return employeeCloseOption;
	}
	
	//Business Library
	public void detailsOfEmployee(String FirstnameEMP, String LastnameEMP, String GenderEMP, String EmailEMP, String PhonenumberEMP, String JobEMP, WebDriverUtility wLib) {
		employeeFirstnameTF.sendKeys(FirstnameEMP);
		employeeLastnameTF.sendKeys(LastnameEMP);
		wLib.select(GenderEMP, employeeGenderDD);
		employeeEmailTF.sendKeys(EmailEMP);
		employeePhonenumberTF.sendKeys(PhonenumberEMP);
		wLib.select(JobEMP, employeeJobDD);
		employeeHireddateTF.click();
	}
	public void provinceCityEmployee(String ProvinceEMP, String CityEMP, WebDriverUtility wLib, WebDriver driver) {
		wLib.select(ProvinceEMP, employeeProvinceDD);
		wLib.select(CityEMP, employeeCityDD);
	}
	public void saveEmployee() {
		employeeSaveButton.submit();
	}
	public void closeEmployee() {
		employeeCloseOption.click();
	}
	public void cancelEmployee() {
		employeeCancelButton.click();
	}
	public void resetEmployee(String FirstnameEMP, String LastnameEMP, String GenderEMP, String EmailEMP, String PhonenumberEMP, String JobEMP, String ProvinceEMP, String CityEMP, WebDriverUtility wLib) {
		employeeFirstnameTF.sendKeys(FirstnameEMP);
		employeeLastnameTF.sendKeys(LastnameEMP);
		wLib.select(GenderEMP, employeeGenderDD);
		employeeEmailTF.sendKeys(EmailEMP);
		employeePhonenumberTF.sendKeys(PhonenumberEMP);
		wLib.select(JobEMP, employeeJobDD);
		
		wLib.select(employeeProvinceDD, ProvinceEMP);
		wLib.select(employeeCityDD, CityEMP);
		employeeSaveButton.click();
		
	}
	
}
