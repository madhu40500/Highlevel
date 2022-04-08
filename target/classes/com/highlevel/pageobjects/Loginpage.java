package com.highlevel.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.highlevel.utilities.Logs_Reports;

public class Loginpage {

	public WebDriver driver;
	//Logs_Reports class is used to log the steps in file(logs/printf) and extentreports. 

	Logs_Reports logreport;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logreport = new Logs_Reports();
	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement typeEmail;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement typePassword;

	@FindBy(xpath = "//button[normalize-space()='Sign in']")
	private WebElement clickOnSignin;

	public void signin() {
		try {
			typeEmail.sendKeys("madhuvanapalli007@gmail.com");
			logreport.logs_reportsForSendkeys(typeEmail, "madhuvanapalli007@gmail.com");
		} catch (Throwable t) {
			logreport.logs_reportsForSendkeys(typeEmail, t);
		}
		try {
			typePassword.sendKeys("Test@123");
			logreport.logs_reportsForSendkeys(typePassword, "Test@123");
		} catch (Throwable t) {
			logreport.logs_reportsForSendkeys(typePassword, t);
		}
		try {
			clickOnSignin.click();
			logreport.logs_reportsForClick(clickOnSignin);
		} catch (Throwable t) {
			logreport.logs_reportsForClick(clickOnSignin, t);
		}
	}

}
