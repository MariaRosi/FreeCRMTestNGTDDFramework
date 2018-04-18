package com.crm.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crm.base.TestBaseClass;

public class TestUtility extends TestBaseClass{ 
	
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long	IMPLICIT_WAIT = 30;
	
	public void switchToFrame() {
		System.out.println("Prog : TestUtility and Method : switchToFrame");
		driver.switchTo().frame("mainpanel");
	}
	
	public Object[][] getTestDataFromExcel(String sExcelFilePath,String sExcelFileSheetName){
		System.out.println("Prog : TestUtility and Method : getTestDataFromExcel");
		Object[][] data = null;
		XSSFWorkbook book;
		XSSFSheet sheet;
		File file;
		FileInputStream fis;

		
		try {
			file= new File(sExcelFilePath);
			fis = new FileInputStream(file);
			
			book = new XSSFWorkbook(fis);
			
			sheet = book.getSheet(sExcelFileSheetName);
			
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i = 0; i < sheet.getLastRowNum(); i++) {
				for(int j= 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i).getCell(j).toString();
					
				}
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return data;
	
	}

}
