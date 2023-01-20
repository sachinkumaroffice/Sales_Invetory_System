package LogInToSIS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.AdminLoginPage;
import com.sis.genericUtility.DataBaseUtility;
import com.sis.genericUtility.ExcelUtility;
import com.sis.genericUtility.FileUtility;
import com.sis.genericUtility.WebDriverUtility;

public class AdminLogin_POM_Test {
	public static void main(String[] args) throws Throwable {
		
		DataBaseUtility dbLib = new DataBaseUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		
		
		
		WebDriver driver = new FirefoxDriver();
		AdminLoginPage ALP = new AdminLoginPage(driver);
		AdminHomePage AHP = new AdminHomePage(driver);
		wLib.maximizeWindow(driver);
		driver.get(fLib.readDataFromPropertyFile("url"));
		wLib.waitForPageLoad(driver);
		ALP.adminLoginPage(fLib.readDataFromPropertyFile("username"), fLib.readDataFromPropertyFile("password"), wLib, driver);
		if (AHP.getAdminMenuOption().isDisplayed()) {
			System.out.println("The Test has been passed successfully and validated upon the verification");
		} else {
			System.out.println("Test has not been passed and validated");
		}
		
		driver.quit();
	}

}
