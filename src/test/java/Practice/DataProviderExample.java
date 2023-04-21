package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	@Test(dataProvider = "dataProvider")     //should be same as data provider method name
	public void bookTickets(String src , String des)
	{
		System.out.println("Tickets Booked from "+src+" to "+des);
	}
	
	@DataProvider
	public Object[][] dataProvider()
	{
		Object[][] objarr = new Object[3][2];
		objarr[0][0] = "Banglore";
		objarr[0][1] = "mysore";
		objarr[1][0] = "Banglore";
		objarr[1][1] = "hyd";
		objarr[2][0] = "Banglore";
		objarr[2][1] = "chd";
		
		return objarr;
	}
}
