package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
 public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com");
	driver.close();
}
}
