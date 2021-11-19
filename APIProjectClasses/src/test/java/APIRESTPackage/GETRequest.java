package APIRESTPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basePackage.baseClass;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class GETRequest extends baseClass{

	String petIDGET = System.getProperty("petIDGET");
	
	@Test
	public void getRequest() {

		request.headers("Content-Type","application/json");
		test.log(LogStatus.INFO, "Headers Added successfully");
		
		Response response = request.request(Method.GET,"v2/pet/"+petIDGET+"");
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
		test.log(LogStatus.PASS, "Response Payload is : "+response.prettyPrint());
	}
	
}
