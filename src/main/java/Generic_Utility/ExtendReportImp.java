package Generic_Utility;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportImp implements ITestListener
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) 
	{
		//STEP-3 Create Test methods during the test execution start
		report.createTest(result.getMethod().getMethodName());


	}

	public void onTestSuccess(ITestResult result) 
	{
		//STEP-4  Log the pass method
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result)
	{
		//STEP 5:- Log the Fail Method
		String testName = result.getMethod().getMethodName();
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
		}

	}

	public void onTestSkipped(ITestResult result) 
	{
		//STEP-6:-Log the Skip Method
		test.log(Status.SKIP, result.getMethod().getMethodName());


	}

	public void onStart(ITestContext context) 
	{/*step-1:-Extent Report configuration*/
		Date d=new Date();
		System.out.println(d);
		d.toString().replace(":", "-").replace(" ", "*");
		
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(new File("ExtentReports.html"));
		htmlreport.config().setDocumentTitle("Vtiger ExtendReport");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Automation Test");
		
		//STEP-2 Attach the physical report and do the system configuration
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Environment", "Automation Testing");
		report.setSystemInfo("url", "http://localhost:8888/");
		report.setSystemInfo("ReporterName", "Badrika");
	}

	public void onFinish(ITestContext context) 
	{
		report.flush();


	}

}
