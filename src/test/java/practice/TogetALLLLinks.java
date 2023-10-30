package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TogetALLLLinks {

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println(allLinks.size());
		for(WebElement link:allLinks)
		{
			System.out.println("list of Links  "+" "+link.getAttribute("href"));
		}

	}

}
//first need to locate the team(bangaluru bulls) then traverse to the respective row(entire row) and fetch the required data(win,loss).
	//   /.. ------------->>traverse from child to parent/back traversing
	

//p[text()='Bengaluru Bulls']/../../../../div[@class='table-data matches-lost']/p