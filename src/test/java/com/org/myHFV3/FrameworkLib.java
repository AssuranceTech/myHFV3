package com.org.myHFV3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;


public class FrameworkLib {
	
	public static void BrowseTests(WebDriver driver) throws IOException {
		String excelFilePath = "C://Users//asyedzia//workspace//myHFV3//myDatanKeyWordFile.xlsx";
		String flowName, testData1, testData2;
	    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	     
	    Workbook workbook = new XSSFWorkbook(inputStream);
	    Sheet firstSheet = workbook.getSheetAt(0);
	    Iterator<Row> iterator = firstSheet.iterator();
	     
	    while (iterator.hasNext()) {
	        Row nextRow = iterator.next();
	        Iterator<Cell> cellIterator = nextRow.cellIterator();
	         
	        while (cellIterator.hasNext()) {
	            // Read Flow Name
	        	Cell cell = cellIterator.next();
	            flowName = cell.getStringCellValue();
	            // Read Test Data 1
	            cell = cellIterator.next(); 
	            testData1 = cell.getStringCellValue();
	            // Read Test Data 2
	            cell = cellIterator.next(); 
	            testData2 = cell.getStringCellValue();
	            
	            //Execute Test
	            MyAppFuncLib.executeFlow(driver, flowName, testData1, testData2);	            
	            	            
	            break;            
	                        
	        }
	        System.out.println("Next Row");            
	    }
	     
	    workbook.close();
	    inputStream.close();
	}
}
