package dataDTESTING;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphons");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		 List<WebElement> alliphonnames = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		
		
		
		FileInputStream fis=new FileInputStream("src/test/resources/Excelsheet2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet4");

		for(int i=0;i<alliphonnames.size();i++)
		{
			Row row = sh.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(alliphonnames.get(i).getAttribute("href"));
	    } 
		FileOutputStream fos=new FileOutputStream("src/test/resources/Excelsheet1.xlsx");
		book.write(fos);

}
}
