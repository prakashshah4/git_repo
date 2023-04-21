package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;

public class GetIphoneNameFromAmazon extends BaseClass {
	@Test
	public void copyPhoneNameInExcel() throws Throwable {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> phoneName = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet2");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		for(WebElement name : phoneName)
		{
			String pName = name.getText();
			cell.setCellValue(pName);
			FileOutputStream fos = new FileOutputStream("\"./src/test/resources/ExcelSheetData.xlsx\"");
			book.write(fos); 
			
			
		}
	}
	
}
