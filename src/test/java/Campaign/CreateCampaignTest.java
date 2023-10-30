package Campaign;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Wendriver_Utility;
import OrganisationPOM.CreateCampaignPage;
import OrganisationPOM.HomePage;
import OrganisationPOM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTest  extends BaseClass {

	@Test
	public void CreateCampaignTest() throws Throwable 
	{
	/*	WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
		File_Utility flib=new File_Utility();
		String Url = flib.getStringKeyAndValue("linksite");
		String USERname = flib.getStringKeyAndValue("USERNAME");
		String PASSword = flib.getStringKeyAndValue("PASSWORD");
		
		driver.get(Url);
		Wendriver_Utility wlib=new Wendriver_Utility();
		wlib.maximizeScreen(driver);
		//driver.manage().window().maximize();
		LoginPage logindata=new LoginPage(driver);
		logindata.loginToAPP(USERname, PASSword);*/
		
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERname);
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSword);
//		driver.findElement(By.id("submitButton")).click();
		
		HomePage home=new HomePage(driver);
		home.clickMoreLink();
		//driver.findElement(By.xpath("//a[text()='More']")).click();
		Thread.sleep(3000);
		home.clickCampaign();
		//driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		
		CreateCampaignPage camp=new CreateCampaignPage(driver);
		camp.clickonPlusImgSign();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		

		Java_Utility jlib=new Java_Utility();
		int ranNumber = jlib.getRandomNum();

//		Random ram=new Random();
//		int ranNum = ram.nextInt(1000);
			
		/*FileInputStream fis=new FileInputStream("./src/test/resources/EXCEL DATA SELENIUM.xlsx");
        //open workbook in read mode  
		Workbook book=WorkbookFactory.create(fis);//(create inputstream)
		
		//get the control to the sheet
		Sheet sh = book.getSheet("campaign");
		//get the control on the row
		Row row = sh.getRow(1);
		//get the control on the cell
		Cell cell = row.getCell(1);
		//fetch the data from the cell
		String productData = cell.getStringCellValue()+ranNumber;*/
		Excel_utility elib=new Excel_utility();
		String CampaignName = elib.excelDataUsingDataFormatter("campaign", 1, 1);
		
		camp.campname(CampaignName);
		//driver.findElement(By.name("campaignname")).sendKeys(CampaignName);
		
		camp.saveCamp();
		//driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		 //WebElement actualdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		//if(actualdata.con)
		
	//	Thread.sleep(3000);
		//home.logout(driver);
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
