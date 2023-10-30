package dataDTESTING;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingMultipleDatafromExcelalllinksofFlipkartToConsole {

	public static void main(String[] args) throws Throwable 
	{
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.flipkart.com/");
//		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		FileInputStream fis=new FileInputStream("src/test/resources/Excelsheet2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		System.out.println(sh.getLastRowNum());
		
		for(int i=0;i<sh.getLastRowNum();i++)
		{
			Row row = sh.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)

			{
				Cell cell = row.getCell(j);
				DataFormatter format=new DataFormatter();
				String data = format.formatCellValue(cell);
				System.out.println(data);
				
			}
		}	

	}

}
