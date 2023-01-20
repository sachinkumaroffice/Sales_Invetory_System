package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {
public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("organization");
	Row row = sheet.getRow(1);
	String orgname = row.getCell(0).getStringCellValue();
	System.out.println(orgname);
	
}
}
