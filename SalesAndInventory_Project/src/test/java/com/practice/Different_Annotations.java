package com.practice;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Different_Annotations {

	@Test
	public void test() {
		System.out.println("standing in the 4th place of the ranking table of the test");
	}
	@Test
	public void t20() {
		System.out.println("standing in the 3rd place of the ranking table of the t20");
	}
	@BeforeSuite
	public void configBS() {
		System.out.println("Connect to the DataBase Server -- Before Suite");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("Disconect the DataBase Server -- After Suite");
	}
	
	@BeforeClass
	public void configBC() {
		System.out.println("Launch the browser -- Before Class");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("Close the browser  -- After Class");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("Login To the Application -- Before Method");
	}
	@AfterMethod
	public void configAM() {
		System.out.println("LogOut from the Application  -- After Method");
	}
}
