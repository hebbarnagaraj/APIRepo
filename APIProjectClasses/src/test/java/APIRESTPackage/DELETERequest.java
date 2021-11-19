package APIRESTPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basePackage.baseClass;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class DELETERequest extends baseClass{

	String petIDDelete = System.getProperty("petIDDelete");
	
	@Test
	public void DeleteRequest() {
	
		
		request.headers("Content-Type","application/json");
		test.log(LogStatus.INFO, "Headers Added successfully");
		
		
		Response response = request.request(Method.DELETE,"v2/pet/"+petIDDelete+"");
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
}
