package Campaigns;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM.HomePage;

public class failCampaigneForIRetryAnalyser extends BaseClass {
	
	@Test(retryAnalyzer = Generic_Utility.RetryExample.class)
	public void failCampaigne() throws Throwable {
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.implicitWait(driver);
		
		HomePage home = new HomePage(driver);
		home.moreLink(driver);
		home.campaigneLinkText();
		
		CampaignCreationPage1 camPage = new CampaignCreationPage1(driver);
		camPage.clickOnCampaigneCreateImage();
		Assert.assertEquals(false, true);   // for failing the script
		
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
