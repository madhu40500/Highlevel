package com.highlevel.utilities;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.highlevel.base.Baseclass;
import com.highlevel.base.Listeners;

public class Logs_Reports extends Baseclass {

	public void logs_reportsForClick(WebElement s) {
		String locator = s.toString().split("-> ")[1];
		log.info("Clicked on elemnet:  " + locator);
		Listeners.test.log(Status.INFO, "Clicked on elemnet:  " + locator);
	}

	public void logs_reportsForClick(WebElement s, Throwable t) {
		log.error("Error on clicking elemnet");
		Listeners.test.log(Status.FAIL, "Error on clicking elemnet" + " Error log is:  " + t.getMessage());

	}

	public void logs_reportsForSendkeys(WebElement s, String value) {
		String locator = s.toString().split("-> ")[1];
		log.info("cliked on elemnet : " + locator + " value typed is : " + value);
		Listeners.test.log(Status.INFO, "cliked on elemnet :" + locator + " value typed is :" + value);
	}

	public void logs_reportsForSendkeys(WebElement s, Throwable t) {
		log.error("Error on clicking elemnet");
		Listeners.test.log(Status.FAIL, "Error on clicking elemnet" + " Error log is:  " + t.getMessage());

	}

}
