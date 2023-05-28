package testAPIs;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.PatchPayload;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PatchPayloadTest {
	
	public static String email = " pinkVillaMason@gmail.com";
	
	@Test
	public static void testPatch()
	{
		RestAssured.baseURI="https://reqres.in/api";
		String response = given().log().all().body(PatchPayload.patchRequest(email))
				.when().patch("users/2")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String updatedAt = js.getString("updatedAt");
		
		System.out.println(); 
		System.out.println("================================================================"); 
		System.out.println("Modification done at :  "+updatedAt); 
			
	}

}
