package Campaign;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
//import CmpaignPOM.HomePage;
//import CmpaignPOM.PlusCreateCampaignpage;
import Generic_Utility.Excel_utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Wendriver_Utility;
import OrganisationPOM.CreateCampaignPage;
import OrganisationPOM.HomePage;
import OrganisationPOM.LoginPage;
import OrganisationPOM.ValidationAllModulePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericCreateCampaignTest extends BaseClass {
	
	//@Test
	@Test(retryAnalyzer=Generic_Utility.RetryAnalyser.class)
	public void GenericCreateCampaignTest() throws Throwable 
	{
		//File_Utility flib=new File_Utility();
		Wendriver_Utility wlib=new Wendriver_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_utility elib=new Excel_utility();
		
		/*//calling from base class 
		 WebDriverManager.chromedriver().setup();
         WebDriver driver=new ChromeDriver();*/
		
     /*   String BROWSER = flib.getStringKeyAndValue("browser");
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
		wlib.maximizeScreen(driver);
		driver.get(URL);
		String USERname = flib.getStringKeyAndValue("USERNAME");
		String PASSword = flib.getStringKeyAndValue("PASSWORD");
		//calling from pom class
		LoginPage login=new LoginPage(driver);
		login.loginToAPP(USERname,PASSword); */
		
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERname);
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSword);
//		driver.findElement(By.id("submitButton")).click();
		
		
		HomePage home=new HomePage(driver);
		home.clickMoreLink();
	//	driver.findElement(By.xpath("//a[text()='More']")).click();
		Thread.sleep(3000);
		home.clickCampaign();
		//driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		Thread.sleep(1000);
		
		CreateCampaignPage camp=new CreateCampaignPage(driver);
		camp.clickonPlusImgSign();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		
		int ranNumber = jlib.getRandomNum();
		String CampaignName = elib.excelDataUsingDataFormatter("campaign", 1, 1)+ranNumber;
		camp.campname(CampaignName);
		//home.logout(driver);
		Assert.assertEquals(false, true);
		
	
		 //Assert.assertEquals(false, true);
		
		/*driver.findElement(By.name("campaignname")).sendKeys(CampaignName);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		
		
		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 wlib.ActionsMoveToElement(driver, ele);
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();*/
		


	}

}
