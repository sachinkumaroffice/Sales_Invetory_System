package com.practice;

import org.testng.annotations.Test;

public class SampleTestNG_Test_2 {

	@Test(groups = "regression")
	public void wicketKeeper() {
		System.out.println("---Wicket keeper got 5 catches---3");
	}
	
	@Test(groups = {"smoke", "regression"})
	public void pacer() {
		System.out.println("---Pacer has been delivered one of the fastest delivery in the sub-continent---4");
	}
}
