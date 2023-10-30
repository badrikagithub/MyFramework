package Organisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Wendriver_Utility;
import OrganisationPOM.CreateOrganisationPage;
import OrganisationPOM.HomePage;
import OrganisationPOM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrgWithDropDown {

	public static void main(String[] args) throws Throwable 
	{
		File_Utility flib=new File_Utility();
		Wendriver_Utility wlib=new Wendriver_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_utility elib=new Excel_utility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
		String URL = flib.getStringKeyAndValue("linksite");
		String USERname = flib.getStringKeyAndValue("USERNAME");
		String PASSword = flib.getStringKeyAndValue("PASSWORD");
		
		driver.get(URL);
		
		wlib.maximizeScreen(driver);
		
		LoginPage login=new LoginPage(driver);
		login.loginToAPP(USERname, PASSword);
		
		HomePage org=new HomePage(driver);
		org.organizationLink();
		
		CreateOrganisationPage creatorg=new CreateOrganisationPage(driver);
		creatorg.clickonPlusimg();
		
		int ranNumber = jlib.getRandomNum();
		String orgname = elib.excelDataUsingDataFormatter("Organisation", 2, 0)+ranNumber;
		String energy = elib.excelDataUsingDataFormatter("Organisation", 2, 1)+ranNumber;
		String type = elib.excelDataUsingDataFormatter("Organisation", 2, 2)+ranNumber;
         /* System.out.println(orgname);
          System.out.println(energy);
          System.out.println(type);*/

    driver.findElement(By.name("accountname")).sendKeys(orgname);
    driver.findElement(By.xpath("//select[@name='industry']")).sendKeys(energy);
    driver.findElement(By.xpath("//select[@name='accounttype']")).sendKeys(type);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 wlib.ActionsMoveToElement(driver, ele);
	 Thread.sleep(3000);
      driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	

}
