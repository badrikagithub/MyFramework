package Organisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import OrganisationPOM.CreateOrganisationPage;
import OrganisationPOM.HomePage;
import OrganisationPOM.LoginPage;
import OrganisationPOM.ValidationAllModulePage;

import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(Generic_Utility.ListenerImplementation.class) .class is mandatory
public class GenericOrganisationTest extends BaseClass {

	//@Test
	@Test(retryAnalyzer=Generic_Utility.RetryAnalyser.class)
	public void GenericOrganisationTest() throws Throwable
		
	
	{
		File_Utility flib=new File_Utility();
		Wendriver_Utility wlib=new Wendriver_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_utility elib=new Excel_utility();
		
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		
	/*	String BROWSER = flib.getStringKeyAndValue("browser");
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
		
	  /*   wlib.implicitwait(driver);
	  	String URL = flib.getStringKeyAndValue("linksite");
		wlib.maximizeScreen(driver);
		
		driver.get(URL);*/
	   //driver.get("http://localhost:8888/");
//		
//		//calling from POM
//		
//		String USERname = flib.getStringKeyAndValue("USERNAME");
//		String PASSword = flib.getStringKeyAndValue("PASSWORD");

        //calling from POM
//		LoginPage login=new LoginPage(driver);
//		login.loginToAPP(USERname,PASSword);
		
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERname);
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSword);
//		driver.findElement(By.id("submitButton")).click();
		
		//Calling from pomHomepage
		HomePage home=new HomePage(driver);
		home.organizationLink();
		
		//driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		CreateOrganisationPage createorg=new CreateOrganisationPage(driver);
		createorg.clickonPlusimg();
		
		
		int ranNumber = jlib.getRandomNum();
		
		String orgname = elib.getExcelData("Organisation", 0, 0)+ranNumber;	
		//driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		
//		 String phnNum = elib.excelDataUsingDataFormatter("Organisation", 0, 1);
//		 String mailid = elib.excelDataUsingDataFormatter("Organisation", 0, 2);
		//String orgname = elib.getExcelData("Organisation", 0, 0)+ranNumber;	
		String phnNum = elib.excelDataUsingDataFormatter("Organisation", 0, 1);
		 String mailid = elib.excelDataUsingDataFormatter("Organisation", 0, 2);
			 
//		driver.findElement(By.id("phone")).sendKeys(phnNum);
//		driver.findElement(By.id("email1")).sendKeys(mailid);
		// CreateOrganisationPage createorg=new CreateOrganisationPage(driver); //already created the obj of CreateOrganisationPage
		 createorg.orgData(orgname, phnNum, mailid);
		 Thread.sleep(1000);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 createorg.clickonSaveButton(); 
		 
		/* //String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 {
		 	if(actData.contains(orgname))
		 	{
		 		System.out.println("pass");
		 	}
		 	else
		 	{
		 		System.out.println("fail");
		 	}

		 }*/
	     ValidationAllModulePage validate=new ValidationAllModulePage();
//		 String actData = validate.OrgValidate();
//	    // String actData = driver.findElement(By.id("dtlview_Organization Name")).getText();
//		 Assert.assertEquals(actData, orgname);
		
		 String actphn = validate.phnNumValidate(); 
	// String actPhn = driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();
		 Assert.assertEquals(phnNum, actphn);
		
	/*	String actEmail = driver.findElement(By.xpath("//span[@id='dtlview_Email']")).getText();
		Assert.assertEquals(actEmail, mailid);*/
//		
//		 Thread.sleep(1000);
//		 home.logout(driver);
//		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		 wlib.ActionsMoveToElement(driver, ele);
//		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		 
		
		
	}
	}


