package product;

import org.testng.annotations.Test;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM.HomePage;

public class CreateProductTest extends BaseClass {
@Test(groups = {"smoketest","regressiontest"})
	public void createProduct() throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.implicitWait(driver);
	
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		
		ProductCreationPage1 prodPage = new ProductCreationPage1(driver);
		prodPage.clickOnProductCreateImage();
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility eLib = new Excel_Utility();
		String excelData = eLib.getExcelDataFormatter("product",0,0) + ranNum;
		prodPage.sendProductData(excelData);
		prodPage.clickOnSaveBtn();
		ProductValidationAndVerificationPage prodValidation = new ProductValidationAndVerificationPage(driver);
		prodValidation.productValidation(excelData);
		prodPage.clickOnDeleteBtn(driver);

	}

}
