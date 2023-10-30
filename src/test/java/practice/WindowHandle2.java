package practice;



import java.util.Set;

import javax.xml.datatype.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class WindowHandle2 {

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Open New Seperate Windows']")).click();
		Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()='click']")).click();
	//driver.findElement(By.xpath("//a[text()='Watch the Videos']")).click();
	Set<String> allIds = driver.getWindowHandles();//1 //2  //3
	
	for(String id:allIds)
	{
		driver.switchTo().window(id);
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("Selenium"))
		{
			break;
		}
	}
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[text()='Watch the Videos']")).click();
	Thread.sleep(3000);
	Set<String> allWin = driver.getWindowHandles();
	for(String id:allWin)
	{
		driver.switchTo().window(id);
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("Frames & windows"))
		{
			break;
		}
	}

	}

}
