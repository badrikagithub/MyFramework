package practice;

import org.testng.annotations.Test;

public class TestNG {

	   @Test(priority=-1)
		public void createdContact()
		{
		  System.out.println("ContactCreated");
		}
	   @Test(priority=0)
	   public void modifyContact()
	   {
		   System.out.println("ContactModified");
	   }
	   @Test(enabled=false)
	   public void deleteContact()
	   {
		   System.out.println("ContactDeleted");
	   }
		
	

}
