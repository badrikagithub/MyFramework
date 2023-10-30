package Generic_Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import OrganisationPOM.HomePage;
import OrganisationPOM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver driver;
	public static WebDriver Sdriver;
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("DataBase Connection");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("parallel execution");
	}
	
	@BeforeClass 
	public void beforeClass() throws Throwable
	{
		File_Utility flib=new File_Utility();
		
		String BROWSER = flib.getStringKeyAndValue("browser");
		//WebDriver driver;
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
		}
		Sdriver=driver;
		System.out.println("launching the browser");
	}
	
	@BeforeMethod
	public void beforeMethod() throws Throwable
	{
      
       
       Wendriver_Utility wlib=new Wendriver_Utility();
       File_Utility flib=new File_Utility();
       //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       wlib.implicitwait(driver);
       String URL = flib.getStringKeyAndValue("linksite");
       String USERname = flib.getStringKeyAndValue("USERNAME");
	   String PASSword = flib.getStringKeyAndValue("PASSWORD");
	   wlib.maximizeScreen(driver);
	   driver.get(URL);
	   //calling from pom class
		LoginPage login=new LoginPage(driver);
		login.loginToAPP(USERname,PASSword);
		
		System.out.println("login to application");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("logout the application");
//		HomePage home=new HomePage(driver);
//		home.logout(driver);
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("close the browser");
		driver.close();
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("parallel execution done");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("DataBase Close");
	}

}
