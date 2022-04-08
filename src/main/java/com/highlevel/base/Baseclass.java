package com.highlevel.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.highlevel.utilities.Extentinstance;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
* The TestBase class is the base class to fetch environment specific configuration parameters from 
* Jenkins/Maven. Based on the parameters, it performs the browser setup and tear-down functions.
* 
* @author  madhu vanapalli
*/



public class Baseclass {

public WebDriver driver; 
public static Properties config;
public static ExtentTest test;
public static Logger log = LogManager.getLogger(Baseclass.class.getName());
public ExtentReports ex = Extentinstance.createinstance();
public String url;
public static WebDriverWait wait;

//Automation suite setup method to configure and instantiate a particular browser
public WebDriver setup() throws IOException
{
	//Environment specific properties file loading
	config = new Properties();
	String pathconfig = System.getProperty("user.dir")+"/src/main/java/com/highlevel/properties/config.properties";
	FileInputStream fisc= new FileInputStream(pathconfig);
	config.load(fisc);
	log.info("loaded config file");
	url = config.getProperty("url");
//This let's you take the browsername from maven,jenkins or from config file and give priority to mvn, jenkins.
String browser_properties =config.getProperty("browser");
String browser_mvn=System.getProperty("browser");
String browsername = (browser_mvn==null)?browser_properties:browser_mvn;
	//Browser configuration - can add more browsers and remote driver here
 if(browsername.equalsIgnoreCase("chrome"))
 {
	 WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
	 log.info(browsername+" browser is intialised");
 }
 else if (browsername.equalsIgnoreCase("Firefox")) {
		WebDriverManager.firefoxdriver().setup(); //can also use set property method for browser executables
		driver = new FirefoxDriver();
  }
 else if (browsername.equalsIgnoreCase("IE")) {
	 WebDriverManager.iedriver().setup();
     driver = new InternetExplorerDriver();
 }
 else {
     throw new RuntimeException("Browser type unsupported");
 }
	
	driver.manage().window().maximize();
	//Setting implicit wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	//Setting WebDriverWait with max timeout value of 10 seconds
	wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
return driver;
}

//This method takes screenshot when the test is failed, by calling it in TestListener, ontestfailure method
public String getscreeshot(String methodname, WebDriver driver) throws IOException
{

	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	String destpath = System.getProperty("user.dir")+"/Reports/screenshots/"+methodname+".png";

FileUtils.copyFile(screenshotFile, new File(destpath)); 
return destpath;
}
//closes the browser after each class execution
@AfterClass
public void teardown()
{
	driver.quit();
}


}
