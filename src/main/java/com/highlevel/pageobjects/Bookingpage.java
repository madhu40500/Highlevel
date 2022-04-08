package com.highlevel.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.highlevel.base.Baseclass;
import com.highlevel.utilities.Constants;
import com.highlevel.utilities.Logs_Reports;

public class Bookingpage extends Baseclass {

	public WebDriver driver;
	//Logs_Reports class is used to log the steps in file(logs/printf) and extentreports. 
	Logs_Reports logreport;

	public Bookingpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logreport = new Logs_Reports();
	}

	@FindBy(xpath = "//div[@class='widgets-slot-block']//li[1]")
	private WebElement slotTime;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	private WebElement clickOnContinue;

	@FindBy(xpath = "//td[@class='vdpCell selectable']//div[@class='vdpCellContent']")
	private List<WebElement> selectableDates;
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	private WebElement typeFirstName;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement typeLastName;
	
	@FindBy(xpath = "//input[@placeholder='Phone']")
	private WebElement typeMobile;
	
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement typeEmail;
	
	@FindBy(xpath = "//button[@class='btn btn-schedule']")
	private WebElement clickOnSchedule;
	
	@FindBy(xpath="(//div[@class='booking-info-value'])[2]")
	private WebElement meetingLocation;
	
	@FindBy(xpath="//h5[@class='confirmation-message']")
	private WebElement conformMessage;
	
	 
	public void bookSlot() {
		String time = slotTime.getText().split(":")[0];
		int date = 0;
		while (!time.equals("08")) {
			selectableDates.get(date).click();
			date++;
			time = slotTime.getText().split(":")[0];
		}
		slotTime.click();
		clickOnContinue.click();
	}
	
	public void enterInfo()
	{

		try{
			typeFirstName.sendKeys(Constants.firstName);	
			logreport.logs_reportsForSendkeys(typeFirstName, Constants.firstName);
		} catch (Throwable t) {
			logreport.logs_reportsForSendkeys(typeFirstName, t);
		}
		try {
		typeLastName.sendKeys(Constants.lastName);
		logreport.logs_reportsForSendkeys(typeLastName, Constants.lastName);
		} catch (Throwable t) {
			logreport.logs_reportsForSendkeys(typeLastName, t);
		}
		try {
		typeMobile.sendKeys("8557054517");
		logreport.logs_reportsForSendkeys(typeMobile, "8557054517");
		} catch (Throwable t) {
			logreport.logs_reportsForSendkeys(typeMobile, t);
		}
		try {
		typeEmail.sendKeys(Constants.email);
		logreport.logs_reportsForSendkeys(typeEmail, Constants.email);
		} catch (Throwable t) {
			logreport.logs_reportsForSendkeys(typeEmail, t);
		}
		try {
		clickOnSchedule.click();
		logreport.logs_reportsForClick(clickOnSchedule);
		} catch (Throwable t) {
			logreport.logs_reportsForClick(clickOnSchedule, t);
		}
}

	public String meetingLocation()
	{
		return meetingLocation.getText();
	}
	
	public String conformMessage()
	{
		return conformMessage.getText();
	}
	
}