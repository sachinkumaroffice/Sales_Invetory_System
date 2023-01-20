package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POSPage {

	@FindBy(linkText = "Keyboard")
	private WebElement KeyboardLink;
	
	@FindBy(linkText = "Mouse")
	private WebElement MouseLink;
	
	@FindBy (linkText = "Headset")
	private WebElement HeadsetLink;
	
	@FindBy (linkText = "CPU")
	private WebElement CPULink;
	
	@FindBy (linkText = "Monitor")
	private WebElement MonitorLink;
	
	@FindBy(linkText = "Motherboard")
	private WebElement MotherboardLink;
	
	@FindBy (linkText = "Processor")
	private WebElement ProcessorLink;
	
	@FindBy (linkText = "Power Supply")
	private WebElement PowerSupplyLink;
	
	@FindBy(linkText = "Others")
	private WebElement OthersLink;
	
	@FindBy(xpath = "//h6[@class='text-info']")
	private WebElement productName;
	
	@FindBy(xpath = "//input[@name='quantity']")
	private WebElement QuantityTF;
	
	@FindBy (xpath = "//select[@name='customer']")
	private WebElement customerDD;
	
	@FindBy(xpath = "//div[contains(@class, 'btn-group')]/a[@data-toggle='modal']")
	private WebElement addCustomerButton;
	
	@FindBy(xpath = "//button[text()='SUBMIT']")
	private WebElement submitButton;
	
	@FindBy(id = "txtNumber")
	private WebElement EnterCashTF;
	
	@FindBy (xpath = "//button[text()='PROCEED TO PAYMENT']")
	private WebElement proceedToPaymentButton;
	


	public UserHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getKeyboardLink() {
		return KeyboardLink;
	}

	public WebElement getMouseLink() {
		return MouseLink;
	}

	public WebElement getHeadsetLink() {
		return HeadsetLink;
	}

	public WebElement getCPULink() {
		return CPULink;
	}

	public WebElement getMonitorLink() {
		return MonitorLink;
	}

	public WebElement getMotherboardLink() {
		return MotherboardLink;
	}

	public WebElement getProcessorLink() {
		return ProcessorLink;
	}

	public WebElement getPowerSupplyLink() {
		return PowerSupplyLink;
	}

	public WebElement getOthersLink() {
		return OthersLink;
	}
	public WebElement getProductName() {
		return productName;
	}
	public WebElement getQuantityTF() {
		return QuantityTF;
	}
	public WebElement getCustomerDD() {
		return customerDD;
	}
	public WebElement getAddCustomerButton() {
		return addCustomerButton;
	}
	public WebElement getSubmitButton() {
		return submitButton;
	}
	public WebElement getEnterCashTF() {
		return EnterCashTF;
	}


	public WebElement getProceedToPaymentButton() {
		return proceedToPaymentButton;
	}

}
