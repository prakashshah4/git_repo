package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com/flights/");
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		Thread.sleep(1000);
		
		String month = "April 2023";
		String date = "10";
		
		// can write this also in one line
		//driver.findElement(By.xpath("//div[text()='"+month+"']//ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		// or
		driver.findElement(By.xpath("//div[text()='"+month+"']"
				+ "/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
	}

}
