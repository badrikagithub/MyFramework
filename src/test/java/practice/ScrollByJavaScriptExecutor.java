package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollByJavaScriptExecutor {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.amazon.com/");
//		driver.manage().window().maximize();
//		
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		for(int i=0;i<3;i++)
		{
			js.executeScript("window.scrollBy(0,1500)");//this window.scrollby have to write manually
			Thread.sleep(1000);
		}
		
		for(int i=0;i<2;i++)
		{
			js.executeScript("window.scrollBy(0,-1500)");//for scroll up gives(0,-1500)
			Thread.sleep(1000);
		}*/
		
		
		
		//another methos for scrolling i.e scroll upto the specific element and click
		driver.get("https://www.facebook.com/signup/");
		driver.manage().window().maximize();
		WebElement helpele = driver.findElement(By.xpath("//a[.='Help']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", helpele);
		helpele.click();

	}

}
