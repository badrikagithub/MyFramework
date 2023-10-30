
	
		

package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PointsTable {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/standings");
		
		driver.findElement(By.xpath("//div[@class='table standings-table']"));//table
		WebElement team = driver.findElement(By.xpath("//p[text()='Patna Pirates']"));
		String TeamName = team.getText();
	
		WebElement won = driver.findElement(By.xpath("//p[text()='"+TeamName+"']/../../../../div[@class='table-data matches-won']/p[@class='count']"));
		String win = won.getText();
		
		WebElement loss = driver.findElement(By.xpath("//p[text()='"+TeamName+"']/../../../../div[@class='table-data matches-lost']/p"));
		String lost = loss.getText();
		
		//System.out.println("TeamName"+ " "+TeamName+" "+"win="+win+" "+"Loss="+lost);
		System.out.print("TeamName"+ " "+TeamName+" "+"win="+win+" "+"Loss="+lost);
		
		
	}
	

}