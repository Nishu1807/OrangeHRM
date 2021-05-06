package com.orangeHRM.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestUtil {
	
	public static String excelFilePath="src\\main\\java\\com\\orangeHRM\\testdata\\InvalidExcelTestData.xlsx";
	public static String sheetName="Sheet1";
	
	
	
	public static Object[][] getInvalidTestDataFromExcel() {
		Object[][] data = null ;
		try {
			FileInputStream inputstream = new FileInputStream(new File(excelFilePath));
			
			Workbook book = new XSSFWorkbook(inputstream);
			Sheet sheet = book.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum();
			data = new Object[rowCount][2];
			Iterator<Row> rowIterator = sheet.iterator();
			int nums=0;
			rowIterator.next();
			while(rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				int cellNum=0;
				while(cellIterator.hasNext()) {
					Cell cell =cellIterator.next();
					
					switch (cell.getCellTypeEnum()) {
					case STRING:
						data[nums][cellNum++]=cell.getStringCellValue();
						break;
						
					case BOOLEAN:
						data[nums][cellNum++]=cell.getBooleanCellValue();
						break;
						
					case NUMERIC:
						data[nums][cellNum++]=cell.getNumericCellValue();
						break;
						
					case BLANK:
						data[nums][cellNum++]=cell.getStringCellValue();

					default:
						break;
					}
				}
				nums++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	} 
}
