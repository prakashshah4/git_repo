package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;

public class HomePage {
	public HomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// declaration
	@FindBy(linkText="Products")
	private WebElement productLinkText;
	
	@FindBy(linkText="More")
	private WebElement morelink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLinkText;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLinkText;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLinkText;
	
	//getter Methods
	
	public WebElement getOrganizationLinkText() {
		return organizationLinkText;
	}
	public WebElement getSignoutImg() {
		return signoutImg;
	}
	public WebElement getSignoutLinkText() {
		return signoutLinkText;
	}
	public WebElement getMorelink() {
		return morelink;
	}
	public WebElement getCampaignsLinkText() {
		return campaignsLinkText;
	}
	public WebElement getProductLinkText() {
		return productLinkText;
	}
	
	// Business logic for Product
	public void clickProductLink()
	{
		productLinkText.click();
	}
	// Business logic for More
	public void moreLink(WebDriver driver)
	{
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.mouseOverOnElement(driver, morelink);
	}
	//Campaigns
	public void campaigneLinkText()
	{
		campaignsLinkText.click();
	}
	//Organization
	public void clickOrganizationsLinkText()
	{
		organizationLinkText.click();
	}
	//Sign Out
	public void signoutLink(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(signoutImg).perform();
		signoutLinkText.click();
	}
	
}
