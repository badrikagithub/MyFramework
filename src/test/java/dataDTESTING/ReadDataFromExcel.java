package dataDTESTING;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ReadDataFromExcel {

	public static void main(String[] args) throws Throwable   
	{
		//set the path
		FileInputStream fis=new FileInputStream("./src/test/resources/EXCEL DATA SELENIUM.xlsx");
        //open workbook in read mode  
		Workbook book=WorkbookFactory.create(fis);//(create inputstream)
		
		//get the control to the sheet
		Sheet sh = book.getSheet("Sheet1");
		//get the control on the row
		Row row = sh.getRow(4);
		//get the control on the cell
		Cell cell = row.getCell(2);
		//fetch the data from the cell
		String data = cell.getStringCellValue();
		System.out.println(data);
		
	   
	}

}

//Workbook wb = WorkbookFactory.create(fis);
//Sheet sh = wb.getSheet("Sheet1");
//Row r = sh.getRow(0);
// Cell c = r.getCell(0);
// String data = c.toString();
// System.out.println(data);