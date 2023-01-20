package Accounts_Module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sis.genericUtility.ExcelUtility;
import com.sis.genericUtility.FileUtility;
import com.sis.genericUtility.WebDriverUtility;

public class CreateUserAccount_Test {
	public static void main(String[] args) throws Throwable {
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
	
		String employee = eLib.readDataFromExcel("User_Accounts_Details", 0, 1);
		String username = eLib.readDataFromExcel("User_Accounts_Details", 1, 1);
		String password = eLib.readDataFromExcel("User_Accounts_Details", 2, 1);
		
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("btnlogin")).click();
		driver.switchTo().alert().accept();
		WebElement supplierModule = driver.findElement(By.xpath("//span[text()='Accounts']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(supplierModule));
		supplierModule.click();
		driver.findElement(By.xpath("//h4[contains(text(),'User Accounts')]/a[@data-toggle='modal']")).click();
		WebElement selectEmployeeDD = driver.findElement(By.name("empid"));
		wLib.select(selectEmployeeDD, 5);
		driver.findElement(By.xpath("//div[@class='form-group']/input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//div[@class='form-group']/input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//form[@action='us_transac.php?action=add']/button[@type='submit']")).click();
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
