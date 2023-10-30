package aSSERTION;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx 
{
	@Test
	public void m1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(true, true);
		System.out.println("Step4");
		System.out.println("Step5");
		soft.assertAll();		
	}
	@Test
	public void m2()
	{
		String expData="Qspiders";
		String actdata="Qspiders";
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actdata, expData);
		soft.assertAll();
		
	}

}
