package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class getReportObject {
	public static ExtentReports extent;
	
	public static ExtentReports getReport() {
		
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	System.out.println("Current working directory in Java : " + path);
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("WebAutomationResults");
	reporter.config().setDocumentTitle("TestResults");
     extent = new ExtentReports();
	extent.attachReporter(reporter);
	return extent;

	}
}
