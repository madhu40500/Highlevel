package com.highlevel.utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentinstance {

	
public static	ExtentReports createinstance()
	{
		
	
		String path= System.getProperty("user.dir")+ "/Reports/Extentreports/Extentreport.html";
		
		ExtentSparkReporter esap = new ExtentSparkReporter(path);
		esap.config().setDocumentTitle("Appointmnet booking");
		
ExtentReports ex = new ExtentReports();
ex.attachReporter(esap);
	return ex;
	}
	
}
