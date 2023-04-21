package Generic_Utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Excel_Utility {
	public String getExcelFile(String key, int rowNum, int cellNum) throws Throwable // not fetch phone num or only integer etc
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(key);
		Row row = sheet.getRow(rowNum); 
		Cell cell = row.getCell(cellNum);
		String excelData = cell.getStringCellValue();
		return excelData;
	}
	public String getExcelDataFormatter(String key, int rowNum, int cellNum) throws Throwable // fetch phone num or only integer etc
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(book.getSheet(key).getRow(rowNum).getCell(cellNum));
		
		return data;
	}
	public Object[][] readMultipleData(String sheetName) throws Throwable 
	{
		FileInputStream fis1 = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet(sheetName);
		int lastRow = sh.getLastRowNum()+1; 
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0; j<lastCell;j++)
			{
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return obj;
	}
}
