package TestSuitePackage;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APISOAPPackage.SOAPAddCalculator;
import APISOAPPackage.SOAPSubCalculator;
import basePackage.baseClassSOAP;

public class TestSuiteSOAP extends baseClassSOAP{
	
	String classname=System.getProperty("classname");
	
	
	@Test (priority=0)
	public void SOAPAddRequestTest() {
		test.log(LogStatus.INFO, "===============Validating SOAP ADD Request================");
		System.out.println("===========Sending SOAP ADD Request=================");
		SOAPAddCalculator soapaddreq = new SOAPAddCalculator();
		soapaddreq.SOAPAddCalc();
	}
	@Test (priority=1)
	public void SOAPSubRequestTest() {
		test.log(LogStatus.INFO, "===============Validating SOAP SUB Request================");
		System.out.println("===========Sending SOAP SUB Request=================");
		SOAPSubCalculator soapsubreq = new SOAPSubCalculator();
		soapsubreq.SOAPSubCalc();
	}

}
