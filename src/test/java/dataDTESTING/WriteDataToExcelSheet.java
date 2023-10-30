package dataDTESTING;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcelSheet {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("src/test/resources/EXCEL DATA SELENIUM.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		
		Row row = sh.getRow(2);
		
		Cell cel = row.createCell(3);
		cel.setCellValue("narayani");
		
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\HP\\Desktop\\Selenium Workspace\\AdvanceSelennium\\src\\test\\resources\\EXCEL DATA SELENIUM.xlsx");
		book.write(fos);
		book.close();
		

	}

}
