package Generic_Utility;

import java.sql.Date;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

/*WebdriverUtility  is a Generic class , which contains webdriver specific reusable actions like
	waitForPageToLoad()
	waitForElement()
	select()
	accpertAlert()
	cancelAlert()  .Etc*/

public class WebDriver_Utility {
	/**
	 * wait for page to load before identifying any synchronized element in DOM
	 * @param driver
	 */
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * after every action it will wait for next action to perform
	 * @param driver
	 */
	public void scriptTimeout(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	/**
	 * used to wait for element to be clickable in GUI and check for specific element for every 500 milliseconds
	 * 
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement Element,int pollingTime)
	{
		FluentWait wait=new FluentWait(driver);
	    wait.pollingEvery(Duration.ofSeconds(20));	
	    wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	public void toMaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * for switching window
	 * @author prakash
	 */
	public void switchToWindow(WebDriver driver, String partialVisibleText)
	{
		Set<String> allID = driver.getWindowHandles(); // save different window id randomly in allID variable	
		Iterator<String> id = allID.iterator();    // can use for loop but use iterator it is easy
		while(id.hasNext())   // hasnext() check wheather the address of window present in ID exist or not
		{
			String wid = id.next();
			driver.switchTo().window(wid);  // switch to first window
			String title = driver.getTitle();  // get title of first window
			
			if(title.contains(partialVisibleText))  // check condition if same window then break otherwise loop continue and going to another window
			{
				break;
			}
		}
	}
	/**
	 * used to switch to alert window and accept(click on ok button)
	 */
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * used to switch to alert window and dismiss(click on cancel button)
	 */
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to switch to frame window based on Index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
		}
	/**
	 * used to switch to frame window based on id or name attribute
	 */
	public void switchToFrame(WebDriver driver, String id_name_Attribute)
	{
		driver.switchTo().frame(id_name_Attribute);
	}
	/**
	 * used to select the value from the dropDown based on index
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropdown based on text
	 */
	public void select(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * used to place mouse cursor on specified location
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * used to right click on specific element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void moveByOffest(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}
	public  String takeScreenshot(WebDriver sDriver, String methodName) {
		
		Date date=new Date(0);
		date.toString().replace(" "," ").replace(":","-");
		//TakesScreenshot ts=(TakesScreenshot)driver;
		return null;
	}
}
