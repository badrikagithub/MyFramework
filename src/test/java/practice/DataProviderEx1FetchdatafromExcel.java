package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Excel_utility;

public class DataProviderEx1FetchdatafromExcel 
{
	@Test(dataProvider="geteData")
	public void bookTickets(String src,String dest)
	{
		System.out.println("book tickets from"+" " +src+" "+"to"+" "+dest);
	}
    @DataProvider
    public Object[][] geteData() throws Throwable
    {
    	Excel_utility elib=new Excel_utility();
    	Object[][] value = elib.readMultipledata("DataProvider");
    	
    	
		return value;
    	
    }

}
