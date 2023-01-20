 package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.genericUtility.WebDriverUtility;

public class AdminLoginPage extends WebDriverUtility {

	
	//Declaration
	@FindBy(name = "user")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = "//label[@for='customCheck']")
	private WebElement rememberMeCheckBox;
	
	@FindBy (name= "btnlogin")
	private WebElement loginButton;
	
	//Initialization
	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getRememberMeCheckBox() {
		return rememberMeCheckBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//Business Library
	public void adminLoginPage(String Username, String Password, WebDriverUtility wLib, WebDriver driver) {
		username.sendKeys(Username);
		password.sendKeys(Password);
		rememberMeCheckBox.click();
		loginButton.click();
		wLib.acceptAlert(driver);
	}
	
	public void adminLoginPage(WebDriver driver, String Username, String Password, WebDriverUtility wLib) {
		username.sendKeys(Username);
		password.sendKeys(Password);
		loginButton.click();
		wLib.acceptAlert(driver);
	}
	
}
