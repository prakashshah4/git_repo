package Generic_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Property_Utility {
	
	public String getKeyValue(String key) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src/test/resources/PropertyFileData.properties");
		Properties pro = new Properties();
		pro.load(fes);
		String value = pro.getProperty(key);
		return value;
		
	}
}
