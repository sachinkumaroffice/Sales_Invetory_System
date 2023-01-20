package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {

	
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
		public UserLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}

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
		public void loginUser(String Username, String Password) {
			username.sendKeys(Username);
			password.sendKeys(Password);
			loginButton.click();
		}
		public void loginUser1(String Username, String Password) {
			username.sendKeys(Username);
			password.sendKeys(Password);
			rememberMeCheckBox.click();
			loginButton.click();
		}
		
}
