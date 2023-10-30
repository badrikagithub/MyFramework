package practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEx2 
{
	@Test(dataProvider="getdata")
	public void m1(String orgname,String phonnum,String emailid) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin"); ///hard coding part
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.id("phone")).sendKeys(phonnum);
		driver.findElement(By.id("email1")).sendKeys(emailid);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(1000);
		driver.quit();
		
	}
	@DataProvider
	public Object[][] getdata()
	{
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
				
		Object[][] obj = new Object[3][3];
		obj[0][0]="AAA"+ranNum;
		obj[0][1]="909097654";
		obj[0][2]="JULY.MBJ@GAMAIL.COM";
		
		obj[1][0]="BBB"+ranNum;
		obj[1][1]="8765432";
		obj[1][2]="BULLY.MBJ@GAMAIL.COM";
		
		obj[2][0]="CCC"+ranNum;
		obj[2][1]="45321566";
		obj[2][2]="HARDY.MBJ@GAMAIL.COM";
		
		return obj;
		
	}

}
