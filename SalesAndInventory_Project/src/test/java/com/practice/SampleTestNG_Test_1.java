package com.practice;

import org.testng.annotations.Test;

public class SampleTestNG_Test_1 {

	@Test(groups = "Integration")
	public void opener() {
		System.out.println("---Opener has started playing---1");
	}
	
	@Test(groups = {"System", "regression"})
	public void oneDown() {
		System.out.println("---One down batsman comes into crease to face pacer---2");
	}
}
