package LogInToSIS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sis.genericUtility.ExcelUtility;
import com.sis.genericUtility.FileUtility;
import com.sis.genericUtility.WebDriverUtility;

public class AdminLogin_Test {
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
	}
}
