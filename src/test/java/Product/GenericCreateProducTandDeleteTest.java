package Product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Wendriver_Utility;
import OrganisationPOM.CreateProductPage;
import OrganisationPOM.DeleteProductPage;
import OrganisationPOM.HomePage;
import OrganisationPOM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericCreateProducTandDeleteTest extends BaseClass{

//	@Test
	@Test(retryAnalyzer=Generic_Utility.RetryAnalyser.class)
	public void GenericCreateProducTandDeleteTest()  throws Throwable
	{
		//File_Utility flib=new File_Utility();
		Wendriver_Utility wlib=new Wendriver_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_utility elib=new Excel_utility();
		
		//WebDriverManager.chromedriver().setup();
       //  WebDriver driver=new ChromeDriver(); 
		
		/*String BROWSER = flib.getStringKeyAndValue("browser");
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} 
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}*/
		
		
		
		/*String URL = flib.getStringKeyAndValue("linksite");
		String USERname = flib.getStringKeyAndValue("USERNAME");   //login using generic utility
		String PASSword = flib.getStringKeyAndValue("PASSWORD");
		//
		driver.get(URL);
		wlib.maximizeScreen(driver);
		
		LoginPage login=new LoginPage(driver);
		login.loginToAPP(USERname, PASSword);	*/
				
		/*driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERname);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSword);
		driver.findElement(By.id("submitButton")).click();*/
		HomePage home=new HomePage(driver);
		home.productLink();				
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		CreateProductPage product=new CreateProductPage(driver);
		product.clickOnPlusSign();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		int ranNumber = jlib.getRandomNum();
		
		String ProductName = elib.excelDataUsingDataFormatter("product", 0 ,0)+ranNumber;
		product.productName(ProductName);
		Assert.assertEquals(true, false);
		//driver.findElement(By.name("productname")).sendKeys(ProductName);
		product.clickonSaveButtn(driver);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//product Table
		DeleteProductPage dltprd=new DeleteProductPage(driver);
		dltprd.productTable();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		
		driver.findElement(By.xpath("//table[@class='lvt small']//tbody//td//a[text()='"+ProductName+"']/../preceding-sibling::td/input")).click();
		dltprd.deleteProductdata();
        //driver.findElement(By.xpath("//input[@value='Delete']")).click();
        
        wlib.AlertPopUpHandle(driver); 
        Thread.sleep(1000);
        //home.logout(driver);
        
        

	}

}
