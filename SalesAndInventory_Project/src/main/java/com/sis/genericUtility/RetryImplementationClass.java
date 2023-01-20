package com.sis.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementationClass implements IRetryAnalyzer {
	int count = 0;
	int upperLimit = 2;
	public boolean retry(ITestResult result) {
		if (count<upperLimit) {
			count++;
			return true;
		} else {
           return false;
		}
	}
	
		
		
	}
