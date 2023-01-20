package com.sis.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class  ListenersImplementationClass  implements ITestListener {
	
	
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		//Execution Starts from here +++++++
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+"----> Test Script Execution Started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"---> Test Script Passed");
		Reporter.log(methodName+"Test Script Execution Successful");
	}

	public void onTestFailure(ITestResult result) {
		String path = "FailedScript"+ new JavaUtility().getSystemDateAndTimeFormat();
		EventFiringWebDriver eDriver = new EventFiringWebDriver(Base_Class.sdriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/"+path+".png");
		String filePath = dst.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath);
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(methodName+"Test Script Execution not been completed");
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"---> Method got skipped");
		Reporter.log(methodName+"---->Test Script got skipped while execution");
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("SDET-45 Extent Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("Sales and Inventory Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser", "Mozilla Firefox");
		report.setSystemInfo("Operating System", "Windows 10");
		report.setSystemInfo("Base URL", "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		report.setSystemInfo("Reporter Name", "Gopinath");
	}

	public void onFinish(ITestContext context) {
		
		//Consolidated the report
		report.flush();
	}

}
