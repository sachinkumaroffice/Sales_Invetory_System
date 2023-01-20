package Product_Module;

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

public class CreateProduct_Test {
	public static void main(String[] args) throws Throwable {
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
	
		String ProdCode = eLib.readDataFromExcel("Product_Details", 0, 1);
		String Name = eLib.readDataFromExcel("Product_Details", 1, 1);
		String Description = eLib.readDataFromExcel("Product_Details", 2, 1);
		String Quantity = eLib.readDataFromExcel("Product_Details", 3, 1);
		String Onhand = eLib.readDataFromExcel("Product_Details", 4, 1);
		String Price = eLib.readDataFromExcel("Product_Details", 5, 1);
		String Category = eLib.readDataFromExcel("Product_Details", 6, 1);
		String Supplier = eLib.readDataFromExcel("Product_Details", 7, 1);
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("btnlogin")).click();
		driver.switchTo().alert().accept();
		
		WebElement productModule = driver.findElement(By.xpath("//span[text()='Product']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(productModule));
		productModule.click();
		driver.findElement(By.xpath("//h4[contains(text(),'Product')]/..//a[@data-toggle='modal']")).click();
		driver.findElement(By.name("prodcode")).sendKeys(ProdCode);
		driver.findElement(By.name("name")).sendKeys(Name);
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(Description);
		driver.findElement(By.name("quantity")).sendKeys(Quantity);
		driver.findElement(By.name("onhand")).sendKeys(Onhand);
		driver.findElement(By.name("price")).sendKeys(Price);
		WebElement categoryDD = driver.findElement(By.name("category"));
		wLib.select(Category, categoryDD);
		WebElement supplierDD = driver.findElement(By.name("supplier"));
		wLib.select(Supplier, supplierDD);
		driver.findElement(By.name("datestock")).click();
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
		driver.findElement(By.xpath("//form[@action='pro_transac.php?action=add']/button[text()='Save']")).click();
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
