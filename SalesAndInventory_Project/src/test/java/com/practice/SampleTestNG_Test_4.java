package com.practice;

import org.testng.annotations.Test;

public class SampleTestNG_Test_4 {

	
	@Test(groups = "smoke")
	public void allRounder() {
		System.out.println("---All rounder failed in every aspect and might miss next match for poor performance---7");
	}
	
	@Test(groups = "regression")
	public void coach() {
		System.out.println("---Coach is always look for diligency in the player over the hardwork they put in the nets---8");
	}
}
