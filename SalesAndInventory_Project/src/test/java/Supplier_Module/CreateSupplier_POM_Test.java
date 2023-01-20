package Supplier_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.sis.ObjRepo.AddSupplierPage;
import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.AdminLoginPage;
import com.sis.ObjRepo.SupplierPage;
import com.sis.genericUtility.Base_Class;
import com.sis.genericUtility.DataBaseUtility;
import com.sis.genericUtility.ExcelUtility;
import com.sis.genericUtility.FileUtility;
import com.sis.genericUtility.JavaUtility;
import com.sis.genericUtility.WebDriverUtility;

public class CreateSupplier_POM_Test extends Base_Class {
	
	@Test
	public void addSupplier() throws Throwable {
		AdminLoginPage ALP = new AdminLoginPage(driver);
		AdminHomePage  AHP = new AdminHomePage(driver);
		SupplierPage ASP = new SupplierPage(driver);
		AddSupplierPage AASP = new AddSupplierPage(driver);
		AHP.supplierModule(wLib, driver);
		ASP.addSupplier();
		AASP.saveSupplier(eLib.readDataFromExcel("Supplier_Details", 0, 1), eLib.readDataFromExcel("Supplier_Details", 1, 1), eLib.readDataFromExcel("Supplier_Details", 2, 1), eLib.readDataFromExcel("Supplier_Details", 3, 1), wLib);
	}

}
