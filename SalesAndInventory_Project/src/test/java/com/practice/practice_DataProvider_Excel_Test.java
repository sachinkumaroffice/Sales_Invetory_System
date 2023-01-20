package com.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sis.genericUtility.ExcelUtility;

import net.bytebuddy.asm.Advice.Return;

public class practice_DataProvider_Excel_Test {

	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		Object[][] value = eLib.readMultipleData("Data_Provider");
		return value;
	}
	
	@Test(dataProvider = "getData")
	public void europeTour(String from, String to, String price) {
		System.out.println(from +"--->" + to +" === "+ "with the price rate of " +" Rs"+ price +"/-");
	}
}
