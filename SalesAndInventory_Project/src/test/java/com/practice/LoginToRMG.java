package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginToRMG {
        public static void main(String[] args) {
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://rmgtestingserver:8084/");
			WebElement Username = driver.findElement(By.id("usernmae"));
			 Username.sendKeys("rmgyantra");
			WebElement password = driver.findElement(By.id("inputPassword"));
			password.sendKeys("rmgy@9999");
			WebElement signIn = driver.findElement(By.xpath("//button[text()='Sign in']"));
			signIn.click();
			WebElement projectsLink = driver.findElement(By.xpath("//a[text()='Projects']"));
			projectsLink.click();
			WebElement createProjectLink = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
			createProjectLink.click();
			WebElement projectName = driver.findElement(By.name("projectName"));
					projectName.sendKeys("Peaky Blinders");
			WebElement projectManager = driver.findElement(By.name("createdBy"));
					projectManager.sendKeys("Thomas Shelby");
			WebElement selectValueDropdown = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
			Select select = new Select(selectValueDropdown);
			select.selectByValue("Created");
			WebElement addProjectButton = driver.findElement(By.xpath("//input[@type='submit']"));
			addProjectButton.submit();
			System.out.println("Project created succefully");
		}
         
}
