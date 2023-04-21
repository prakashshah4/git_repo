package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	@Test
	public void method1()
	{
		String actualData = "Qspiders";
		String expectedData = "Jspiders";
		Assert.assertEquals(actualData, expectedData);
	}
@Test
	public void createContact()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		Assert.assertEquals(false, true);
		
		System.out.println("Step 3");
		System.out.println("Step 4");
		
	}
@Test
	public void deleteContact()
	{
		System.out.println("Step 5");
		System.out.println("Step 6");
	}

}
