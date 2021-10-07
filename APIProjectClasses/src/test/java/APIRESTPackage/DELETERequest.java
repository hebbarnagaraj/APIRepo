package APIRESTPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETERequest {

	
	@Test
	public void DeleteRequest() {
		
		RestAssured.baseURI="https://petstore.swagger.io";
		
		RequestSpecification request = RestAssured.given();
		request.headers("Content-Type","application/json");
		
		Response response = request.request(Method.DELETE,"/v2/pet/3000");
		
		int status = response.getStatusCode();
		Assert.assertEquals(status, 200);
		
		System.out.println("==========Response Body :========");
		response.prettyPrint();
		
	}
}
