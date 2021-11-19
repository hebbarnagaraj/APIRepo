package TestSuitePackage;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APIRESTPackage.DELETERequest;
import APIRESTPackage.GETRequest;
import APIRESTPackage.POSTRequest;
import APIRESTPackage.PUTRequest;
import basePackage.baseClass;

public class TestSuiteREST extends baseClass{
	
	
	String classname=System.getProperty("classname");
	
	@Test (priority=0)
	public void POSTRequestTest() {
		test.log(LogStatus.INFO, "=====================Validating REST POST Request=============");
		System.out.println("===========Sending POST Request=================");
		POSTRequest postReq = new POSTRequest();
		postReq.PostRequest();
	}
	@Test (priority=1)
	public void PUTRequestTest() {
		test.log(LogStatus.INFO, "=====================Validating REST PUT Request=============");
		System.out.println("===========Sending PUT Request=================");
		PUTRequest putReq = new PUTRequest();
		putReq.PutRequest();
	}
	@Test (priority=2)
	public void GETRequestTest() {
		test.log(LogStatus.INFO, "=====================Validating REST GET Request=============");
		System.out.println("===========Sending GET Request=================");
		GETRequest getReq = new GETRequest();
		getReq.getRequest();
	}
	@Test (priority=3)
	public void DELETERequestTest() {
		test.log(LogStatus.INFO, "=====================Validating REST DELETE Request=============");
		System.out.println("===========Sending DELETE Request=================");
		DELETERequest delreq = new DELETERequest();
		delreq.DeleteRequest();
	}

}
