package Accounts_Module;

import org.testng.annotations.Test;

import com.sis.ObjRepo.AccountsPage;
import com.sis.ObjRepo.AddUserAccountsPage;
import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.AdminLoginPage;
import com.sis.genericUtility.Base_Class;

public class CreateUserAccount_POM_Test extends Base_Class {

	@Test
	public void addUser() throws Throwable { 
		AdminLoginPage ALP = new AdminLoginPage(driver);
		AdminHomePage AHP = new AdminHomePage(driver);
		AccountsPage AAP = new AccountsPage(driver); 
		AddUserAccountsPage AUAP = new AddUserAccountsPage(driver);
		AHP.accountsModule(wLib, driver);
		AAP.addUserAccount();
		AUAP.detailsOfUserAccounts(wLib, eLib.readDataFromExcel("User_Accounts_Details", 1, 1), eLib.readDataFromExcel("User_Accounts_Details", 2, 1));
		System.out.println("User Account has been created successfully");
	}
}
