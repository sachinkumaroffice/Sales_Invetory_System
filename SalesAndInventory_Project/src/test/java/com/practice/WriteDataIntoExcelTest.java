package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTest {
public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("organization");
	Row row = sheet.createRow(2);
	Cell cell = row.createCell(0);
	cell.setCellValue("Amazon");
	FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	workbook.write(fos);
}
}
