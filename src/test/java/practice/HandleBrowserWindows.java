package practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	    String windowID = driver.getWindowHandle();//return the id of current page
	  // System.out.println(windowID); //RETURN THE WINDOW ID=B7E1768A273F4327D9C35FC451041231
	    Thread.sleep(1000);
	   driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
	  
	  
	   //getwindowHandles used for extracting  multiple windows IDs.
	   
        Set<String> winIDs = driver.getWindowHandles();   
	   System.out.println(winIDs);
	/*/1st method (Iterator)
	   Iterator<String> it = winIDs.iterator();
	  String parentWinID = it.next();
	  String childwinId = it.next();
	  System.out.println("parent Window ID="+parentWinID);
	  System.out.println("Child Window ID="+childwinId);*/
	   
	   
	   //2nd Method(For eaach loop) //how to used window id for switching the windows
	   
	   for(String id:winIDs)
	   {
		   String title = driver.switchTo().window(id).getTitle();
		   System.out.println("Title of the pages"+title);
	   }
	}

}
