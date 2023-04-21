package Campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreationPage1 {
	public CampaignCreationPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement campaignCreateImage;
	
	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement campaigneTextBox;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveLink;
	
	// declaration
	public WebElement getCampaigneimage()
	{
		return campaignCreateImage;
	}
	public WebElement getCampaigneBox()
	{
		return campaigneTextBox;
	}
	public WebElement getSaveBtn()
	{
		return saveLink;
	}
	
	//business logic
	public void clickOnCampaigneCreateImage()
	{
		campaignCreateImage.click();;
	}
	public void sendCampaigneData(String data)
	{
		campaigneTextBox.sendKeys(data);;
	}
	public void clickOnSaveBtn()
	{
		saveLink.click();
	}
}
