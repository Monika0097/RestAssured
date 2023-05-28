package testAPIs;

import io.restassured.RestAssured;
import payload.AddPlace;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class postPlace {

	public static void main(String[] args) {
	
		RestAssured.baseURI="https://rahulshettyacademy.com" ;
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(AddPlace.createPlace())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("server","Apache/2.4.41 (Ubuntu)");

	}

}
