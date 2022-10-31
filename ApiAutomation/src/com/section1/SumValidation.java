package com.section1;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {

	//verify sum of individual course is equal to total sum
		
		@Test
		public void sumOfCourses()
		{
			int sum =  0;
			JsonPath js = new JsonPath(Payload.CoursePrice());
			int count = js.getInt("courses.size()");
			for(int i = 0 ; i < count ; i++) {
				
				int price = js.getInt("courses["+i+"].price");
				int copies = js.getInt("courses["+i+"].copies");
				int amount = price * copies;
				System.out.println(amount);
				sum = sum + amount;
				
			}
			
			System.out.println(sum);
		}

	}
/*
 * 300
160
450
420
1330
PASSED: sumOfCourses*/
 

