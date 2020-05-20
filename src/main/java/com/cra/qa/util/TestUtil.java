package com.cra.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static String TESTDATA_SHEET_PATH ="CrmTestData.xlsx";
					
	static Workbook book;
	static XSSFWorkbook book1;
	static Sheet sheet;
	static XSSFSheet sheet1;
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	/*
	 * public static Object[][] getTestData(String sheetName){
	 * System.out.println("inside getTestData"); 
	 * FileInputStream file = null; try {
	 * file =new FileInputStream(TESTDATA_SHEET_PATH); 
	 * }catch (FileNotFoundException
	 * e) { 
	 * e.printStackTrace(); 
	 * } 
	 * try { 
	 * book = WorkbookFactory.create(file); 
	 * }catch
	 * (IOException e) { 
	 * e.printStackTrace(); 
	 * } 
	 * sheet = book.getSheet(sheetName);
	 * int row =sheet.getLastRowNum(); 
	 * int col = sheet.getRow(0).getLastCellNum();
	 * Object data[][] = new Object[row][col];
	 * System.out.println("row="+row+"column ="+col); 
	 * for(int i=0; i<row;i++) { 
	 * for(int j=0;j<col;j++) { 
	 * data[i][j] = sheet.getRow(i+1).getCell(j).toString(); 
	 * }
	 * } 
	 * return data; 
	 * }
	 */
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException{
		System.out.println("inside getTestData");
		//FileInputStream file = null;
		File file =null;
		file =new File("CrmTestData.xlsx");
		try {
			book1 = new XSSFWorkbook(file);
		}catch (IOException e) {
			e.printStackTrace();
		}
		sheet1 = book1.getSheet(sheetName);
		int row =sheet1.getLastRowNum();
	//	int row = sheet1.getPhysicalNumberOfRows();
		int col = sheet1.getRow(0).getLastCellNum();
	//	int col = sheet1.getRow(0).getPhysicalNumberOfCells();
		Object data[][] = new Object[row][col];
		System.out.println("row="+row+"column ="+col);
		for(int i=0; i<row;i++) {
			for( int j=0;j<col;j++) {
				data[i][j] = sheet1.getRow(i+1).getCell(j).toString();
			//	data [i][j] = sheet1.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
