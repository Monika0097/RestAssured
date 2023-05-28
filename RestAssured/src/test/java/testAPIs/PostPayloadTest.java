package testAPIs;


import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import payload.PostPayload;

import static io.restassured.RestAssured.*;

public class PostPayloadTest {
	
	public static String name="Missy Pablo";
	public static String job = "Teacher";
	
	@SuppressWarnings("deprecation")
	@Test
	public static void addJob()
	{
		RestAssured.baseURI="https://reqres.in/api";
		String response = given().log().all().body(PostPayload.postRequest(name, job))
		.when().post("/users")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String id = js.getString("id");
		
		System.out.println("The ID of added description is : "+ id); 
		
		
		 String getResponse = given().log().all()
		.when().get("/users")
		.then().log().all().assertThat().body("page",equalTo(1)).extract().response().asString();
		 
		 JsonPath json = new JsonPath(getResponse);
		int page =  json.get("per_page");
		Assert.assertEquals(6, page);
		
		 System.out.println(getResponse);

	}

}
