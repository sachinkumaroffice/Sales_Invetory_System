package com.sis.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility extends JavaUtility {
	public String readDataFromExcel(String sheetName, int rowNum, int columnNum) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		String data = row.getCell(columnNum).getStringCellValue();
		return data;		
	}
	
	
	public int getLastRowNo(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int count = sheet.getLastRowNum();
		return count;	
	}
	
	public Map<String, String> getList(String sheetName, int keyCell, int valueCell) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		 Workbook workbook = WorkbookFactory.create(fis);
		 Sheet sheet = workbook.getSheet(sheetName);
		 int count = sheet.getLastRowNum();
		 Map<String, String> map = new HashMap<String, String>();
		 for (int i = 0; i <= count; i++) {
			 String key = sheet.getRow(i).getCell(keyCell).getStringCellValue();
			 String value = sheet.getRow(i).getCell(valueCell).getStringCellValue();
			 map.put(key, value);
		}
		return map;
		
	}
	
	public void writeDataIntoExcel(String sheetName, int rowNum, int columnNum, String Data) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(columnNum);
		cell.setCellValue(Data);
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		workbook.write(fos);
	}
	
	public Object[][] readMultipleData(String SheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(SheetName);
		int lastRow = sheet.getLastRowNum()+1;
		int lastCell = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRow][lastCell];
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();	
			}
		}
		return obj;
	}
}
