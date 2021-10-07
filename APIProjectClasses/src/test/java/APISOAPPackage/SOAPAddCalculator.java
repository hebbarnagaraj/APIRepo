package APISOAPPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SOAPAddCalculator {
	
	String firstDigitadd=System.getProperty("firstDigitadd");
	String secandDigitadd=System.getProperty("secandDigitadd");
	
	@Test
	public void SOAPAddCalc() {
		
		
		
		
		RestAssured.baseURI="http://dneonline.com";
		RequestSpecification request = RestAssured.given();
		request.headers("Content-Type","text/xml; charset=utf-8");
		request.headers("SOAPAction","http://tempuri.org/Add");
		
		request.body(requestBody);
		
		Response response = request.request(Method.POST,"/calculator.asmx");
		
		int status = response.getStatusCode();
		Assert.assertEquals(status, 200);
		
		System.out.println("==========Response Body :========");
		response.prettyPrint();
		System.out.println("==============================");
		
		String result = response.getBody().xmlPath().getString("AddResult");
		
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
