package com.highlevel.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel {
@Test
	public Object[][] getdata() throws IOException
	{
	String path = System.getProperty("user.dir")+"/src/main/java/com/highlevel/utilities/document.xlsx";	
		FileInputStream fis = new FileInputStream(path);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet = null;
	int sheets= wb.getNumberOfSheets();
	Object[][] data=null;
	Hashtable<String,String> table = null;

	for(int i=0;i<sheets;i++)
	{
		if(wb.getSheetName(i).equalsIgnoreCase("data"))
		{
		sheet = wb.getSheetAt(i);
		}
	}
	XSSFRow row = sheet.getRow(0);
	XSSFCell cell;
	   int norows= sheet.getPhysicalNumberOfRows();
	int nocells= row.getLastCellNum();
	data = new Object[norows-1][1];
	for(int i=1;i<norows;i++)
	{
		table = new Hashtable<String,String>();
		for(int j=0;j<nocells;j++)
		{
			row= sheet.getRow(i);
		 cell = row.getCell(j);	
		CellType type = cell.getCellType();
		if(type==CellType.STRING)
		{
			//data[0][j-1]=cell.getStringCellValue();
			//System.out.println(data[i-1][j-1]);
		table.put(sheet.getRow(0).getCell(j).getStringCellValue(),cell.getStringCellValue() );
		}
		if(type==CellType.NUMERIC)
		{
			//data[i-1][0]=  NumberToTextConverter.toText(cell.getNumericCellValue());
			table.put(sheet.getRow(0).getCell(j).getStringCellValue(),NumberToTextConverter.toText(cell.getNumericCellValue()) );
			
			//System.out.println(data[i-1][j-1]);
		}
		}
		data[i-1][0]= table;
	}
	return data;
	}
	
	
}
