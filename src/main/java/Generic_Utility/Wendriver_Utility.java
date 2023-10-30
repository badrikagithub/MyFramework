package Generic_Utility;

//import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Wendriver_Utility 
{
	public void maximizeScreen(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void minimizeScreen(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	 
	public void implicitwait(WebDriver driver)
	
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	
	public void switchWindow(WebDriver driver,String partialText)
	{
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> id = allWindows.iterator();
		while(id.hasNext())
		{
			String win = id.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			
			if(title.contains(partialText))
			{
				break;
			}		
		}
	}
	/**
	 * used to switch to AlertWindow and accept(click on ok button)
	 * @param driver
	 * @author Badrika
	 */
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	
	/**
	 * used to switch to AlertWindow and dismiss(click on cancel button)
	 * @param driver
	 */
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	
	}
	/**
	 * used to switch to frame window based on Index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
	   driver.switchTo().frame(index);
	}
	/**
	 * used to switch to frame window based on id or name attribute
	 * @param driver
	 * @param id_name_Attribute
	 */
	public void switchToFrame(WebDriver driver,String id_name_Attribute)
	{
		driver.switchTo().frame(id_name_Attribute);
	}
	/**
	 * ussed to select the vaalue from the dropdown based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropdown based on text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByValue(text);
	}
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void actionMoveToElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * used to right click on specific element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void moveByOffset(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}
	/**
	 * used to scroll up to the element of which path is written
	 * @param driver
	 * @param element
	 */
	public void javaScriptExecutor(WebDriver driver,WebElement element) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;//scroll up to the path written for the element
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	/**
	 * used to accept the ok button on popup
	 * @param driver
	 */
	public void AlertPopUpHandle( WebDriver driver)
	{
		
		Alert alertpopup = driver.switchTo().alert();
	       alertpopup.accept();
	}
	public void Alertdismiss(WebDriver driver)
	{
		Alert alertpopup = driver.switchTo().alert();
	       alertpopup.dismiss();
	}
	
    public void ActionsMoveToElement(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver) ;
		act.moveToElement(ele).perform();
	}
	
	
	
	
	
	
	
	

}
