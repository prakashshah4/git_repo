package Campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaigneValidationAndVerificationPage {
	public CampaigneValidationAndVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(className = "dvHeaderText")
	private WebElement actualCampaigneData;
	
	//declaration
	public WebElement getActualCampaigneData()
	{
		return actualCampaigneData;
	}
	
	//business logic
	public void campaigneValidation(String data)
	{
		String actData = actualCampaigneData.getText();
		if(actData.contains(data))
		{
			System.out.println("Validation Pass");
		}
		else
		{
			System.out.println("Validation Fails");
		}

	}
}
