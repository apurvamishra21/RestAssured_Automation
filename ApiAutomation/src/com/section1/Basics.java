package com.section1;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import files.Payload;
import io.restassured.path.json.JsonPath;
 

import static io.restassured.RestAssured.*;

public class Basics {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
// validate if Add Place API is working as expected 
		//Add place-> Update Place with New Address -> Get Place to validate if New address is present in response
		
		//given - all input details 
		//when - Submit the API -resource,http method
		//Then - validate the response\
		
		//add place 
		
	RestAssured.baseURI= "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.41 (Ubuntu)");
		
		
	//update place api
	
	
		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);//for parsing json
		String placeId = js.getString("place_id");
		
		System.out.println(placeId);
		
		//update place api using put HTTP method
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeId+"\",\r\n" + 
				"\"address\":\"70 Summer walk, USA\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
	
	
	
	}

}
//incorrect one
//.then().assertThat().statusCode(209);
/*
Exception in thread "main" java.lang.AssertionError: 1 expectation failed.
Expected status code <209> but was <200>.*/
//Add Place API and update it

//here we have to update the place id for which we have got the response from Add Place Api
//Add place -> Update Place with New Address - > Get Place to validate if new address is present in response