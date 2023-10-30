package dataDTESTING;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritedataInExcel2 {

	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Excelsheet2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet2");
		Row row = sh.getRow(1);
		
		Cell cel = row.createCell(5);
		cel.setCellValue("TATAIPL");
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Excelsheet2.xlsx");
		book.write(fos);
		book.close();

	}

}
