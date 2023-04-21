package Practice;

import org.testng.annotations.Test;

//@Test    // if write @test here all the methods executed under this class
public class SampleTestNg {
	
//@Test    Run only current method
	//@Test(priority = 2)
@Test
	public void createContact()
	{
		System.out.println("Contact Created");
	}
@Test(dependsOnMethods = "createContact") // only run if createContact method run successfully
                                          // if createContact method failed then other two dependent methods Skipped not failed
	public void modifyContact()
	{
		System.out.println("Modify Contact");
	}
@Test(invocationCount = 3)
public void deleteContact()
{
	System.out.println("Delete Modified");
}
// push again
}
