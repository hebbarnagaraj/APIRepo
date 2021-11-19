package APIRESTPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basePackage.baseClass;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class PUTRequest extends baseClass{

	
	String petIDPUT=System.getProperty("petIDPUT");
	String catagNamePUT=System.getProperty("catagNamePUT");
	String testUserNamePUT=System.getProperty("testUserNamePUT");
	String photoUrlsPUT=System.getProperty("photoUrlsPUT");
	String tagNamePUT=System.getProperty("tagNamePUT");
	
	@Test
	public void PutRequest() {

		request.headers("Content-Type","application/json");
		test.log(LogStatus.INFO, "Headers Added successfully");
		
		request.body(requestbody);
		test.log(LogStatus.INFO, "Request Payload Added successfully");
		
		Response response = request.request(Method.PUT,"v2/pet");
		test.log(LogStatus.INFO, "Request Sent successfully");
		
		int status = response.getStatusCode();
		if(status==200) {
			Assert.assertEquals(status, 200);
			test.log(LogStatus.PASS, "Response Status Code is Validated successfully and Value is "+status);
		}
		else {
			test.log(LogStatus.FAIL, "Response Status Code is Not Correct  and Value is "+status);
			Assert.fail();
		}	
		
		System.out.println("==========Response Body :========");
		response.prettyPrint();
		System.out.println("==============================");
		test.log(LogStatus.INFO, "Response Payload is : "+response.prettyPrint());
		
	}
	String requestbody="{\r\n" + 
			"  \"id\":"+ petIDPUT+",\r\n" + 
			"  \"category\": {\r\n" + 
			"    \"id\": "+petIDPUT+",\r\n" + 
			"    \"name\": \""+catagNamePUT+"\"\r\n" + 
			"  },\r\n" + 
			"  \"name\": \""+testUserNamePUT+"\",\r\n" + 
			"  \"photoUrls\": [\r\n" + 
			"    \""+photoUrlsPUT+"\"\r\n" + 
			"  ],\r\n" + 
			"  \"tags\": [\r\n" + 
			"    {\r\n" + 
			"      \"id\": "+petIDPUT+",\r\n" + 
			"      \"name\": \""+tagNamePUT+"\"\r\n" + 
			"    }\r\n" + 
			"  ],\r\n" + 
			"  \"status\": \"available\"\r\n" + 
			"}";
}
