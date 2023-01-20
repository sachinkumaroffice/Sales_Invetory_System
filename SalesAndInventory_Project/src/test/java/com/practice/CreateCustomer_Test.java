package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCustomer_Test {
public static void main(String[] args) throws Throwable {
	  Random ran = new Random();
	  int random = ran.nextInt(500);
	
	//Step:1 Get Common Data
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties pObj = new Properties();
	pObj.load(fis);
	String url = pObj.getProperty("url");
	String username = pObj.getProperty("username");
	String password = pObj.getProperty("password");
	
	//Step2: Read Data from excel sheet
	FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\Customer_SIS.xlsx");
	Workbook workbook = WorkbookFactory.create(fis1);
	Sheet sheet = workbook.getSheet("Add_Customer");
	
	
	
	
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	// Login To Application
	driver.findElement(By.name("user")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.name("btnlogin")).click();
	driver.switchTo().alert().accept();
	
	// Create Customer
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='accordionSidebar']//a[@class='nav-link']/span[text()='Customer']")));
	 WebElement customerButton = driver.findElement(By.xpath("//ul[@id='accordionSidebar']//a[@class='nav-link']/span[text()='Customer']"));
	 customerButton.click();
	WebElement addCustomerButton = driver.findElement(By.xpath("//a[@type='button']/..//i[@class='fas fa-fw fa-plus']"));
	addCustomerButton.click();
	
	
	ArrayList<String> list = new ArrayList<String>();
	list.add("firstname");
	list.add("lastname");
	list.add("phonenumber");
	String actualdata=null;
	for (int i = 0; i <sheet.getLastRowNum(); i++) {
		String value = sheet.getRow(i).getCell(1).getStringCellValue()+random;
				driver.findElement(By.name(list.get(i))).sendKeys(value);
				actualdata=value;
				
		
	}
	WebElement saveTheData = driver.findElement(By.xpath("//button[@type='submit']"));
		saveTheData.submit();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row']//input[@type='search']")));
	 driver.findElement(By.xpath("//div[@class='row']//input[@type='search']")).sendKeys(actualdata);
	 String expecteddata = driver.findElement(By.xpath("//td[text()='"+actualdata+"']")).getText();
	 if(actualdata.equals(expecteddata))
	 {
		 System.out.println("result is found");
	 }else {
		 System.out.println("result not found");
	 }
//	if (searchOption.isEnabled()) {
	//searchOption.sendKeys(sheet.getRow(0).getCell(1).getStringCellValue());
//	} else {
//          System.out.println("Search option is in disabled mode");
//	}
//	
	 System.out.println("Test has been completed");
	 driver.quit();
		
	}
	
}
