package com.practice;

import org.testng.annotations.Test;

public class SampleTest_TestNG {

	@Test(invocationCount = 6)
	public void create() {
		System.out.println("created");
	}
	@Test(dependsOnMethods = "create", priority = -1)
	public void update() {
		System.out.println("updated");
	}
	
	@Test(priority = -1)
	public void delete() {
		System.out.println("deleted");
	}
}
