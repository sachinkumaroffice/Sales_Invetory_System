package com.practice;

import org.testng.annotations.Test;

public class SampleTestNG_Test_3 {

	
	@Test(groups = {"smoke", "regression"})
	public void legSpineer() {
		System.out.println("---Leg spinner got 5 wickets and scored 32 runs while batting---5");
	}
	
	@Test(groups = "regression")
	public void captain() {
		System.out.println("---Captain has deliberately opt to bowl first due pitch report analysis from the management---6");
	}
}
