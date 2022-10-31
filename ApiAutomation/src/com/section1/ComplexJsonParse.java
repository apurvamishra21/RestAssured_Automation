package com.section1;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(Payload.CoursePrice());
		//Print No of Courses returned by API 
		
		int count = js.getInt("courses.size()");
		System.out.println(count);//3
		
		//Print the purchase amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);//910
		
		//Print title of the first course
		String titleFirstCourse = js.get("courses[0].title");
		
		System.out.println(titleFirstCourse);//Selenium Python
		
		
		//Print All Courses titles and their respective prices
		for(int i = 0;i < count ; i++)
		{
			String courseTitles = js.get("courses["+i+"].title");
			System.out.println(courseTitles);
		}
		
		
		String titleFirstCourse1 = js.get("courses[2].title");
		System.out.println(titleFirstCourse1);
		for(int i = 0;i < count ; i++)
		{
			String courseTitles = js.get("courses["+i+"].title");
			System.out.println(js.get("courses["+i+"].title").toString());
			
		}
		
		System.out.println("Print no of copies sold by RPA Course");
		
		//even if we displace RPA from its original position still we will get the same output	
		
		for(int i = 0 ; i < count ; i++)
		{
			String courseTitles = js.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA")) {
				
				int copies = js.get("courses["+i+"].copies");
				System.out.println(copies);
				break;
			}
		}
		
	}

}
/*
4
910
Selenium Python
Selenium Python
Cypress
RPA
Appium
RPA
Selenium Python
Cypress
RPA
Appium
Print no of copies sold by RPA Course
10
*/
