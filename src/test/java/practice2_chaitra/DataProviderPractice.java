package practice2_chaitra;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderPractice
{
	@Test(dataProvider="getData")
	public void AddproductToCart(String Name,int price,int qty)
	{
		System.out.println("name-"+Name+"price-"+price+"quantity-"+qty);
	}
	@DataProvider
	public Object[][] getData()
	{
	Object[][]data=new Object[2][3];
	
	data[0][0]="MI";
	data[0][1]=13000;
	data[0][2]=20;
	
	data[1][0]="Moto";
	data[1][1]=15000;
	data[1][2]=30;
	
	return data;
	
		
	}
	

}
