package APIRESTPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basePackage.baseClass;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class POSTRequest extends baseClass{
	
	String petIDPOST=System.getProperty("petIDPOST");
	String catagNamePOST=System.getProperty("catagNamePOST");
	String testUserNamePOST=System.getProperty("testUserNamePOST");
	String photoUrlsPOST=System.getProperty("photoUrlsPOST");
	String tagNamePOST=System.getProperty("tagNamePOST");
	
	
	@Test
	public void PostRequest() {

		request.headers("Content-Type","application/json");
		test.log(LogStatus.INFO, "Headers Added successfully");
		
		request.body(requestbody);
		test.log(LogStatus.INFO, "Request Payload Added successfully");
		
		Response response = request.request(Method.POST,"v2/pet");
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
			"  \"id\":"+ petIDPOST+",\r\n" + 
			"  \"category\": {\r\n" + 
			"    \"id\": "+petIDPOST+",\r\n" + 
			"    \"name\": \""+catagNamePOST+"\"\r\n" + 
			"  },\r\n" + 
			"  \"name\": \""+testUserNamePOST+"\",\r\n" + 
			"  \"photoUrls\": [\r\n" + 
			"    \""+photoUrlsPOST+"\"\r\n" + 
			"  ],\r\n" + 
			"  \"tags\": [\r\n" + 
			"    {\r\n" + 
			"      \"id\": "+petIDPOST+",\r\n" + 
			"      \"name\": \""+tagNamePOST+"\"\r\n" + 
			"    }\r\n" + 
			"  ],\r\n" + 
			"  \"status\": \"available\"\r\n" + 
			"}";

}
