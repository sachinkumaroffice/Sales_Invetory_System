 package com.sis.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.AdminLoginPage;

public class Base_Class {
		public WebDriver driver;
		static WebDriver sdriver;
		public DataBaseUtility dbLib = new DataBaseUtility();
		public JavaUtility jLib = new JavaUtility();
		public WebDriverUtility wLib = new WebDriverUtility();
		public FileUtility fLib = new FileUtility();
		public ExcelUtility eLib = new ExcelUtility();

	@BeforeSuite
	public void configBS_SIS() throws Throwable{
	//dbLib.connectToDB();
	System.out.println("---Connect to the Database---");
	}
	
	@BeforeClass
	public void configBC_SIS() throws Throwable {
		String Browser = fLib.readDataFromPropertyFile("browser");
		if (Browser.equalsIgnoreCase("opera")) {
			driver = new OperaDriver();
		} else if(Browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webriver.chromedriver.driver", "./SalesAndInventory_Project/chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("msedge")) {
			System.setProperty("webdriver.edge.driver", "./msedgedriver.exe");
			driver = new EdgeDriver();
		}else {
			System.out.println("Invalid Browser");
		}
		sdriver = driver;
		System.out.println("---Launch the browser---");
		wLib.maximizeWindow(driver);
		driver.get(fLib.readDataFromPropertyFile("url"));
		wLib.waitForPageLoad(driver);
	}
	@BeforeMethod
	public void configBM_SIS() throws Throwable {
		String UserName = fLib.readDataFromPropertyFile("username");
		String Password = fLib.readDataFromPropertyFile("password");
		AdminLoginPage ALP = new AdminLoginPage(driver);
		ALP.adminLoginPage(driver, UserName, Password, ALP);
		System.out.println("---Login to the application---");
	}
	@AfterMethod
	public void configAM_SIS() {
		AdminHomePage AHP = new AdminHomePage(driver);
		AHP.logOutModule(wLib, driver);
		System.out.println("---Logout from the Application---");
	}
	@AfterClass
	public void configAC_SIS(){
		driver.quit();
		System.out.println("---Close the browser---");
	}
	@AfterSuite
	public void configAS_SIS() throws Throwable {
		//dbLib.closeDBConnection();
		System.out.println("---Disconnect from the database---");
	}

	}
