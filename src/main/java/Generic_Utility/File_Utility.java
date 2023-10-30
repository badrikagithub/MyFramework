package Generic_Utility;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility 
{
	public String getStringKeyAndValue(String key) throws Throwable 
	{
	//	FileInputStream fis=new FileInputStream("src/test/resources/DDTpropertyfile.properties");
		FileInputStream fis=new FileInputStream(IpathConstant.FILEUTILITY_PATH);
				
		
		Properties pro=new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
	}

}
