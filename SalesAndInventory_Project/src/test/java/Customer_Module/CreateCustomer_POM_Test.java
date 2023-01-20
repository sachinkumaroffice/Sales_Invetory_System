package Customer_Module;

import static org.testng.Assert.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sis.ObjRepo.AddCustomerPage;
import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.CustomerPage;
import com.sis.genericUtility.Base_Class;

@Listeners(com.sis.genericUtility.ListenersImplementationClass.class)
public class CreateCustomer_POM_Test extends Base_Class {

	@Test()
	public void addCustomer() throws Throwable { 
		
		AdminHomePage AHP = new AdminHomePage(driver);
	 	CustomerPage ACP = new CustomerPage(driver);
	 	AddCustomerPage AACP = new AddCustomerPage(driver);
	 	AHP.customerModule(wLib, driver);
	 	ACP.addCustomer();
	 	fail();
	 	AACP.addCustomer("Customer_Details", eLib, jLib);
	 	System.out.println("Customer has been created successfully");
	 }
//	@Test
//	public void simple1() {
//		System.out.println("---Simple1 test has been passed---");
//	}
//	@Test
//	public void simple2() {
//		System.out.println("---Simple2 test has been passed---");
//	}
}


