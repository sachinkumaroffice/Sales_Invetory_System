package LogInToSIS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.AdminLoginPage;
import com.sis.genericUtility.DataBaseUtility;
import com.sis.genericUtility.ExcelUtility;
import com.sis.genericUtility.FileUtility;
import com.sis.genericUtility.WebDriverUtility;

public class AdminLoginAndLogout_POM_Test {
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
		ALP.adminLoginPage(driver, fLib.readDataFromPropertyFile("username"), fLib.readDataFromPropertyFile("password"), wLib);
		if (AHP.getAdminMenuOption().isDisplayed()) {
			System.out.println("Admin Logged in successfully and Home page has been displayed");
			AHP.logOutModule(wLib, driver);
			if (ALP.getLoginButton().isDisplayed()) {
				System.out.println("Admin Logged out successfully");
				System.out.println("Test has been passed successfully and validated upon the verification");
			} else {
				System.out.println("Test has beeen not been passed and verified upon the validation");
			}
			
		} else {
			System.out.println("Admin failed to logged in");
		}
		driver.quit();
	}

}
