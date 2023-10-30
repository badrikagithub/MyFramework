package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectingCheckBox {

	public static void main(String[] args) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		
		//selecting single chkbox
		//driver.findElement(By.id("monday")).click();
		
		//selecting all CheckBoxes
		
		List<WebElement> chkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,\"day\")]"));
		
		/*	System.out.println(chkboxes.size());
		for(WebElement wb:chkboxes)
		{
			wb.click();
		}*/
		
		//selecting specific checkbox ex:monday & sunday
		
		/*for(WebElement wb:chkboxes)
		{
			String day = wb.getAttribute("id");
			if(day.equals("monday")|| day.equals("sunday")||day.equals("friday"))
			{
			   wb.click();
			}
		}*/
	/*	//select last two check box (important for interview)
		int totalchkbox = chkboxes.size();
		for(int i=totalchkbox-2;i<totalchkbox;i++)
		{
			chkboxes.get(i).click();
			
		}*/
		
		int totalchkbox = chkboxes.size();
		for(int i=0;i<totalchkbox;i++)
		{
			if(i<3)
			{
				Thread.sleep(2000);
				chkboxes.get(i).click();
			}
			
		}
		
	}

}
