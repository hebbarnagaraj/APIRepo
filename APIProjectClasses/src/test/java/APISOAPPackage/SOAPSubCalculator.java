package APISOAPPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basePackage.baseClassSOAP;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class SOAPSubCalculator extends baseClassSOAP{

	
	String firstDigitsub=System.getProperty("firstDigitsub");
	String secandDigitsub=System.getProperty("secandDigitsub");
	
	@Test
	public void SOAPSubCalc() {
		
		request.headers("Content-Type","text/xml; charset=utf-8");
		request.headers("SOAPAction","http://tempuri.org/Subtract");
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
		
		String result = response.getBody().xmlPath().getString("SubtractResult");
		
		System.out.println("Result is :"+result);
		test.log(LogStatus.PASS, "Response Payload Validated successfully and Result is  "+result);
		
		System.out.println("==============================");
	}
	String requestBody="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" + 
			"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
			"  <soap:Body>\r\n" + 
			"    <Subtract xmlns=\"http://tempuri.org/\">\r\n" + 
			"      <intA>"+firstDigitsub+"</intA>\r\n" + 
			"      <intB>"+secandDigitsub+"</intB>\r\n" + 
			"    </Subtract>\r\n" + 
			"  </soap:Body>\r\n" + 
			"</soap:Envelope>";
	
}
