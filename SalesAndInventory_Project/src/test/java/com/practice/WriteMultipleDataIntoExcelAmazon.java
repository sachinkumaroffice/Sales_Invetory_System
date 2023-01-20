package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WriteMultipleDataIntoExcelAmazon {

	public static void main(String[] args) throws Throwable {
		int count = 0;
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Amazon"); 
		int data = sheet.getLastRowNum();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		 List<WebElement> links = driver.findElements(By.xpath("//a"));
		 int count1 = links.size();
		 System.out.println(count1);
		 for (WebElement link : links) {
			 Row row = sheet.createRow(count);
			     Cell cell = row.createCell(0);
			     cell.setCellValue(link.getAttribute("href"));
			 count++;
		} 
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
          workbook.write(fos);
		System.out.println("The links have written over excel");
	}

}
