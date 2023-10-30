package Generic_Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScript_Utility 
{
	JavascriptExecutor js;
	public  JavaScript_Utility(WebDriver driver)
	{
		js=(JavascriptExecutor)driver;
	}
	public void launchApplication(String url)
	{
		js.executeScript("window.location=arguments[0]", url);
	}
	public void sendkeys(WebElement element,String data)
	{
		js.executeScript("arguments[0].value=arguments[1]", element,data);
	}
	public void click(WebElement element)
	{
		js.executeScript("arguments[0].click()", element);
	}
	public String getUrlofCurrentPage()
	{
	    String  url=(String) js.executeScript("return window.location.herf");
		return url;	
	}
	public String getTitleOfCurrentPage()
	{
		 String  title=(String) js.executeScript("return document.title");
		 return title;	
	}
	public void scrollUp()
	{
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight");
	}
	/**
	 * 
	 */
	public void scrollDown()
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight");
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void javaScriptExecutor(WebDriver driver,WebElement element) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;//scroll up to the path written for the element
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

}
