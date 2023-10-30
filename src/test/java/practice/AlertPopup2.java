package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopup2 {

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");
		
		 driver.findElement(By.id("username")).sendKeys("admin",Keys.TAB,"manager",Keys.ENTER);
		 Thread.sleep(2000);
	 driver.findElement(By.cssSelector("div.popup_menu_button_settings")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//a[text()='Types of Work']")).click();
		 driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
		 
	 driver.findElement(By.name("name")).sendKeys("shobharani");
	 driver.findElement(By.xpath("//input[@value='      Cancel      ']")).click();
		 
		Alert alt = driver.switchTo().alert();
	 
	     String text = alt.getText();
	     System.out.println(text);
	 
	     alt.accept();

	}

}
