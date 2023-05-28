package testAPIs;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static  io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import payload.AddPlace;
import payload.UpdatePlace;

import static org.hamcrest.Matchers.*;

public class UpdateCreatedPlace {

	public static void main(String[] args) {
		 RestAssured.baseURI="https://rahulshettyacademy.com";
		 
		 //Creating a place and posting to GoogleMap
		 
		String  response =   given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
										 .body(AddPlace.createPlace())
										 .when().post("/maps/api/place/add/json")
										 .then().log().all().statusCode(200).header("Access-Control-Allow-Methods", "POST").extract().response().asString();
		System.out.println();
		System.out.println(response);
		
		//extracting " Place ID " from response body using JsonPath class
		
		JsonPath js = new JsonPath(response);
		String placeID = js.getString("place_id");
		
		System.out.println("Extrected Place_ID from response body is : "+ placeID);
		
		//Updating the place with new Address using PUT method
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(UpdatePlace.upgradePlace(placeID ))
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		//retrieving and printing the changed addess on console using GET method
		
		String updateResponse = given().log().all().queryParam("key", "qaclick123")
													.queryParam("place_id",placeID)
													.when().get("/maps/api/place/get/json")
													.then().log().all().assertThat().statusCode(200).extract().response().asString();
			
		JsonPath json= new JsonPath(updateResponse);
		String updatedAddress = json.getString("address");
		System.out.println("The modified address is : "+ updatedAddress);
		

	}

}
