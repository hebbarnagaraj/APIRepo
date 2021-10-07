package TestSuitePackage;

import org.testng.annotations.Test;

import APIRESTPackage.DELETERequest;
import APIRESTPackage.GETRequest;
import APIRESTPackage.POSTRequest;
import APIRESTPackage.PUTRequest;
import APISOAPPackage.SOAPAddCalculator;
import APISOAPPackage.SOAPSubCalculator;

public class TestSuite {
	
	
	String classname=System.getProperty("classname");
	
	@Test(priority=0)
	public void RESTServices() {
		
		System.out.println("===========Sending GET Request=================");
		GETRequest getReq = new GETRequest();
		getReq.getRequest();
		
		System.out.println("===========Sending POST Request=================");
		POSTRequest postReq = new POSTRequest();
		postReq.PostRequest();
		
		System.out.println("===========Sending PUT Request=================");
		PUTRequest putReq = new PUTRequest();
		putReq.PutRequest();
		
		System.out.println("===========Sending DELETE Request=================");
		DELETERequest delreq = new DELETERequest();
		delreq.DeleteRequest();
		
		
	}

	@Test (priority=1)
	public void SOAPServices() {
		try {
			
			System.out.println("===========Sending SOAP Add Calculator Request=================");
			SOAPAddCalculator soapAddcalc = new SOAPAddCalculator();
			soapAddcalc.SOAPAddCalc();
			
			System.out.println("===========Sending SOAP Substract Calculator Request=================");
			SOAPSubCalculator soapSubcalc = new SOAPSubCalculator();
			soapSubcalc.SOAPSubCalc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
