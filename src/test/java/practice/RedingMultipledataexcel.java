package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class RedingMultipledataexcel {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Practice selenuim.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet2");
		//int rows = sh.getLastRowNum();
		
		 System.out.println(sh.getLastRowNum());
		for(int r=0;r<=sh.getLastRowNum();r++)
		{
			Row row = sh.getRow(r);
			
			for(int c=0;c<=row.getLastCellNum();c++)
			{
				Cell cel = row.getCell(c);
				DataFormatter format=new DataFormatter();
			    String data = format.formatCellValue(cel);
			    System.out.println(data);
			}
		}
		

	}

}
