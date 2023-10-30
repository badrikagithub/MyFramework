package JavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.JavaScript_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptEX {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new  ChromeDriver();
		
		JavaScript_Utility jslib=new JavaScript_Utility (driver);
		jslib.launchApplication("http://localhost:8888");
		WebElement username = driver.findElement(By.name("user_name"));
		jslib.sendkeys(username, "admin");
		
		WebElement password = driver.findElement(By.name("user_password"));
		jslib.sendkeys(password, "admin");
		
		WebElement loginbutton = driver.findElement(By.id("submitButton"));
		jslib.click(loginbutton);
		
		WebElement scollupto = driver.findElement(By.xpath("//a[text()='Read License']"));
		jslib.scrollDown();
	

	}

}
