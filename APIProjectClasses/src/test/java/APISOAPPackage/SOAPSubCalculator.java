package APISOAPPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SOAPSubCalculator {

	
	String firstDigitsub=System.getProperty("firstDigitsub");
	String secandDigitsub=System.getProperty("secandDigitsub");
	
	@Test
	public void SOAPSubCalc() {
		RestAssured.baseURI="http://dneonline.com";
		RequestSpecification request = RestAssured.given();
		request.headers("Content-Type","text/xml; charset=utf-8");
		request.headers("SOAPAction","http://tempuri.org/Subtract");
		
		request.body(requestBody);
		
		Response response = request.request(Method.POST,"/calculator.asmx");
		
		int status = response.getStatusCode();
		Assert.assertEquals(status, 200);
		
		System.out.println("==========Response Body :========");
		response.prettyPrint();
		System.out.println("==============================");
		
		String result = response.getBody().xmlPath().getString("SubtractResult");
		
		System.out.println("Result is :"+result);
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
