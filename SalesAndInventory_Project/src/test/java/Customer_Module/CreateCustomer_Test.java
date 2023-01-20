package Customer_Module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sis.genericUtility.ExcelUtility;
import com.sis.genericUtility.FileUtility;
import com.sis.genericUtility.WebDriverUtility;

public class CreateCustomer_Test {
public static void main(String[] args) throws Throwable {
	WebDriverUtility wLib = new WebDriverUtility();
	ExcelUtility eLib = new ExcelUtility();
	FileUtility fLib = new FileUtility();
	
	String URL = fLib.readDataFromPropertyFile("url");
	String USERNAME = fLib.readDataFromPropertyFile("username");
	String PASSWORD = fLib.readDataFromPropertyFile("password");
	
	
	FirefoxDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.name("user")).sendKeys(USERNAME);
	driver.findElement(By.name("password")).sendKeys(PASSWORD);
	driver.findElement(By.name("btnlogin")).click();
	driver.switchTo().alert().accept();
	WebElement customerModule = driver.findElement(By.xpath("//span[text()='Customer']"));
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(customerModule));
	customerModule.click();
	driver.findElement(By.xpath("//h4[contains(text(),'Customer')]/..//a[@data-toggle='modal']")).click();
	driver.findElement(By.xpath("//form[@action='cust_transac.php?action=add']//input[@name='firstname']")).sendKeys(eLib.readDataFromExcel("Customer_Details", 0, 1));
	driver.findElement(By.xpath("//form[@action='cust_transac.php?action=add']//input[@name='lastname']")).sendKeys(eLib.readDataFromExcel("Customer_Details", 1, 1));
	driver.findElement(By.xpath("//form[@action='cust_transac.php?action=add']//input[@name='phonenumber']")).sendKeys(eLib.readDataFromExcel("Customer_Details", 2, 1));
	driver.findElement(By.xpath("(//h5[text()='Add Customer']/../..//button[@type='submit'])[1]")).click();
	WebElement adminMenuOption = driver.findElement(By.id("userDropdown"));
	wait.until(ExpectedConditions.elementToBeClickable(adminMenuOption));
	adminMenuOption.click();
	WebElement logoutOption = driver.findElement(By.xpath("//a[@data-toggle='modal']"));
	wait.until(ExpectedConditions.elementToBeClickable(logoutOption));
	logoutOption.click();
	driver.findElement(By.linkText("Logout")).click();
	driver.quit();
}
}
