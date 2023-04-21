package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Excel_Utility;

public class DataFromExcelSheet {
	
	@Test(dataProvider = "getExcelData")
	public void testExcel(String s1, String s2)
	{
		System.out.print(s1 + " " +s2+" ");
	}
	
	
	@DataProvider
	public Object[][] getExcelData() throws Throwable
	{
		Excel_Utility elib = new Excel_Utility();
		Object[][] value = elib.readMultipleData("Sheet1");
		return value;
	}
}
