package Campaigns;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM.HomePage;
import product.ProductCreationPage1;
import product.ProductValidationAndVerificationPage;

public class CreateCampaigneWithProductTest extends BaseClass {
@Test(groups = "regressiontest")
	public void createCampaigneWithProduct() throws Throwable {
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
		home.moreLink(driver);
		home.campaigneLinkText();
		CampaignCreationPage1 camPage = new CampaignCreationPage1(driver);
		camPage.clickOnCampaigneCreateImage();
		String campData = eLib.getExcelFile("Campaigns",0,0) + ranNum;
		camPage.sendCampaigneData(campData);
		prodPage.clickCampPageProductImage(driver , "Products&action");
	
		driver.findElement(By.id("search_txt")).sendKeys(excelData);
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.xpath("//a[text()='"+excelData+"']")).click();
		wlib.switchToWindow(driver, "Campaigns&action");
		camPage.clickOnSaveBtn();
		CampaigneValidationAndVerificationPage camValidation = new CampaigneValidationAndVerificationPage(driver);
		camValidation.campaigneValidation(campData);
		prodValidation.productValidationLastPage(excelData);
		
	}

}
