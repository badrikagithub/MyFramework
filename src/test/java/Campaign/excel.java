package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excel {

	public static void main(String[] args) throws Throwable 
	{

		FileInputStream fis=new FileInputStream("src/test/resources/Book2.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
	    Row row = sh.getRow(0);
	    Cell cel = row.getCell(0);
	    String data= cel.getStringCellValue();
	    System.out.println(data);

	}

	
	

}
