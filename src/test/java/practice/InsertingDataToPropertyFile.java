package practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class InsertingDataToPropertyFile {

	public static void main(String[] args) throws Throwable
	{
		Properties pro=new Properties();
		pro.setProperty("browser", "chrome");
		pro.setProperty("url", "https://demo.actitime.com/login.do");
		pro.setProperty("username", "admin");
		pro.setProperty("password", "manager");
		
		FileOutputStream fout=new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/commonData");
		pro.store(fout, "common Data");
		fout.close();

	}

}
