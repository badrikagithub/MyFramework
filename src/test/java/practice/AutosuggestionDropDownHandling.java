package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutosuggestionDropDownHandling {

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, null);
		
		driver.get("https://www.google.com/");
		//Thread.sleep(3000);
		 driver.findElement(By.id("APjFqb")).sendKeys("selenium");
			Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[1]//span"));//11
		
		
		System.out.println(list.size());//11
		for(WebElement option:list)
		{
			if(option.getText().contains(" download"))
			{
				Thread.sleep(3000);
				option.click();
				break;
			}
		}
		
	}

}
