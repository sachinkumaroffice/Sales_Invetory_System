package com.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class browser_launch {
public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
				WebDriver driver = new ChromeDriver();
	}
}
