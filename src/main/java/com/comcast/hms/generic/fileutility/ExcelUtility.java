package com.comcast.hms.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName, int rowNum, int CelNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/testScriptContactUsdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
//		String data= wb.getSheet(sheetName).getRow(rowNum).getCell(CelNum).getStringCellValue();

		Cell cell = wb.getSheet(sheetName).getRow(rowNum).getCell(CelNum);
		String data = "";
		if (cell != null) {
			CellType type = cell.getCellType();
			switch (type) {
			case STRING:
				data = cell.getStringCellValue();
				break;
			case NUMERIC:
				// If it’s an integer, avoid .0
				double numericValue = cell.getNumericCellValue();
				if (numericValue == (long) numericValue) {
					data = String.valueOf((long) numericValue);
				} else {
					data = String.valueOf(numericValue);
				}
				break;
			case BOOLEAN:
				data = String.valueOf(cell.getBooleanCellValue());
				break;
			case BLANK:
				data = "";
				break;
			default:
				data = cell.toString();
			}
		}
		wb.close();
		return data;
	}

	public int getRowcount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/testScriptContactUsdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}

	public void setDataIntoExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/testScriptContactUsdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 Row row = wb.getSheet(sheetName).getRow(rowNum);
		 if (row==null) {
			 row = wb.getSheet(sheetName).getRow(rowNum);
		 }
		 Cell cell = row.createCell(celNum);
		 cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./testData/testScriptContactUsdata.xlsx");
		wb.write(fos);
		wb.close();
	}
}

// Generic method to read any type of data from Excel
 
