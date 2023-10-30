package vTigerApp;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondScenrio {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='More']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Invoice']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Invoice...']")).click();
		driver.findElement(By.name("subject")).sendKeys("ASUS lAPTOP");
		driver.findElement(By.id("customerno")).sendKeys("2001");
		driver.findElement(By.xpath("(//img[@alt='Select'])[3]")).click();
		WebElement click = driver.findElement(By.xpath("//a[text()='Qspider2']"));
		click.click();
		
		 Robot robot=new Robot();
		 robot.keyPress(KeyEvent.VK_TAB);
		 robot.keyRelease(KeyEvent.VK_TAB);
		  
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
//		driver.findElement(By.linkText("javascript:window.close();")).click();
		
		//fir scrolling action
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,300)");
//		Thread.sleep(3000);
		//driver.findElement(By.name("bill_street")).sendKeys("Plot no-202B,VaniVihar");

	}//js.executeScript("window.scrollBy(0,500)");

}
