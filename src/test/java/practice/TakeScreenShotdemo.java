package practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShotdemo {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		
	/*	TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File tar=new File("./ScreenShot/amazon.png");
		FileUtils.copyFile(src, tar);*/
		
		WebElement homedecor = driver.findElement(By.xpath("//div[@id='main-content']"));
		File src = homedecor.getScreenshotAs(OutputType.FILE);
		File tar=new File("./ScreenShot/homedecor.png");
		Files.copy(src, tar);
		
		
		driver.close();
		

	} 
 
}
