package practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com");
		WebElement jobs = driver.findElement(By.xpath("//div[.='Jobs']"));

		Actions act = new Actions(driver);
		act.moveToElement(jobs).perform();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Jobs by skill']")).click();
		
		driver.findElement(By.xpath("//div[.='Services']")).click();
		
	//	driver.findElement(By.xpath("//span[.='FIND JOBS']")).click();
	
		String mainId = driver.getWindowHandle();
		System.out.println(mainId);
		
		Set<String> allids = driver.getWindowHandles();
	System.out.println(allids);
	
	for(String id:allids)
	{
		if(!mainId.equals(id))
		{
			driver.switchTo().window(id);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[.='FIND JOBS']")).click();
		}
	}
	
	driver.switchTo().window(mainId);
	//driver.close();

	}

}
