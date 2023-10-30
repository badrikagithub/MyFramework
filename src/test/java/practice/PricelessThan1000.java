package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PricelessThan1000 {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/search?q=nikeshoes&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off&p%5B%5D=facets.price_range.from%3DMin&p%5B%5D=facets.price_range.to%3DMax");
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3']"));
		int amount = prices.size();
		for(int i=0;i<amount;i++)
		{
		     	
		      if(amount<1000)
		      {
		    	  System.out.println(prices.get(i).getText());
		      }
		   
		}

	}

}
