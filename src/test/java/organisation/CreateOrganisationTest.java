package organisation;

import org.testng.annotations.Test;
import Generic_Utility.WebDriver_Utility;
import POM.HomePage;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;

public class CreateOrganisationTest extends BaseClass {
	// public static void main(String[] args) throws Throwable {
	// remove main method and used test annotation
	@Test(groups = {"smoketest","regressiontest"})
	public void createOrganisation() throws Throwable {
		//System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*FileInputStream fis = new FileInputStream("./src/test/resources/PropertyFileData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
		
		/* Without using property File to open url
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");*/
		
		// can use it from property utility instead of using above
		//Property_Utility plib = new Property_Utility();
		// Below code run under Base class
		/*String BROWSER = plib.getKeyValue("browser");
		
		WebDriver driver;
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
		}*/
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.implicitWait(driver);
		/*String URL = plib.getKeyValue("url");  // get from base class BM annotation
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApp(USERNAME, PASSWORD);*/
        
        HomePage home=new HomePage(driver);
        home.clickOrganizationsLinkText();
		
		//driver.findElement(By.linkText("Organizations")).click();
        OrganizationCreationPage1 org=new OrganizationCreationPage1(driver);
        org.clickOrganizationCreateImage();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		/*FileInputStream fes = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Organisation");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String excelData = cell.getStringCellValue();*/
		
		// or can use Excel_Utility class which created
		Excel_Utility exLib = new Excel_Utility();
		String excelData = exLib.getExcelFile("product",0,0) + ranNum;
		
		org.organizationNamesTextField(excelData);
		//driver.findElement(By.name("accountname")).sendKeys(excelData);
		org.saveButton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
        
        validate.organisationValidation(driver, excelData);
		
		/*String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(actdata.contains(excelData))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}*/
		
       /* home.signoutLink(driver);  // get from base class AM annotation
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();*/  // get from base class AC annotation
}
}
