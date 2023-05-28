package utility;

import java.io.IOException;

import javax.xml.crypto.Data;

import org.testng.IExecutionListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
//    public static String file= "C:\\Users\\monika bilung\\OneDrive\\Desktop\\seleniumDemo\\RestAssured\\Excel\\RestAPIdata.xlsx";
//	public static String sheet = "Sheet1";
//	
//	@DataProvider(name = "Excel Data Provider")
//	public static Object[][] getData() throws IOException
//	{
//		Object[][] data=getExcelData(file,sheet);
//		return data;
//	}
//	
//		public static Object[][] getExcelData(String excelPath, String sheetName) throws IOException
//	{
//		ExcelUtility excel = new ExcelUtility(file, sheet);
//		int rowCount = excel.getRowCount();
//		int colCount= excel.getColumnCount();
//		
//		Object[][] data = new Object[rowCount-1][colCount];
//		
//		for(int i =1; i< rowCount;i++)
//		{
//			for(int j = 0; j<colCount; j++)
//			{
//				String cellData = excel.getCellValue(i, j);
//				System.out.println(cellData);
//				data[i-1][j]=cellData	;
//			}
//		}
//		return data;
//	}

}
