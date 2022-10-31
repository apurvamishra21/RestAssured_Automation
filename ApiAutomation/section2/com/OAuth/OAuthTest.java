package com.OAuth;
import static io.restassured.RestAssured.given;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.path.json.JsonPath;

public class OAuthTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("srinath19830");
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("1233");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		//Parsing logic is imp
		String url = driver.getCurrentUrl();
		String partialcode = url.split("code=")[1];
		String code = partialcode.split("&scope")[0];
		System.out.println(code);
		
		
		
		
		//GetAuthorization Code Request
		
		String accessTokenResponse = 
		given().urlEncodingEnabled(false)
		.queryParams("code" , code)//code is generated once we pass the authorization server url
		.queryParams("client_id" , "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret" , "erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type" , "authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");
		
		//GetAccessToken Request :
		
		
		String response = given().queryParam("access_token", accessToken)
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(response);
	}

}

//code is blank so access token fails
//Next Q is how to automate authorization code
//RestAssured will not consider special characters so 'C' or any other special character is converted into numeric values.
//urlEncodingEnabled(false) to avoid any encoding like converted  '%'into numeric values else the code will be invalid

//from 2020 google has stop sign in with gmail

//so how to do this 

/*1.First manually hit the url
2 enter details "username" & "password"
so instead of 	String url = driver.getCurrentUrl(); copy the url manually and paste it and comment the code written in the script prior to this

In case of client credentials pass the scope in quer param in GetAuthorization Code Request
*
*/




