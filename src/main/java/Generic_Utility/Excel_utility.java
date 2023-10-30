package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility 
{
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable, IOException
	{
		FileInputStream fis=new FileInputStream("src/test/resources/EXCEL DATA SELENIUM.xlsx");
        //open workbook in read mode  
		Workbook book=WorkbookFactory.create(fis);//(create inputstream)
		
		//get the control to the sheet
		Sheet sh = book.getSheet(sheetName);
		
		
		//get the control on the row
		 Row row = sh.getRow(rowNum);
		//get the control on the cell
		 Cell cell = row.getCell(cellNum);
//		//fetch the data from the cell 
	     String value = cell.getStringCellValue();
	     return value; 
	
	}	
	public String excelDataUsingDataFormatter(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("src/test/resources/EXCEL DATA SELENIUM.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		DataFormatter format=new DataFormatter();
		String value = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return value;
		
	}
	/**
	 * This method will read multiple data from excel sheet at time 
	 * used for Data Provider
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipledata(String SheetName) throws Throwable
	{
		
		FileInputStream fis=new FileInputStream("src/test/resources/EXCEL DATA SELENIUM.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(SheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();	
		System.out.println(sh.getLastRowNum());
		
		Object [][] obj=new Object[lastRow][lastcell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();//i+1 as we need to exclude the header part of excel sheet
			}
		}			
		return obj;
		
	}
}
