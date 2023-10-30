package dataDTESTING;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFormatterForExcel {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("src/test/resources/Excelsheet2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet2");
		Row row = sh.getRow(4);
		Cell cel = row.getCell(2);
		
		DataFormatter format=new DataFormatter();//this method is used to fetch any kind of data i.e int,special,string,float etc.. from excel 
		String data = format.formatCellValue(cel);
		System.out.println(data);  

	}

}
