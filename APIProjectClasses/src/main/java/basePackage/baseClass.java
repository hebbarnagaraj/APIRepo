package basePackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class baseClass {

	
	public static ExtentReports reports;
	public static ExtentTest test;
	public static RequestSpecification request;
	
	private static long minutes = System.currentTimeMillis();
	private static String extentReportpath=System.getProperty("user.dir")+"\\ExtentReports\\HTMLTestReport"+minutes+".html";
	
	@BeforeClass
	public static void reportsetUp() {
		reports=new ExtentReports(extentReportpath);
		test=reports.startTest("================REST API Test Suite==============");
	}
	
	@AfterClass
	public static void publishReports() {
		reports.endTest(test);
		reports.flush();
	}

	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI="https://petstore.swagger.io/";
		request=RestAssured.given();
	}
}
