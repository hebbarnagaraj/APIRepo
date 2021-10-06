package APIRESTPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETRequest {

	
	@Test
	public void getRequest() {
		
		String ExpectedEmailID="janet.weaver@reqres.in";
		
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification request = RestAssured.given();
		request.headers("Content-Type","application/json");
		
		Response response = request.request(Method.GET,"/api/users/2");
		
		System.out.println("==========Response Body :========");
		response.prettyPrint();
		
		System.out.println("============Validating Response================");
		
		JsonPath responsebody = response.getBody().jsonPath();
		String emailID = responsebody.get("data.email");
		
		Assert.assertEquals(emailID, ExpectedEmailID);
		System.out.println("Validated Email ID successfully :"+emailID);
	}
	
}
