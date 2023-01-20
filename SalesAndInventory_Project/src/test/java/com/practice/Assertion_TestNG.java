package com.practice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion_TestNG {

	@Test
	public void Karnataka() {
		System.out.println("---Bangalore---");
		System.out.println("---Vijayapura---");
		assertEquals("a", "b");
		System.out.println("---Mangalore---");
		System.out.println("---Kodagu---");
	}
	
	@Test
	public void TamilNadu() {
		System.out.println("---Chennai---");
		System.out.println("---Coimbatore");
		assertNotEquals("A", "B", "Script is failed");
		System.out.println("---Madurai---");
		System.out.println("---Trichy---");
	}
	
	@Test
	public void Kerala() {
		System.out.println("---Kochi---");
		System.out.println("---Trivandrum---");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("Sachinkumar", "KumarSachin");
		System.out.println("---Kozhikode---");
		System.out.println("---Palakkad---");
		sa.assertAll();
	}
	
	@Test
	public void AndhraPradesh() {
		String a = null;
		assertNull(a);
		System.out.println("---Amaravati---");
		System.out.println("---Tirupati---");
		System.out.println("---Vishakhapattanam---");
		System.out.println("---Kadapa---");
	}
}
