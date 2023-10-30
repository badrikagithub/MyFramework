package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.EqualsAndHashCode;

public class HandlingDropDownwithoutSelectclass {

	//static WebDriver driver;
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8888/");
		 //input[@type='submit']
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath(" //input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath(" //input[@type='submit']")).click();
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Mohanta");
		driver.findElement(By.name("company")).sendKeys("Wipro");
		
		 WebElement drp1 = driver.findElement(By.name("leadsource"));
		 
		 multipledropdownhandling(drp1,"employee");
		 
		 WebElement industrydrp = driver.findElement(By.name("industry"));
		 multipledropdownhandling(industrydrp,"construction");
		 
		 
//		 
//		 Select drpsel=new Select(drp1);
//		List<WebElement> alloptions = drpsel.getOptions();	
//		System.out.println(alloptions.size());
//		for(WebElement sel:alloptions)
//		{
//			if(sel.getText().equalsIgnoreCase("employee"))
//					{
//				             sel.click();
//				                break;	
//					}
//			
			
		}
		
		
		

	public static void multipledropdownhandling(WebElement ele,String value)
	{
		 Select drp=new Select(ele);
		List<WebElement> alloptions = drp.getOptions();
		for(WebElement sel:alloptions)
		{
			if(sel.getText().equalsIgnoreCase(value))
					{
				             sel.click();
				                break;	
					}
			
			
		}
		
	}

}

