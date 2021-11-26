package APIRESTPackage;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relevantcodes.extentreports.LogStatus;

import POJOPackage.POSTRequestPayload;
import POJOPackage.POSTRequestPayload.category;
import POJOPackage.POSTRequestPayload.tags;
import basePackage.baseClass;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class PUTRequest extends baseClass{

	
	String petIDPUT=System.getProperty("petIDPUT");
	String catagNamePUT=System.getProperty("catagNamePUT");
	String testUserNamePUT=System.getProperty("testUserNamePUT");
	String photoUrlsPUT=System.getProperty("photoUrlsPUT");
	String tagNamePUT=System.getProperty("tagNamePUT");
	String requestPayload;
	
	@Test
	public void PutRequest() {
		
		List<String> photoUrls = new ArrayList<String>();
		List<tags> tagslist=new ArrayList<tags>();
		
		
		request.headers("Content-Type","application/json");
		test.log(LogStatus.INFO, "Headers Added successfully");
		
		
		category catagory = new POSTRequestPayload.category();
		catagory.setId(petIDPUT);
		catagory.setName(catagNamePUT);
		
		tags tags = new POSTRequestPayload.tags();
		tags.setId(petIDPUT);
		tags.setName(tagNamePUT);
		tagslist.add(tags);
		
		photoUrls.add(photoUrlsPUT);
		
		POSTRequestPayload payloadobj = new POSTRequestPayload();
		
		payloadobj.setId(petIDPUT);
		payloadobj.setCategory(catagory);
		payloadobj.setName(testUserNamePUT);
		payloadobj.setPhotoUrls(photoUrls);
		payloadobj.setTags(tagslist);
		payloadobj.setStatus("available");
		
		try {
			
			 requestPayload = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(payloadobj);
			 test.log(LogStatus.PASS, "Request Payload Generated :"+requestPayload);
			 
			 System.out.println("Request Payload is :"+requestPayload);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		request.headers("Content-Type","application/json");
		test.log(LogStatus.INFO, "Headers Added successfully");
		
		request.body(requestPayload);
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
}
