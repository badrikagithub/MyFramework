package dataDTESTING;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		FileInputStream fis=new FileInputStream("src/test/resources/DDTpropertyfile.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String FURL = pro.getProperty("facebookurl");
		String EMAILID = pro.getProperty("email");
		String FPASSWORD = pro.getProperty("fpassword");
		
		driver.get(FURL);
		driver.findElement(By.id("email")).sendKeys(EMAILID);
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(FPASSWORD);
		driver.findElement(By.name("login")).click();
		

	}

}
