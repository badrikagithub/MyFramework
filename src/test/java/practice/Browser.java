package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Browser {

	public static void main(String[] args) throws IOException 
	{
//		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");//no need of this in maven project
//		WebDriver driver=new ChromeDriver();
		
		
		WebDriver driver=new ChromeDriver();//for 4.9.1 version it is not necessary to write the manage() method and 
		                                                       //no need of webdriver dependencies also
		
		FileInputStream fis=new FileInputStream("src/test/resources/DDTpropertyfile.properties");
		Properties pro=new Properties();//need to create credentials in notepad and paste it in the src/test/resources
		pro.load(fis);
		String URL = pro.getProperty("url");
		String Username = pro.getProperty("username");	
		String PASSWORD = pro.getProperty("password");
		
		driver.get(URL);	
		driver.findElement(By.id("username")).sendKeys(Username);		
		driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
  	    driver.findElement(By.id("loginButton")).click();
		
		// driver.get("https://demo.actitime.com/login.do");
		

	}

}
