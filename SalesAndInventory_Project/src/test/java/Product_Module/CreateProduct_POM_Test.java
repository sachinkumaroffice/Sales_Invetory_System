package Product_Module;

import static org.testng.Assert.fail;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.sis.ObjRepo.AddProductPage;
import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.AdminLoginPage;
import com.sis.ObjRepo.ProductPage;
import com.sis.genericUtility.Base_Class;
import com.sis.genericUtility.DataBaseUtility;
import com.sis.genericUtility.ExcelUtility;
import com.sis.genericUtility.FileUtility;
import com.sis.genericUtility.JavaUtility;
import com.sis.genericUtility.WebDriverUtility;

public class CreateProduct_POM_Test extends Base_Class {
	@Test(retryAnalyzer = com.sis.genericUtility.RetryImplementationClass.class)
	public void addProduct() throws Throwable {
		
		
		AdminLoginPage ALP = new AdminLoginPage(driver);
		AdminHomePage AHP = new AdminHomePage(driver);
		AddProductPage AAPP = new AddProductPage(driver);
		ProductPage APP = new ProductPage(driver);
		AHP.productModule(wLib, driver);
		APP.addProduct();
		fail();
		AAPP.detailsOfProduct(eLib.readDataFromExcel("Product_Details", 0, 1), eLib.readDataFromExcel("Product_Details", 1, 1), eLib.readDataFromExcel("Product_Details", 2, 1), eLib.readDataFromExcel("Product_Details", 3, 1), eLib.readDataFromExcel("Product_Details", 4, 1), eLib.readDataFromExcel("Product_Details", 5, 1), wLib, eLib.readDataFromExcel("Product_Details", 6, 1), eLib.readDataFromExcel("Product_Details", 7, 1));
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
		AAPP.saveProduct();
		System.out.println("Product has been created successfully"); 
	} 

}
