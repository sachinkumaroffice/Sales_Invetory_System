package com.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class practice_DataProvider_TestNG {
	
	@Test(dataProvider = "data")
	public void travel(String src, String dst, int price) {
		System.out.println("from   "  + src +"=========>>>"+ "  To  " + dst +"=========>>>"+ " Price "+ price);

	}
	

	@DataProvider
	public Object[][] data() {
		
		Object[][] objArr = new Object[4][3];
		
		objArr[0][0] = "Bangalore";
		objArr[0][1] = "Berlin";
		objArr[0][2] = 55000;
				
		objArr[1][0] = "Berlin";
		objArr[1][1] = "Amsterdam";
		objArr[1][2] = 25000;
				
		objArr[2][0] = "Amsterdam";
		objArr[2][1] = "Toronto";
		objArr[2][2] = 30000;
		
		objArr[3][0] = "Toronto";
		objArr[3][1] = "Delhi";
		objArr[3][2] = 30000;
				
				return objArr;
	}
}
