package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestion2 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();

		WebDriver driver;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
driver.findElement(By.xpath("//button[contains(.,'✕')]")).click();
		
WebElement data = driver.findElement(By.name("q"));
data.sendKeys("bluetooth");
Thread.sleep(4000);
List<WebElement> suggestion = driver.findElements(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']/li"));//1of8 //puma shoes
 // System.out.println(suggestion);                   //8
for(WebElement wb:suggestion)
{
	String text = wb.getText();
	if(text.contains(" headset boat"))
	{
		Thread.sleep(2000);
		wb.click();
		break;
}
}
}

}
