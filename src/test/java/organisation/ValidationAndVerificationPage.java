package organisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidationAndVerificationPage {
	public ValidationAndVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
  @FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement actualOrganizationData;
	
  //getter method
	public WebElement getActualOrganizationData() {
		return actualOrganizationData;
	}
	
	//Business logics
	public void organisationValidation(WebDriver driver,String data)
	{
		String actData = actualOrganizationData.getText();
	Assert.assertEquals(actData, data);
	}
}
