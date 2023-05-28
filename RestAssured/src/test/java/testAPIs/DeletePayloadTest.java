package testAPIs;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payload.DeletePayload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeletePayloadTest {
	
	@Test
	public void testDelete()
	{
	   RestAssured.baseURI= "https://reqres.in/api";
	  String response = given().log().all().body(DeletePayload.deleteRequest())
			   .when().delete("users/2")
			   .then().log().all().assertThat().statusCode(204).extract().response().asString();
			   
	  System.out.println(response);  
	

    }
	}
