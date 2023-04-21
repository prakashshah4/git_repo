package Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import POM.HomePage;
import POM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver sdriver;    // re-initialising only for using in screenshot as it is static can only used here in same package
	public WebDriver driver;
	@BeforeSuite(groups = {"smoketest","regressiontest"})
	public void BS()
	{
		System.out.println("DataBase Connection");
	}
	
	@BeforeTest(groups = {"smoketest","regressiontest"})
	public void BT()
	{
		System.out.println("Parallel Execution");
	}
	
	//@Parameters("BROWSER")     // use this for cross browser execution
	@BeforeClass(groups = {"smoketest","regressiontest"})
	public void BC() throws Throwable
	//public void BC(String BROWSER) throws Throwable    //    use this for crossbrowser execution
	{
		Property_Utility plib = new Property_Utility();    // comment out this for cross browser execution
		String BROWSER = plib.getKeyValue("browser");      // comment out this for cross browser execution
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		System.out.println("Launching Browser");
		sdriver=driver;
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.toMaximize(driver);
		wlib.implicitWait(driver);
	}
	
	@BeforeMethod(groups = {"smoketest","regressiontest"})
	public void BM() throws Throwable	{
		Property_Utility plib = new Property_Utility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		
		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login Application");
	}
	
	@AfterMethod(groups = {"smoketest","regressiontest"})
	public void AM()
	{
		HomePage home = new HomePage(driver);
		home.signoutLink(driver);
		System.out.println("Logout Application");
	}
	
	@AfterClass(groups = {"smoketest","regressiontest"})
	public void AC()
	{
		driver.quit();
		System.out.println("Browser Closed");
	}
	
	@AfterTest(groups = {"smoketest","regressiontest"})
	public void AT()
	{
		System.out.println("Parallel Execution is Done");
	}
	
	@AfterSuite(groups = {"smoketest","regressiontest"})
	public void AS()
	{
		System.out.println("DataBase Connection Closed");
	}
}
