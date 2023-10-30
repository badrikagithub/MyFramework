package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingExcelData {

	public static void main(String[] args) throws Throwable, IOException 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Practice selenuim.xlsx");
	//	Workbook book = WorkbookFactory.create(fis);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		Row row = sh.getRow(2);
		Cell cell = row.getCell(2);
		DataFormatter format=new DataFormatter();
		String anytypevalue = format.formatCellValue(cell);
		//String value = cell.getStringCellValue();
		
		System.out.println(anytypevalue);

	}

}

