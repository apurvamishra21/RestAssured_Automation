package files;

import io.restassured.path.json.JsonPath;


public class ReUsableMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static JsonPath rawToJson(String response)
	{
		JsonPath js1 = new JsonPath(response);
		return js1;
		
	}
	
	

}
