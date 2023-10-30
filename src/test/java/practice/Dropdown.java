package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {//3 method-->>keys class,select class and by using x path

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/signup/");
		driver.manage().window().maximize();
		//by using selectbyindex
		/*WebElement datelist = driver.findElement(By.id("day"));
		Thread.sleep(1000);
		Select sel=new Select(datelist);
		sel.selectByIndex(10);//index start from index 0=1  10=11date*/
		
		
		/*//by using select by value
		WebElement datelist = driver.findElement(By.id("day"));
		Select sel=new Select(datelist);
		sel.selectByValue("1");*/
		
	/*	//by using select by visibletext
		WebElement datelist = driver.findElement(By.id("day"));
		Select sel=new Select(datelist);
		sel.selectByVisibleText("21");*/
		
		//Select by using xpath
		WebElement monthlist = driver.findElement(By.id("month"));
		driver.findElement(By.xpath("//option[text()='May']")).click();
		
		

	}

}
