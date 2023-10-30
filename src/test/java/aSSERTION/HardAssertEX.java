package aSSERTION;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEX 

{
	@Test
	public void m1()
	{
		System.out.println("step1");
		String expData="Qspider";
		String actData="qspider";
		Assert.assertEquals(actData, expData);
		System.out.println("step2");
		System.out.println("step3");
	}
	@Test
	public void m2()
	{
		System.out.println("step4");
		Assert.assertEquals(true, true);
	}

}
