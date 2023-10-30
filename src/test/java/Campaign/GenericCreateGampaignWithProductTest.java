package Campaign;

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
import OrganisationPOM.CreateCampaignPage;
import OrganisationPOM.CreateProductPage;
import OrganisationPOM.HomePage;
import OrganisationPOM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericCreateGampaignWithProductTest  extends BaseClass
{
	@Test
	public void GenericCreateGampaignWithProductTest()throws Throwable  
	{
		//File_Utility flib=new File_Utility();
		Wendriver_Utility wlib=new Wendriver_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_utility elib=new Excel_utility();
		
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); 
	
		String URL = flib.getStringKeyAndValue("linksite");
		String USERname = flib.getStringKeyAndValue("USERNAME");
		String PASSword = flib.getStringKeyAndValue("PASSWORD");
		
		driver.get(URL);
		wlib.maximizeScreen(driver);
		
		LoginPage login=new LoginPage(driver);
		login.loginToAPP(USERname, PASSword);*/
		
	
		/*driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERname);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSword);
		driver.findElement(By.id("submitButton")).click();*/
		
		HomePage home=new HomePage(driver);
		home.productLink();
	   // driver.findElement(By.xpath("//a[text()='Products']")).click();	
		
		CreateProductPage createprodct=new CreateProductPage(driver);
		createprodct.clickOnPlusSign();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		int ranNumber = jlib.getRandomNum();  
		
		String ProductName = elib.excelDataUsingDataFormatter("product", 2, 0)+ranNumber;
		String campaignName = elib.excelDataUsingDataFormatter("campaign", 1, 1)+ranNumber;
		
		createprodct.productName(ProductName);		
		//driver.findElement(By.name("productname")).sendKeys(ProductName);
		
		createprodct.clickonSaveButtn(driver);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
		home.clickMoreLink();
		//driver.findElement(By.xpath("//a[text()='More']")).click();
		home.clickCampaign();
		//driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		
		CreateCampaignPage createcamp=new CreateCampaignPage(driver);
		createcamp.clickonPlusImgSign();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		createcamp.campname(campaignName);
		//driver.findElement(By.name("campaignname")).sendKeys(campaignName+ranNumber);
		createcamp.selectButton();
		//driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
        wlib.switchWindow(driver, "Products&action");
        createcamp.productNameSwitching(ProductName);
		//driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ProductName);
         
         createcamp.searchProduct();
		//driver.findElement(By.name("search")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[text()='"+campaignName+"']")).click();
		driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
		
		wlib.switchWindow(driver, "Campaigns&action");
		createcamp.saveButon();
		//driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
	//	home.logout(driver);
		/*WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        wlib.ActionsMoveToElement(driver, ele);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();*/
		
		
		
	}

}
