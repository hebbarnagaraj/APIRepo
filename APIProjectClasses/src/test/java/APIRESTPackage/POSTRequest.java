package APIRESTPackage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTRequest {
	
	String userName=System.getProperty("userName");
	String userJob=System.getProperty("userJob");
	
	@Test
	public void PostRequest() {

		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification request = RestAssured.given();
		request.headers("Content-Type","application/json");
		request.body(requestbody);
		Response response = request.request(Method.POST,"/api/users");
		
		System.out.println("==========Response Body :========");
		response.prettyPrint();
		System.out.println("==============================");
		
		JsonPath reponsebody = response.getBody().jsonPath();
		String userID = reponsebody.get("id").toString();
		
		System.out.println("New User Created and User ID is : "+userID);
		System.out.println("==============================");
		
		
	}
	String requestbody="{\r\n" + 
			"    \"name\": \""+userName+"\",\r\n" + 
			"    \"job\": \""+userJob+"\"\r\n" + 
			"}";

}
