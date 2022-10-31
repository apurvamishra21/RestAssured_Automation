package com.section2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import files.Payload;
import io.restassured.RestAssured;

public class StaticJson {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		//Step 1 : convert the content of the addPlace json file to String -> method in java that can convert the content of the file into Byte
		//-> Convert byte data to string -> Files.readAllBytes(path) pass the file path -> Go to the respective file -> right click on file name -> 
		//copy full path to clipboard
		//"D:\\Technical\\software docs\\Api Notes\\addPlace.json"	
		//Files.readAllBytes(Paths.get("D:\\Technical\\software docs\\Api Notes\\addPlace.json") - this will give the output in byte format 
		/*but we need in string format , so create a object of string*/
			
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("D:\\Technical\\software docs\\Api Notes\\addPlace.json")))).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.41 (Ubuntu)");
	}

}
