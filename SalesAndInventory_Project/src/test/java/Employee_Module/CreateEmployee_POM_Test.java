package Employee_Module;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import com.sis.ObjRepo.AddEmployeePage;
import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.EmployeePage;
import com.sis.genericUtility.Base_Class;

public class CreateEmployee_POM_Test extends Base_Class {
	
		@Test
	public void addEmployee() throws Throwable {
			
		AdminHomePage AHP = new AdminHomePage(driver);
		EmployeePage AEP = new EmployeePage(driver);
		AddEmployeePage AAEP = new AddEmployeePage(driver);
		AHP.employeeModule(wLib, driver);
		AEP.addEmployee(wLib, driver);
		AAEP.detailsOfEmployee(eLib.readDataFromExcel("Employee_Details", 0, 1), eLib.readDataFromExcel("Employee_Details", 1, 1), eLib.readDataFromExcel("Employee_Details", 2, 1), eLib.readDataFromExcel("Employee_Details", 3, 1), eLib.readDataFromExcel("Employee_Details", 4, 1), eLib.readDataFromExcel("Employee_Details", 5, 1), wLib);
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
		AAEP.provinceCityEmployee(eLib.readDataFromExcel("Employee_Details", 6, 1), eLib.readDataFromExcel("Employee_Details", 7, 1), wLib, driver);
		AAEP.saveEmployee();
		System.out.println("Employee has been created successsfully");
	}
}
