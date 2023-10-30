package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcelUsingMap {

	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis=new FileInputStream("src/test/resources/Excelsheet2.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet4");
		int rows = sheet.getLastRowNum();
		System.out.println(rows);
		//creating a empty map
		LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
		
		for(int i=0;i<=rows;i++)
		{
			String key = sheet.getRow(i).getCell(0).toString();
	//		=sheet.getRow(i).getCell(1).toString();
		}

	}

}
