package Employee_Module;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sis.genericUtility.ExcelUtility;
import com.sis.genericUtility.FileUtility;
import com.sis.genericUtility.WebDriverUtility;

public class CreateEmployee_Test {
	public static void main(String[] args) throws Throwable {
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		
		String FirstNameTF = eLib.readDataFromExcel("Employee_Details", 0, 1);
		String LastNameTF = eLib.readDataFromExcel("Employee_Details", 1, 1);
		String gender = eLib.readDataFromExcel("Employee_Details", 2, 1);
		String emailTF = eLib.readDataFromExcel("Employee_Details", 3, 1);
		String PhoneNumberTF = eLib.readDataFromExcel("Employee_Details", 4, 1);
		String job = eLib.readDataFromExcel("Employee_Details", 5, 1);
		String province = eLib.readDataFromExcel("Employee_Details", 6, 1);
		String city = eLib.readDataFromExcel("Employee_Details", 7, 1);
		
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("btnlogin")).click();
		driver.switchTo().alert().accept();
		WebElement employeeModule = driver.findElement(By.xpath("//span[text()='Employee']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(employeeModule));
		employeeModule.click();
		driver.findElement(By.xpath("//h4[contains(text(),'Employee')]/..//a[@data-toggle='modal']")).click();
		driver.findElement(By.xpath("//form[@action='emp_transac.php?action=add']//input[@name='firstname']")).sendKeys(FirstNameTF);
		driver.findElement(By.xpath("//form[@action='emp_transac.php?action=add']//input[@name='lastname']")).sendKeys(LastNameTF);
		WebElement genderDD = driver.findElement(By.xpath("//div[@class='form-group']/select[@name='gender']"));
		wLib.select(gender, genderDD);
		driver.findElement(By.xpath("//form[@action='emp_transac.php?action=add']//input[@name='email']")).sendKeys(emailTF);
		driver.findElement(By.xpath("//form[@action='emp_transac.php?action=add']//input[@name='phonenumber']")).sendKeys(PhoneNumberTF);
		WebElement jobDD = driver.findElement(By.xpath("//div[@class='form-group']/select[@name='jobs']"));
		wLib.select(job, jobDD);
		driver.findElement(By.id("FromDate")).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_1);
		robot.keyPress(KeyEvent.VK_2);
		robot.keyPress(KeyEvent.VK_0);
		robot.keyPress(KeyEvent.VK_1);
		robot.keyPress(KeyEvent.VK_2);
		robot.keyPress(KeyEvent.VK_0);
		robot.keyPress(KeyEvent.VK_2);
		robot.keyPress(KeyEvent.VK_3);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement provinceDD = driver.findElement(By.id("province"));
		wLib.select(province, provinceDD);
		WebElement cityDD = driver.findElement(By.id("city"));
		wLib.select(city, cityDD);
		driver.findElement(By.xpath("//form[@action='emp_transac.php?action=add']/button[text()='Save']")).click();
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
