package testAPIs;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import payload.PostExcel;
import utility.ExcelUtility;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class PostViaExcel {
	
	@Test(dataProvider = "Excel Data Provider" )
	public void postTest(String email, String fname, String lname)
	{
		   RestAssured.baseURI= "https://reqres.in/api";
			  String response = given().log().all().body(PostExcel.postRequest(email, fname))
					   .when().delete("/users")
					   .then().log().all().assertThat().statusCode(204).extract().response().asString();
					   
			  System.out.println(response); 
	}
	
    public static String file= "C:\\Users\\monika bilung\\git\\RestAssured\\RestAssured\\Excel\\RestAPIdata.xlsx";
	public static String sheet = "Sheet1";
	
	@DataProvider(name = "Excel Data Provider")
	public static Object[][] getData() throws IOException
	{
		Object[][] data=getExcelData(file,sheet);
		return data;
	}
	
		public static Object[][] getExcelData(String excelPath, String sheetName) throws IOException
	{
		ExcelUtility excel = new ExcelUtility(file, sheet);
		int rowCount = excel.getRowCount();
		int colCount= excel.getColumnCount();
		
		Object[][] data = new Object[rowCount-1][colCount];
		
		for(int i =1; i< rowCount;i++)
		{
			for(int j = 0; j<colCount; j++)
			{
				String cellData = excel.getCellValue(i, j);
				System.out.println(cellData);
				data[i-1][j]=cellData	;
			}
		}
		return data;
	}

}
