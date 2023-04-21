package product;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;

public class ProductCreationPage1 {
	public ProductCreationPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement productCreateImage;
	
	@FindBy(xpath = "//input[@name='productname']")
	private WebElement productTextBox;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveLink;
	
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement deleteLink;
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement campPageProductImage;
	
	// declaration
	public WebElement getProductimage()
	{
		return productCreateImage;
	}
	public WebElement getProductBox()
	{
		return productTextBox;
	}
	public WebElement getSaveBtn()
	{
		return saveLink;
	}
	public WebElement getDeleteBtn()
	{
		return deleteLink;
	}
	public WebElement getCampPageProductImage()
	{
		return campPageProductImage;
	}
	
	//business logic
	public void clickOnProductCreateImage()
	{
		productCreateImage.click();;
	}
	public void sendProductData(String data)
	{
		productTextBox.sendKeys(data);;
	}
	public void clickOnSaveBtn()
	{
		saveLink.click();
	}
	public void clickOnDeleteBtn(WebDriver driver)
	{
		deleteLink.click();
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	public void clickCampPageProductImage(WebDriver driver, String partialText)
	{
		campPageProductImage.click();
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.switchToWindow(driver, partialText);
	}
}
