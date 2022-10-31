package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;



import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class DynamicJson {
	//correct code to addbook
	/*@Test(dataProvider="BooksData")
	public void addBook(String isbn , String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().header("Content-Type" , "application/json").
		body(Payload.AddBook(isbn , aisle)).
		when()
		.post("/Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js = ReUsableMethods.rawToJson(response);
		String id = js.get("ID");
		System.out.println(id);
		
		
		
		
	}*/

	/*@DataProvider(name = "BooksData")
	public Object[][] getData() {
		
		
		
		return new Object[][] { {"drey" , "467"},{"osy" , "567"},{"im" , "467"} };
	}*/
	//check code to delete book
	@Test(dataProvider="BooksData")
	public void deleteBook(String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().header("Content-Type" , "application/json").
		body(Payload.DeleteBook(aisle)).
		when()
		.post(":/Library/DeleteBook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js = ReUsableMethods.rawToJson(response);
		String id = js.get("ID");
		System.out.println(id);
		
		
		
		
	}

	@DataProvider(name = "BooksData")
	public Object[] getData() {
		
		
		
		return new Object[]  {"467"};
	}

}
