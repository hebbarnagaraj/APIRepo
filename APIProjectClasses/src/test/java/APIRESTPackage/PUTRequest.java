package APIRESTPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUTRequest {

	
	String userNameUpdate=System.getProperty("userNameUpdate");
	String userJobUpdate=System.getProperty("userJobUpdate");
	
	@Test
	public void PutRequest() {

		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification request = RestAssured.given();
		request.headers("Content-Type","application/json");
		request.body(requestbody);
		Response response = request.request(Method.PUT,"/api/users/2");
		
		int status = response.getStatusCode();
		Assert.assertEquals(status, 200);
		
		System.out.println("==========Response Body :========");
		response.prettyPrint();
		System.out.println("==============================");
		
	}
	String requestbody="{\r\n" + 
			"    \"name\": \""+userNameUpdate+"\",\r\n" + 
			"    \"job\": \""+userJobUpdate+"\"\r\n" + 
			"}";
}
