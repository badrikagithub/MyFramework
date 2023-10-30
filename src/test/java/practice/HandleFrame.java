package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrame {

	public static void main(String[] args) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		//1st frame
		driver.switchTo().frame("packageListFrame");//frame(name locator) driver switch to the frame first thn click on the element
		driver.findElement(By.xpath("/html/body/main/ul/li[1]/a")).click();
		driver.switchTo().defaultContent();//back to 1st frame
		
		Thread.sleep(3000);
		driver.switchTo().frame("packageFrame");		 
		driver.findElement(By.xpath("//span[text()='HasCapabilities']")).click();
		driver.switchTo().defaultContent();
		
		//3rd frame
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("(//a[text()='Help'])[1]")).click();

	}

}
