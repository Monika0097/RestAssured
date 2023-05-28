package utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
	public ExcelUtility(String excelPath, String sheetName) throws IOException
	{
		wb = new XSSFWorkbook(excelPath);
		sheet = wb.getSheet(sheetName);		
	}
	public static int getRowCount()
	{

     	int	rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("The number of Row present in Sheet : "+ rowCount); 
		return rowCount;
	}
	public static int getColumnCount()
	{
		int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("The number of Column present in Sheet : "+ columnCount); 
		return columnCount;
	}
	public static String getCellValue(int row , int column)
	{
		String cellValue = sheet.getRow(row).getCell(column).getStringCellValue();
	//System.out.println("The value present in given cell is : " +cellValue); 
		return cellValue;
	}
	
	

}
