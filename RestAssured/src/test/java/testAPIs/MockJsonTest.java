package testAPIs;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import payload.ComplexJson;
import reusableMethods.JsonPathObect;

public class MockJsonTest {

	@Test
	public void testComplexJson()
	{
      
		JsonPath js = JsonPathObect.convertToJson(ComplexJson.parseJson());
		
		// #1  Print the No of courses returned by complete API
		
		int courseCount = js.getInt("courses.size()");
		System.out.println("Number of courses returned by API : "+ courseCount);
		
		//#2 Print Purchase Amount
		
		int puchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("The value of purchaseAmount is : "+puchaseAmount);
		
		//#3 Print title of first course
		
		String firstCourseTitle = js.getString("courses[0].title");
		System.out.println("The Title of first course is : "+ firstCourseTitle); 
		
		//#4 Print all courses, titles and their respective prices
		
		for(int i =0; i<courseCount; i++)
		{
			String course= js.getString("courses["+i+"].title");
			System.out.println("Name of "+i+" course is : "+ course); 
			int price= js.getInt("courses["+i+"].price");
			System.out.println("Price of "+i+" course is : "+ price); 
			int copies = js.getInt("courses["+i+"].copies");
			System.out.println("Copies of "+i+" course is : "+ copies); 
			
		}
		
		//#5 Print No of course sold by Cypress
		
		for(int i=0; i<courseCount;i++)
		{
			String courseName = js.getString("courses["+i+"].title");
			if(courseName.equalsIgnoreCase("cypress"))
			{
				int copiesSold = js.getInt("courses["+i+"].copies");
				System.out.println("The No oc copies sold by Cypress is :"+ copiesSold);
			}
			
		}
		
		// #6 Verify if sum of all courses matches with purchaseAmunt
		
		int sum=0;
		for(int i=0; i<courseCount; i++)
		{
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int totalAmount = price*copies;
			sum= sum+totalAmount;
			System.out.println("Total Amount for "+js.getString("courses["+i+"].title")+" is  =  "+sum); 
			
		}
		System.out.println("The total amount for all courses is : "+ sum);
		Assert.assertEquals(puchaseAmount, sum);
		System.out.println("Purchase Amount is verified"); 
		
		
		
		

	}

}
