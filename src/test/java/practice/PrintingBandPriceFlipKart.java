package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintingBandPriceFlipKart {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new  ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nike Shooes");
		driver.findElement(By.id("nav-search-submit-text")).click();
		
		List<WebElement> brands = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base']"));
		List<WebElement> details = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		for(int i=0;i<prices.size();i++)

		{
			System.out.println(brands.get(i).getText()+"  "+details.get(i).getText()+"  "+prices.get(i).getText());		
		}
	/*	System.out.println(brands.size());
	used for getting individual values for each loop
		for(WebElement e:brands)
		{
			String allbrands = e.getText();
			System.out.println(allbrands);
			
		}*/

	}

}
