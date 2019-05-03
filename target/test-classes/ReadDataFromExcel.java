package com.alist.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	
	
	
//	private static final String Formatvals = null;

	public ArrayList<String> ReadData(String filePath, String fileName, String sheetName, String columnName, String rowValue) 
	{
		Workbook wb = null;
		int k=0, column = 0;
		
		
		ArrayList<String> a = new ArrayList<String>();
		//HSSFWorkbook hwb = null;
		File file = new File (filePath);
		
		//Load the File
		FileInputStream fis = null;
		try {
		
		
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		
		//Check the extension of the excel file
		String fileExtension = fileName.substring(fileName.indexOf("."));
		
		if(fileExtension.equalsIgnoreCase(".xlsx"))
		{
			try {
				wb = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if (fileExtension.equalsIgnoreCase(".xls"))
		{
			try {
				wb = new HSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Get number of sheets count in the excel file
		int countofsheets = wb.getNumberOfSheets();
		//System.out.println("No of Sheets" +countofsheets);
		//Check each sheetname in the excel file
		for(int i=0; i<countofsheets; i++)
		{
			//If sheetname matches the expected sheetname perform the operations further
			if(wb.getSheetName(i).equalsIgnoreCase(sheetName))
			{
			//	System.out.println(sheetName);
			//Get the sheet if satisfies the condition
			Sheet sheet = wb.getSheetAt(i);
			
			//Iterate through each row after getting the sheet
			Iterator<Row> row = sheet.iterator();
				//Store the first row 
				Row firstrow = row.next();
				//Iterate through each cell in the stored row
				Iterator<Cell> fcell = firstrow.cellIterator();
				
				//if the row has next cell perform below operations
				while(fcell.hasNext())
				{
					
					Cell ce= fcell.next();
					
					if(ce.getStringCellValue().equalsIgnoreCase(columnName))
					{
						column = k;
					}
					k++;
				}
				
				while(row.hasNext())
				{
					
					Row rw = row.next();
					if(rw.getCell(column).getStringCellValue().equalsIgnoreCase(rowValue))
					{
						Iterator<Cell> cvalue = rw.cellIterator();
						while(cvalue.hasNext())
						{
							Cell cval = cvalue.next();
							if(cval.getCellType()== Cell.CELL_TYPE_STRING)
							{
							a.add(cval.getStringCellValue());
							}
							
							else 
							{
								a.add(NumberToTextConverter.toText(cval.getNumericCellValue()));
							}
							
						}
					}
					
				}
			
			
			}
		}
		return a;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
