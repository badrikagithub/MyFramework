package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEX1 
{
	@Test(dataProvider="dataProviderExecute")
	public void bookTickets(String src,String dest)
	{
		System.out.println("book tickets from" +src+"to"+" "+" "+dest);
	}
	@DataProvider
	public Object[][] dataProviderExecute()
	{
		Object[][]obj=new Object[2][2];
		obj[0][0]="Mumbai";
		obj[0][1]="Delhi";
		
		obj[1][0]="Bangalore";
		obj[1][1]="mysore";
		
//		obj[2][0]="Goa";
//		obj[2][1]="puri";
				
		return obj;
		
	}

}
