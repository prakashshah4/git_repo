package Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void createContact()
	{
		System.out.println("Test 1");
		System.out.println("Test 2");
		System.out.println("Test 3");
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(false, true);
		
		System.out.println("Test 4");
		System.out.println("Test 5");
		soft.assertAll();
	
	}
}
