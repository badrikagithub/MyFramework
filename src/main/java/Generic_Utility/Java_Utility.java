package Generic_Utility;

import java.util.Random;

public class Java_Utility 
{
	public int getRandomNum()
	{/**
	*This method is used to avoid duplicate
	*@return
	*@author Badrika
	*/
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;

	}

}
