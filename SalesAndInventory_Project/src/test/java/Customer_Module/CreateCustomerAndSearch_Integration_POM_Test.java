package Customer_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.sis.ObjRepo.AddCustomerPage;
import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.AdminLoginPage;
import com.sis.ObjRepo.CustomerPage;
import com.sis.genericUtility.Base_Class;
import com.sis.genericUtility.DataBaseUtility;
import com.sis.genericUtility.ExcelUtility;
import com.sis.genericUtility.FileUtility;
import com.sis.genericUtility.JavaUtility;
import com.sis.genericUtility.WebDriverUtility;

public class CreateCustomerAndSearch_Integration_POM_Test extends Base_Class {
	@Test
	public void customerSearch() throws Throwable {
	AdminLoginPage ALP = new AdminLoginPage(driver);
	AdminHomePage AHP = new AdminHomePage(driver);
	CustomerPage ACP = new CustomerPage(driver);
	AddCustomerPage AACP = new AddCustomerPage(driver);
	AHP.customerModule(wLib, driver);
	ACP.addCustomer();
	AACP.addCustomer("Customer_Details", eLib, jLib);
	wLib.refresh(driver);
	ACP.searchFirstName(eLib.readDataFromExcel("Customer_Details", 0, 1));
	 System.out.println("Test has been copmleted successfully");
}
}
