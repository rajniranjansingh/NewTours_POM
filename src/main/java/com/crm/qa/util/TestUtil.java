package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public TestUtil() throws IOException {
		
		super();
	}
	
	public void SwitchtoFrame(String name)
	{
		driver.switchTo().frame(name);
	}
	
	public static long Page_Load_TimeOut = 300;
	public static long Implicit_Wait = 30;
	
	public static String TestDataSheet_Path = "/Users/rajniranjansingh/eclipse-workspace/PageObjectModel/src/main/java/com/crm/qa/testdata/Data.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][]getTestData(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = null;
		file = new FileInputStream(TestDataSheet_Path);
		
		book = WorkbookFactory.create(file);
		sheet = book.getSheet(sheetname);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum();i++)
		{
			for(int j=0 ; j<sheet.getRow(0).getLastCellNum(); j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
	}
}
