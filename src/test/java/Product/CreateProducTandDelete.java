package Product;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Wendriver_Utility;

public class CreateProducTandDelete {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		/*driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");  //hard coding
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();*/
		
		/*FileInputStream fis=new FileInputStream("src/test/resources/DDTpropertyfile.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String URL = pro.getProperty("linksite");   /// fetching logindetails from property file
		String USERname = pro.getProperty("USERNAME");
		String PASSword = pro.getProperty("PASSWORD");*/
		
		File_Utility flib=new File_Utility();
		String URL = flib.getStringKeyAndValue("linksite");
		String USERname = flib.getStringKeyAndValue("USERNAME");   //login using generic utility
		String PASSword = flib.getStringKeyAndValue("PASSWORD");
		
		driver.get(URL);
		Wendriver_Utility wlib=new Wendriver_Utility();
		wlib.maximizeScreen(driver);
		//driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERname);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSword);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		
		Java_Utility jlib=new Java_Utility();
		int ranNumber = jlib.getRandomNum(); 
		
//		Random ram=new Random();
//		int ranNum = ram.nextInt(1000);
		
		/*FileInputStream fis1=new FileInputStream("src/test/resources/EXCEL DATA SELENIUM.xlsx");
        //open workbook in read mode  
		Workbook book=WorkbookFactory.create(fis1);//(create inputstream)
		
		//get the control to the sheet
		Sheet sh = book.getSheet("product");
		//get the control on the row
		Row row = sh.getRow(0);
		//get the control on the cell
		Cell cell = row.getCell(0);
		//fetch the data from the cell
		String productData = cell.getStringCellValue()+ranNumber;*///excel data
		
		Excel_utility elib=new Excel_utility();
		String ProductName = elib.excelDataUsingDataFormatter("product", 0 ,0);
		driver.findElement(By.name("productname")).sendKeys(ProductName);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		driver.findElement(By.xpath("//table[@class='lvt small']//tbody//td//a[text()='"+ProductName+"']/../preceding-sibling::td/input")).click();
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
        
//       Alert alertpopup = driver.switchTo().alert();
//       alertpopup.accept();
        wlib.AlertPopUpHandle(driver);
        Thread.sleep(3000);
      /* //validation part
       List<WebElement> productlist = driver.findElements(By.xpath("(//table[@class='lvt small']//tbody//tr//td[3])[position()>1]"));
       boolean flag=false;
       for(WebElement prdname:productlist)
       {
    	   
       }*/
//       driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//	     driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
       
	}

}
