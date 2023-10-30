package Organisation;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utility.Excel_utility;
import Generic_Utility.File_Utility;
//import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Wendriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Organization {

	public static void main(String[] args) throws Throwable 
	{
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
		File_Utility flib=new File_Utility();
		String URL = flib.getStringKeyAndValue("linksite");
		String USERname = flib.getStringKeyAndValue("USERNAME");   //login using generic utility
		String PASSword = flib.getStringKeyAndValue("PASSWORD");
		
		/*FileInputStream fis=new FileInputStream("src/test/resources/DDTpropertyfile.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("linksite");
		String userNAME = pro.getProperty("USERNAME");
		String passWORD = pro.getProperty("PASSWORD");*/  
		
		driver.get(URL);
		Wendriver_Utility wlib=new Wendriver_Utility();
		wlib.maximizeScreen(driver);
		
		//driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERname);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSword);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		Java_Utility jlib=new Java_Utility();
		int ranNumber = jlib.getRandomNum();//from java utility 
		
		//Random ram=new Random();
		//int ranNum = ram.nextInt(1000);
		
		
	/*	//set the path
				FileInputStream fis1=new FileInputStream("./src/test/resources/EXCEL DATA SELENIUM.xlsx");
		        //open workbook in read mode  
				Workbook book=WorkbookFactory.create(fis1);//(create inputstream)
				
				//get the control to the sheet
				Sheet sh = book.getSheet("Organisation");
				
				
				//get the control on the row
				Row row = sh.getRow(0);
				//get the control on the cell
				Cell cell = row.getCell(0);
//				//fetch the data from the cell
			String orgname = cell.getStringCellValue()+ranNumber;*/
		
		Excel_utility elib=new Excel_utility();
		String orgname = elib.getExcelData("Organisation", 0, 0)+ranNumber;	
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		
		 String phnNum = elib.excelDataUsingDataFormatter("Organisation", 0, 1);
		 String mailid = elib.excelDataUsingDataFormatter("Organisation", 0, 2);
		
		
		driver.findElement(By.id("phone")).sendKeys(phnNum);
		driver.findElement(By.id("email1")).sendKeys(mailid);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		Thread.sleep(3000);
		
		
		String actualdata = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actualdata.contains(orgname))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
////		Actions act=new Actions(driver) ;
////		act.moveToElement(ele).perform();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		
		//
		
		
	}		
		

}


