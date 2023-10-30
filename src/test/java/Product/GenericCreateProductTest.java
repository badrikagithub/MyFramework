package Product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Wendriver_Utility;
import OrganisationPOM.CreateProductPage;
import OrganisationPOM.HomePage;
import OrganisationPOM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericCreateProductTest extends BaseClass {

	@Test
	public void GenericCreateProductTest() throws Throwable
	{
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();*/ 
		
		//File_Utility flib=new File_Utility();
		Wendriver_Utility wlib=new Wendriver_Utility(); 
		Java_Utility jlib=new Java_Utility();
		Excel_utility elib=new Excel_utility();
		
		//LOG IN BY USING BASE CLASS
		/*String URL = flib.getStringKeyAndValue("linksite");
		String USERname = flib.getStringKeyAndValue("USERNAME");   //login using generic utility
		String PASSword = flib.getStringKeyAndValue("PASSWORD");
		
		driver.get(URL);
		wlib.maximizeScreen(driver);
		//using login pom class
		LoginPage login=new LoginPage(driver);
		login.loginToAPP(USERname, PASSword);*/
		
		/*driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERname);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSword);
		driver.findElement(By.id("submitButton")).click();*/
		
		HomePage home=new HomePage(driver);
		home.productLink();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		CreateProductPage createprodct=new CreateProductPage(driver);
		createprodct.clickOnPlusSign();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		
		String ProductName = elib.excelDataUsingDataFormatter("product", 0, 0);
		createprodct.productName(ProductName);
		//driver.findElement(By.name("productname")).sendKeys(ProductName);
		
		
		//WebElement save = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]']"));
		
		
		createprodct.clickonSaveButtn(driver);
		/*//scroll to save button and do click action
		WebElement saveButton = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
		wlib.javaScriptExecutor(driver, saveButton);
		saveButton.click();*/
		//logout
		//Thread.sleep(3000);
		
		//home.logout(driver);
//		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		 wlib.ActionsMoveToElement(driver, ele);
//		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		

	}

}
