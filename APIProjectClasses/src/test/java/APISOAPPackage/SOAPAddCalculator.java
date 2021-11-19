package APISOAPPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basePackage.baseClassSOAP;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SOAPAddCalculator extends baseClassSOAP{
	
	String firstDigitadd=System.getProperty("firstDigitadd");
	String secandDigitadd=System.getProperty("secandDigitadd");
	
	@Test
	public void SOAPAddCalc() {
		
		request.headers("Content-Type","text/xml; charset=utf-8");
		request.headers("SOAPAction","http://tempuri.org/Add");
		test.log(LogStatus.INFO, "Headers Added successfully");
		
		request.body(requestBody);
		test.log(LogStatus.INFO, "Request Payload Added successfully");
		Response response = request.request(Method.POST,"/calculator.asmx");
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
		
		String result = response.getBody().xmlPath().getString("AddResult");
		test.log(LogStatus.PASS, "Response Payload Validated successfully and Result is  "+result);
		System.out.println("Result is :"+result);
		System.out.println("==============================");
		
	}
	
	String requestBody="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" + 
			"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
			"  <soap:Body>\r\n" + 
			"    <Add xmlns=\"http://tempuri.org/\">\r\n" + 
			"      <intA>"+firstDigitadd+"</intA>\r\n" + 
			"      <intB>"+secandDigitadd+"</intB>\r\n" + 
			"    </Add>\r\n" + 
			"  </soap:Body>\r\n" + 
			"</soap:Envelope>";

}
