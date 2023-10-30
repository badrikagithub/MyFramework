package Campaign;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Wendriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable 
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		/*FileInputStream fis=new FileInputStream("src/test/resources/DDTpropertyfile.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String URL = pro.getProperty("linksite");
		String USERname = pro.getProperty("USERNAME");
		String PASSword = pro.getProperty("PASSWORD");*/
		
		File_Utility flib=new File_Utility();
		String URL = flib.getStringKeyAndValue("linksite");
		String USERname = flib.getStringKeyAndValue("USERNAME");
		String PASSword = flib.getStringKeyAndValue("PASSWORD");
		
		driver.get(URL);
		Wendriver_Utility wlib=new Wendriver_Utility();
		wlib.maximizeScreen(driver);
		//driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERname);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSword);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();		
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		Java_Utility jlib=new Java_Utility();
		int ranNumber = jlib.getRandomNum();
		
//		Random ram=new Random();
//		int data = ram.nextInt(1000);
		
		
/*		//set the path
				FileInputStream fis1=new FileInputStream("./src/test/resources/EXCEL DATA SELENIUM.xlsx");
		        //open workbook in read mode  
				Workbook book=WorkbookFactory.create(fis1);//(create inputstream)
				
				//get the control to the sheet
				Sheet sh = book.getSheet("Sheet1");
				//get the control on the row
				Row row = sh.getRow(0);
				//get the control on the cell
				Cell cell = row.getCell(0);
				//fetch the data from the cell
				String productData = cell.getStringCellValue()+ranNumber;//excel data*/
		Excel_utility elib=new Excel_utility();
		String ProductName = elib.excelDataUsingDataFormatter("product", 2, 0);
		String campaignName = elib.excelDataUsingDataFormatter("campaign", 1, 1);
				
		driver.findElement(By.name("productname")).sendKeys(ProductName);
	
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.findElement(By.xpath("//a[text()='More']")).click();
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campaignName+ranNumber);
		
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		/*Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> id = allWindows.iterator();
		while(id.hasNext())
		{
			String win = id.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			
			if(title.contains("Products&action"))
			{
				break;
			}		
		}*/
		Wendriver_Utility wlib1=new Wendriver_Utility();
		wlib1.switchWindow(driver, "Products&action");
		
		driver.findElement(By.name("search_text")).sendKeys(ProductName);
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
		/*Set<String> allwindows1 = driver.getWindowHandles();
		Iterator<String> id1 = allwindows1.iterator();
		while(id1.hasNext())
		{
			String win1 = id1.next();
			driver.switchTo().window(win1); //switching windows by hard coding
			String title = driver.getTitle();
			
			if(title.contains("Campaigns&action"))
			{
				break;
			}
		}*/
		Wendriver_Utility wlib2=new Wendriver_Utility();//switching windows by generic utility
		wlib2.switchWindow(driver, "Campaigns&action");
		
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
		
		

	}

}
