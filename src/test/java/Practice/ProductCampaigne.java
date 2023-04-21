package Practice;

import org.testng.annotations.Test;

import Campaigns.CampaignCreationPage1;
import Campaigns.CampaigneValidationAndVerificationPage;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM.HomePage;
import product.ProductCreationPage1;
import product.ProductValidationAndVerificationPage;

public class ProductCampaigne extends BaseClass {
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
	@Test
	public void method1()
	{
		System.out.println("This is one method");
	}
	
	@Test(groups = "smoketest")
	public void createCampaigns() throws Throwable {
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.implicitWait(driver);
		
		HomePage home = new HomePage(driver);
		home.moreLink(driver);
		home.campaigneLinkText();
		
		CampaignCreationPage1 camPage = new CampaignCreationPage1(driver);
		camPage.clickOnCampaigneCreateImage();
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility exLib = new Excel_Utility();
		String campData = exLib.getExcelFile("Campaigns",0,0) + ranNum;
		
		camPage.sendCampaigneData(campData);
		
		camPage.clickOnSaveBtn();		
		CampaigneValidationAndVerificationPage camValidation = new CampaigneValidationAndVerificationPage(driver);
		camValidation.campaigneValidation(campData);

	}
}
