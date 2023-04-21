package product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductValidationAndVerificationPage {
	public ProductValidationAndVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@id='dtlview_Product Name']")
	private WebElement actualProductData;
	
	@FindBy(xpath = "//span[@id='dtlview_Product']")
	private WebElement actualProductDataEndPage;
	
	//declaration
	public WebElement getActualProductData()
	{
		return actualProductData;
	}
	public WebElement getActualProductDataEndPage()
	{
		return actualProductDataEndPage;
	}
	
	//business logic
	public void productValidation(String data)
	{
		String actData = actualProductData.getText();
		Assert.assertEquals(actData, data);
	}
	public void productValidationLastPage(String data)
	{
		String actData = actualProductDataEndPage.getText();
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
