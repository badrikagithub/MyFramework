package Generic_Utility;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.ode.events.EventFilter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener
{
	public void onTestFailure(ITestResult result)
	{
		/*String testName = result.getMethod().getMethodName();
		System.out.println("---------execute-----------");
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.Sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(src, new File("./ScreenShots/"+testName+".png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}*/
		//another Approach to take runtime screenshot
		
		String testName = result.getMethod().getMethodName();
		System.out.println("---------execute-----------");
		
		TakesScreenshot screen=(TakesScreenshot)BaseClass.Sdriver;
		File scr = screen.getScreenshotAs(OutputType.FILE);
		LocalDateTime localdateandtime=LocalDateTime.now();
		localdateandtime.toString().replace(" ","_" ).replace(":", "/");
		 File dest = new File("./ScreenShot/"+testName+".png");
		 try {
			 FileUtils.copyFile(scr, dest);
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 
			 System.out.println("problem is saving as screenshot"+e.getMessage());
			 
		 }
		
	}

}
