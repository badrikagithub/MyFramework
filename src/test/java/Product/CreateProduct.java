package Product;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Wendriver_Utility;
import OrganisationPOM.CreateProductPage;
import OrganisationPOM.HomePage;
import OrganisationPOM.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct {

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		/*driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin"); ///hard coding part
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();*/
		
		/*FileInputStream fis=new FileInputStream("src/test/resources/DDTpropertyfile.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String URL = pro.getProperty("linksite");
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
		
		//calling from pom class
		LoginPage logindata=new LoginPage(driver);
		logindata.loginToAPP(USERname, PASSword);
		
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERname);
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSword);
//		driver.findElement(By.id("submitButton")).click();
		HomePage home=new HomePage(driver);
		home.productLink();	
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		CreateProductPage product=new CreateProductPage(driver);
		product.clickOnPlusSign();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		Excel_utility elib=new Excel_utility();
		String ProductName = elib.excelDataUsingDataFormatter("product", 0, 0);
		
		
		driver.findElement(By.name("productname")).sendKeys(ProductName);
		
		WebElement save = driver.findElement(By.xpath("(//input[@name='button'])[3]"));
		
		WebElement saveButton = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
		wlib.javaScriptExecutor(driver, saveButton);
		saveButton.click();
		
//		JavascriptExecutor js=(JavascriptExecutor)driver;//scroll up to the path written for the element
//		js.executeScript("arguments[0].scrollIntoView()", saveButton);
//		saveButton.click();
		
		
//		
		/*Thread.sleep(1000);
	    Rectangle rect=save.getRect();
		System.out.println(rect.getX());//688 
		System.out.println(rect.getY());//1148 
		Thread.sleep(1000);
			
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for(int i=0;i<4;i++)
		{
			js.executeScript("window.scrollBy(0,229)");
			Thread.sleep(3000);
		}
		 driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();*/
		
		/*Thread.sleep(3000); 
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();*/


	}

}
